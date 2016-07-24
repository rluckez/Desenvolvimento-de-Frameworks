package framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import annotation.ValidatorImplementation;
import annotationimpl.ValidatorParser;
import excpetion.InvalidAnnotatedAttributeException;
import report.ConsoleReport;
import report.ReportGenerator;

public class Validator {

	private List<ValidatorError> errors = new ArrayList<>();
	private ReportGenerator reportGenerator = new ConsoleReport();
	private int numberOfValidations;

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
						ValidatorParser validator = clazz.newInstance();
						validator.readAnnotation(an);
						validator.validate(value);
						numberOfValidations++;
						if (validator.isNotValid()) {
							errors.add(validator.getError());
						}
					}
				}
			} catch (InstantiationException | InvalidAnnotatedAttributeException | IllegalAccessException e) {
				throw new RuntimeException("Cannot validate fields", e);
			}
		}
	}

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
