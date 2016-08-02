package annotationimpl;

import java.lang.annotation.Annotation;

import annotation.Regex;
import excpetion.InvalidAnnotatedAttributeException;
import framework.ValidatorError;

public class RegexParser extends ValidatorParser {

	private String regex;
	
	@Override
	public void validate(Object obj) throws InvalidAnnotatedAttributeException {
		
		if(obj instanceof String){
			String string = (String) obj;
			if(!string.matches(regex)){
				ValidatorError error = new ValidatorError("Atributo " + getAttributeName() + " da classe " + getClassName() + " com valor " + string + " n�o est� de acordo com o padr�o " + regex);
				setError(error);
			}			
		}else{
			throw new InvalidAnnotatedAttributeException("O atributo " + getAttributeName() +" da classe " + getClassName() + " � do tipo " + getAttributeType() + " e n�o do tipo String.");
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		Regex regexAnnotation = (Regex) an;
		this.regex = regexAnnotation.regex();
	}
	
}
