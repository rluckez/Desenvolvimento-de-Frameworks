package framework;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import annotation.Length;
import annotation.NotNull;

public class Validator {

	public Validator(){
//		this.notificadores = new ArrayList<>();
	}
	
	private List<ValidatorError> errors;

//	private List<Notificador> notificadores;
	
	public List<ValidatorError> validate(Object obj) throws IllegalArgumentException, IllegalAccessException{

		errors = new ArrayList<>();
		
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field f : fields){
			f.setAccessible(true);
			
			if(f.isAnnotationPresent(NotNull.class)){
				Object a = f.get(obj);
				if(a == null){
					ValidatorError error = new ValidatorError("O atributo " + f.getName() + " está nulo.");
					errors.add(error);
				}
			}
			
			if(f.isAnnotationPresent(Length.class)){
				Object value = f.get(obj);
				if(value == null){
					ValidatorError error = new ValidatorError("O atributo " + f.getName() + " está nulo.");
					errors.add(error);
				}
				if(value instanceof String){
					String string = (String) value;
					int min = f.getAnnotation(Length.class).min();
					int max = f.getAnnotation(Length.class).max();
					if(min >= 0 && string.length() < min){
						ValidatorError error = new ValidatorError("O atributo " + f.getName() + " não possui o mínimo de caracteres necessários.");
						errors.add(error);
					}
					if(max >= 0 && string.length() > max){
						ValidatorError error = new ValidatorError("O atributo " + f.getName() + " possui mais caracteres que o máximo permitido.");
						errors.add(error);
					}
				}
			}
		}
		return errors;
	}
	
//	public void adicionaNotificador(Notificador notificador){
//		this.notificadores.add(notificador);
//	}
//	
//	public void notifica(){
//		for(Notificador n : notificadores){
//			n.notifica();
//		}
//	}
	
	public List<ValidatorError> getErrors() {
		return errors;
	}

	public void setErrors(List<ValidatorError> errors) {
		this.errors = errors;
	}
	
	
	
}
