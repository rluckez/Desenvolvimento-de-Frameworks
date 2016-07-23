package annotationimpl;

import java.lang.annotation.Annotation;

import excpetion.InvalidAnnotatedAttributeException;
import framework.ValidatorError;

public abstract class ValidatorParser {

	public abstract void validate(Object obj) throws InvalidAnnotatedAttributeException;
	private boolean isValid = true;
	private ValidatorError error;
	
	public abstract void readAnnotation(Annotation an);
	
	public boolean isValid(){
		return isValid;
	}

	public boolean isNotValid(){
		return !isValid;
	}
	
	public ValidatorError getError() {
		return error;
	}
	
	protected void setError(ValidatorError ve){
		this.error = ve;
		this.isValid = false;
	}
	
	protected void clearError(){
		this.isValid = true;
	}
	
	
	
}
