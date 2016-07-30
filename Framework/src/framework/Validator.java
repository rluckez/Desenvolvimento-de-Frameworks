package framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import annotation.ValidatorImplementation;
import annotationimpl.ValidatorParser;
import excpetion.InvalidAnnotatedAttributeException;
import notifier.ErrorNotifier;
import report.ConsoleReport;
import report.ReportGenerator;

/**
 * 
 * @author Rafael
 *
 */
public class Validator {

	private List<ValidatorError> errors = new ArrayList<>();
	private ReportGenerator reportGenerator;
	private int numberOfValidations;
	private List<ErrorNotifier> notifiers = new ArrayList<>();

	/**
	 * Construtor default cria uma instancia do gerador de relat�rio em console
	 */
	public Validator(){
		reportGenerator = new ConsoleReport();
	}
	
	/**
	 * Permite a inje��o da implementa��o do gerador de relat�rio diretamente pelo construtor
	 * @param reportGenerator
	 */
	public Validator(ReportGenerator reportGenerator){
		this.reportGenerator = reportGenerator;
	}
	
	/**
	 * Busca pela anota��o de valida��o e se encontrada realiza o processo de valida��o do objeto
	 * @param obj
	 */
	public void validate(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			try {
				Object value = f.get(obj);
				for (Annotation an : f.getAnnotations()) {
					Class<?> anType = an.annotationType();
					if (anType.isAnnotationPresent(ValidatorImplementation.class)) {
						ValidatorImplementation fi = anType.getAnnotation(ValidatorImplementation.class);
						Class<? extends ValidatorParser> clazz = fi.value();
//						ValidatorParser validator = clazz.getDeclaredConstructor(Field.class).newInstance(f);
						ValidatorParser validator = clazz.newInstance();
						validator.setInfo(f);
						validator.readAnnotation(an);
						validator.validate(value);
						numberOfValidations++;
						if (validator.isNotValid()) {
							errors.add(validator.getError());
						}
					}
				}
			} catch (InstantiationException | InvalidAnnotatedAttributeException | IllegalAccessException | IllegalArgumentException  | SecurityException e) {
				throw new RuntimeException("Cannot validate fields", e);
			}
		}
	}

	/**
	 * Adiciona um notificador
	 * @param notifier
	 */
	public void addNotifier(ErrorNotifier notifier){
		notifiers.add(notifier);
	}
	
	/**
	 * Dispara o evento de notifica��o de todos notificadores
	 */
	public void notifyError(){
		for (ErrorNotifier n : notifiers) {
			n.notifyError(this);
		}
	}
	
	/**
	 * Gera o relat�rio baseado na implementa��o encontrada no atributo reportGenerator
	 */
	public void generateReport() {
		reportGenerator.generateReport(this);
	}

	public boolean isValid() {
		return errors.isEmpty();
	}

	public boolean isNotValid() {
		return !errors.isEmpty();
	}

	public List<ValidatorError> getErrors() {
		return errors;
	}

	public void setReportGenerator(ReportGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}

	public int getNumberOfValidations() {
		return numberOfValidations;
	}

}
