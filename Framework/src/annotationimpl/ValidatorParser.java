package annotationimpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import excpetion.InvalidAnnotatedAttributeException;
import framework.ValidateError;

public abstract class ValidatorParser {

	public abstract void validate(Object obj) throws InvalidAnnotatedAttributeException;
	private boolean isValid = true;
	private ValidateError error;
	private String className;
	private String attributeName;
	private String attributeType;
	
	public abstract void readAnnotation(Annotation an);
	
	public void setInfo(Field f){
		this.className = f.getDeclaringClass().getName();
		this.attributeName = f.getName();
		this.attributeType = f.getType().getName();
	}
	
	public boolean isValid(){
		return isValid;
	}

	public boolean isNotValid(){
		return !isValid;
	}
	
	public ValidateError getError() {
		return error;
	}
	
	protected void setError(ValidateError ve){
		this.error = ve;
		this.isValid = false;
	}
	
	protected void clearError(){
		this.isValid = true;
	}
	
	public String getClassName() {
		return className;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public String getAttributeType() {
		return attributeType;
	}
	
}
