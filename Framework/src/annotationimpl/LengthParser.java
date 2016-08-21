package annotationimpl;

import java.lang.annotation.Annotation;

import annotation.Length;
import excpetion.InvalidAnnotatedAttributeException;
import framework.DefaultValidateError;
import framework.ValidateError;

public class LengthParser extends ValidatorParser {

	private int min, max;
	
	@Override
	public void validate(Object obj) throws InvalidAnnotatedAttributeException {
		
		String string = (String) obj;
		if(min >= 0 && string.length() < min){
			ValidateError error = new DefaultValidateError("Atributo " + getAttributeName() + " da classe " + getClassName() + " possui " + string.length() + " caracter(es) e o valor mínimo de caracteres permitido é " + min);
			setError(error);
		}
		if(max >= 0 && string.length() > max){
			ValidateError error = new DefaultValidateError("Atributo " + getAttributeName() + " da classe " + getClassName() + " possui " + string.length() + " caracter(es) e o valor máximo de caracteres permitido é " + max);
			setError(error);
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		Length length = (Length) an;
		this.min = length.min();
		this.max = length.max();
	}
	
}
