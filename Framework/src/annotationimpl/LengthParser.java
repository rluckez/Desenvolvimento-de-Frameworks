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
				ValidatorError error = new ValidatorError("Atributo n�o possui o valor m�nimo de caracteres necess�rios");
				setError(error);
			}
			if(max >= 0 && string.length() > max){
				ValidatorError error = new ValidatorError("Atributo ultrapassou o valor m�ximo de caracteres permitidos");
				setError(error);
			}
		}else{
			throw new InvalidAnnotatedAttributeException("O atributo anotado n�o � do tipo String");
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		Length length = (Length) an;
		this.min = length.min();
		this.max = length.max();
	}
	
}
