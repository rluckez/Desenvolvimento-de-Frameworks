package framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import annotation.ValidatorImplementation;
import annotationimpl.ValidatorParser;
import excpetion.InvalidAnnotatedAttributeException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.validate.MetadataValidator;
import notifier.ErrorNotifier;
import report.ConsoleReport;
import report.ReportGenerator;

/**
 * 
 * @author Rafael
 *
 */
public class Validator {

	private List<ValidateError> errors = new ArrayList<>();
	private ReportGenerator reportGenerator;
	private int numberOfValidations;
	private List<ErrorNotifier> notifiers = new ArrayList<>();

	/**
	 * Construtor default cria uma instancia do gerador de relatório em console
	 */
	public Validator() {
		reportGenerator = new ConsoleReport();
	}

	/**
	 * Permite a injeção da implementação do gerador de relatório diretamente
	 * pelo construtor
	 * 
	 * @param reportGenerator
	 */
	public Validator(ReportGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}

	/**
	 * Busca pela anotação de validação e se encontrada realiza o processo de
	 * validação do objeto
	 * 
	 * @param obj
	 */
	public void validate(Object obj) {
		try {
			Class<?> objClazz = obj.getClass();
			MetadataValidator.validateMetadataOn(objClazz);
			Field[] fields = objClazz.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);

				Object value = f.get(obj);
				for (Annotation an : f.getAnnotations()) {
					Class<?> anType = an.annotationType();
					if (anType.isAnnotationPresent(ValidatorImplementation.class)) {
						ValidatorImplementation fi = anType.getAnnotation(ValidatorImplementation.class);
						Class<? extends ValidatorParser> clazz = fi.value();
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
			}
		} catch (InstantiationException | InvalidAnnotatedAttributeException | IllegalAccessException
				| IllegalArgumentException | SecurityException e) {
			throw new RuntimeException("Cannot validate fields", e);
		} catch (AnnotationValidationException e) {
			e.printStackTrace();
			throw new RuntimeException("Wrong type field annotated", e);
		}
	}

	/**
	 * Adiciona um notificador
	 * 
	 * @param notifier
	 */
	public void addNotifier(ErrorNotifier notifier) {
		notifiers.add(notifier);
	}

	/**
	 * Dispara o evento de notificação de todos notificadores
	 */
	public void notifyError() {
		for (ErrorNotifier n : notifiers) {
			n.notifyError(this);
		}
	}

	/**
	 * Gera o relatório baseado na implementação encontrada no atributo
	 * reportGenerator
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

	public List<ValidateError> getErrors() {
		return errors;
	}

	public void setReportGenerator(ReportGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}

	public int getNumberOfValidations() {
		return numberOfValidations;
	}

}
