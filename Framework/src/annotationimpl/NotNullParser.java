package annotationimpl;

import java.lang.annotation.Annotation;

import framework.DefaultValidateError;
import framework.ValidateError;

public class NotNullParser extends ValidatorParser {

	@Override
	public void validate(Object obj) {
		if(obj == null){
			ValidateError ve = new DefaultValidateError("Atributo " + getAttributeName() + " da classe " + getClassName() + " está nulo.");
			setError(ve);
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		
	}
}
