package annotationimpl;

import java.lang.annotation.Annotation;

import annotation.IntRange;
import excpetion.InvalidAnnotatedAttributeException;
import framework.ValidatorError;

public class IntRangeParser extends ValidatorParser {

	private int min, max;
	
	@Override
	public void validate(Object obj) throws InvalidAnnotatedAttributeException {
		
		if(obj instanceof Integer){
			Integer value = (Integer) obj;
			if(value < min){
				ValidatorError error = new ValidatorError("Atributo com valor menor que o valor mínimo permitido.");
				setError(error);
			}
			if(value > max){
				ValidatorError error = new ValidatorError("Atributo com valor maior que o valor máximo permitido");
				setError(error);
			}
		}else{
			throw new InvalidAnnotatedAttributeException("O atributo anotado não é do tipo inteiro");
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		IntRange intRange = (IntRange) an;
		this.min = intRange.min();
		this.max = intRange.max();
	}
	
}
