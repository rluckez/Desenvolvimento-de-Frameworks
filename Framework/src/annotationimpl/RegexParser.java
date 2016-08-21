package annotationimpl;

import java.lang.annotation.Annotation;

import annotation.Regex;
import excpetion.InvalidAnnotatedAttributeException;
import framework.DefaultValidateError;
import framework.ValidateError;

public class RegexParser extends ValidatorParser {

	private String regex;
	
	@Override
	public void validate(Object obj) throws InvalidAnnotatedAttributeException {
	
		String string = (String) obj;
		if(!string.matches(regex)){
			ValidateError error = new DefaultValidateError("Atributo " + getAttributeName() + " da classe " + getClassName() + " com valor " + string + " n�o est� de acordo com o padr�o " + regex);
			setError(error);
		}			
	}

	@Override
	public void readAnnotation(Annotation an) {
		Regex regexAnnotation = (Regex) an;
		this.regex = regexAnnotation.regex();
	}
	
}
