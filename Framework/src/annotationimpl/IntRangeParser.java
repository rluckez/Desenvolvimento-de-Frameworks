package annotationimpl;

import java.lang.annotation.Annotation;

import annotation.IntRange;
import excpetion.InvalidAnnotatedAttributeException;
import framework.DefaultValidateError;
import framework.ValidateError;

public class IntRangeParser extends ValidatorParser {

	private int min, max;
	
	@Override
	public void validate(Object obj) throws InvalidAnnotatedAttributeException {
		
		Integer value = (Integer) obj;
		if(value < min){
			ValidateError error = new DefaultValidateError("Atributo " + getAttributeName() + " da classe " + getClassName() + " possui o valor " + value + " e o menor valor permitido é " + min);
			setError(error);
		}
		if(value > max){
			ValidateError error = new DefaultValidateError("Atributo " + getAttributeName() + " da classe " + getClassName() + " possui o valor " + value + " e o maior valor permitido é " + max);
			setError(error);
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		IntRange intRange = (IntRange) an;
		this.min = intRange.min();
		this.max = intRange.max();
	}
	
}
