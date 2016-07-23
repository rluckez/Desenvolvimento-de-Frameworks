package framework;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import annotation.ValidatorImplementation;
import annotationimpl.ValidatorParser;
import excpetion.InvalidAnnotatedAttributeException;

public class Validator {
	
	private List<ValidatorError> errors;

	public List<ValidatorError> validate(Object obj) throws IllegalArgumentException, IllegalAccessException, InvalidAnnotatedAttributeException{

		errors = new ArrayList<>();
		
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field f : fields){
			f.setAccessible(true);
			Object value = f.get(obj);
			
			for(Annotation an : f.getAnnotations()){
				Class<?> anType = an.annotationType();
				if(anType.isAnnotationPresent(ValidatorImplementation.class)){
					try {
						ValidatorImplementation fi = anType.getAnnotation(ValidatorImplementation.class);
						Class<? extends ValidatorParser> c = fi.value();
						ValidatorParser vr = c.newInstance();
						vr.readAnnotation(an);
						vr.validate(value);
						if(vr.isNotValid()){
							errors.add(vr.getError());
						}
					} catch (InstantiationException e) {
						e.printStackTrace();
						throw new RuntimeException("Cannot validate fields", e);
					}
				}
			}
		}
		return errors;
	}
	
	public List<ValidatorError> getErrors() {
		return errors;
	}
	
}
