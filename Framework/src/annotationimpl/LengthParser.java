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
				ValidatorError error = new ValidatorError("Atributo " + getAttributeName() + " da classe " + getClassName() + " possui " + string.length() + " caracter(es) e o menor valor de caracteres permitido é " + min);
				setError(error);
			}
			if(max >= 0 && string.length() > max){
				ValidatorError error = new ValidatorError("Atributo " + getAttributeName() + " da classe " + getClassName() + " possui " + string.length() + " caracter(es) e o maior valor de caracteres permitido é " + max);
				setError(error);
			}
		}else{
			throw new InvalidAnnotatedAttributeException("O atributo " + getAttributeName() +" da classe " + getClassName() + " é do tipo " + getAttributeType() + " e não do tipo String.");
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		Length length = (Length) an;
		this.min = length.min();
		this.max = length.max();
	}
	
}
