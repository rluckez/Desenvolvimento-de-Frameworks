package annotationimpl;

import java.lang.annotation.Annotation;

import framework.ValidatorError;

public class NotNullParser extends ValidatorParser {

	@Override
	public void validate(Object obj) {
		if(obj == null){
			ValidatorError ve = new ValidatorError("Atributo " + getAttributeName() + " da classe " + getClassName() + " está nulo.");
			setError(ve);
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		
	}
}
