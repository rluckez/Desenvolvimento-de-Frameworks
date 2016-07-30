package annotationimpl;

import java.lang.annotation.Annotation;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import annotation.CheckDays;
import excpetion.InvalidAnnotatedAttributeException;
import framework.ValidatorError;

/**
 * Classe criada para realizar a validação de atributos anotados com @CheckDays.
 * O objetivo desta anotação é realizar a validação de datas que devem cumprir um prazo, como por exemplo datas de boletos, onde a data deve ter um prazo entre 
 * a data da geração do boleto e a data de vencimento do mesmo.
 * @author Rafael
 *
 */
public class CheckDaysParser extends ValidatorParser {

	//Número de dias de prazo a partir da data atríbuida ao atributo anotado
	private int numberOfDays;
	
	@Override
	public void validate(Object obj) throws InvalidAnnotatedAttributeException {
		
		DateTime value;
		if(obj instanceof Date){
			value = new DateTime((Date) obj);
		} else if(obj instanceof Calendar){
			value = new DateTime((Calendar) obj);
		}else{
			throw new InvalidAnnotatedAttributeException("O atributo " + getAttributeName() +" da classe " + getClassName() + " é do tipo " + getAttributeType() + " e não do tipo inteiro.");
		}
		
		DateTime referenceValue = new DateTime().plusDays(numberOfDays);
		if(value.isAfter(referenceValue)){
			DateTimeFormatter dtfOut = DateTimeFormat.forPattern("dd/MM/yyyy");
			ValidatorError error = new ValidatorError("Atributo " + getAttributeName() + " da classe " + getClassName() + " está com a data " + dtfOut.print(value) + 
					" e o prazo máximo para este campo é " + dtfOut.print(referenceValue));
			setError(error);
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		CheckDays checkDays = (CheckDays) an;
		this.numberOfDays = checkDays.numberOfDays();
	}
	
}
