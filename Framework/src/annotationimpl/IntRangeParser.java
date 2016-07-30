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
				ValidatorError error = new ValidatorError("Atributo " + getAttributeName() + " da classe " + getClassName() + " possui o valor " + value + " e o menor valor permitido é " + min);
				setError(error);
			}
			if(value > max){
				ValidatorError error = new ValidatorError("Atributo " + getAttributeName() + " da classe " + getClassName() + " possui o valor " + value + " e o maior valor permitido é " + max);
				setError(error);
			}
		}else{
			throw new InvalidAnnotatedAttributeException("O atributo " + getAttributeName() +" da classe " + getClassName() + " é do tipo " + getAttributeType() + " e não do tipo inteiro.");
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		IntRange intRange = (IntRange) an;
		this.min = intRange.min();
		this.max = intRange.max();
	}
	
}
