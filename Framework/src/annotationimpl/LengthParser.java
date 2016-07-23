package annotationimpl;

import java.lang.annotation.Annotation;

import annotation.Length;
import excpetion.InvalidAnnotatedAttributeException;
import framework.ValidatorError;

public class LengthParser extends ValidatorParser {

	private int min, max;
	
	@Override
	public void validate(Object obj) throws InvalidAnnotatedAttributeException {
		
		if(obj instanceof String){
			String string = (String) obj;
			if(min >= 0 && string.length() < min){
				ValidatorError error = new ValidatorError("Atributo não possui o valor mínimo de caracteres necessários");
				setError(error);
			}
			if(max >= 0 && string.length() > max){
				ValidatorError error = new ValidatorError("Atributo ultrapassou o valor máximo de caracteres permitidos");
				setError(error);
			}
		}else{
			throw new InvalidAnnotatedAttributeException("O atributo anotado não é do tipo String");
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		Length length = (Length) an;
		this.min = length.min();
		this.max = length.max();
	}
	
}
