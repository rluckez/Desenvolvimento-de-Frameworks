package annotationimpl;

import java.lang.annotation.Annotation;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import annotation.PeriodFromCurrentTime;
import excpetion.InvalidAnnotatedAttributeException;
import framework.DefaultValidateError;
import framework.ValidateError;

/**
 * Classe criada para realizar a valida��o de atributos anotados com @CheckDays.
 * O objetivo desta anota��o � realizar a valida��o de datas que devem cumprir um prazo, como por exemplo datas de boletos, onde a data deve ter um prazo entre 
 * a data da gera��o do boleto e a data de vencimento do mesmo.
 * @author Rafael
 *
 */
public class PeriodFromCurrentTimeParser extends ValidatorParser {

	//N�mero de dias de prazo a partir da data atr�buida ao atributo anotado
	private int numberOfDays;
	
	@Override
	public void validate(Object obj) throws InvalidAnnotatedAttributeException {
		
		DateTime value = null;
		if(obj instanceof Date){
			value = new DateTime((Date) obj);
		}
		if(obj instanceof Calendar){
			value = new DateTime((Calendar) obj);
		}
		
		DateTime referenceValue = new DateTime().plusDays(numberOfDays);
		if(value != null & value.isAfter(referenceValue)){
			DateTimeFormatter dtfOut = DateTimeFormat.forPattern("dd/MM/yyyy");
			ValidateError error = new DefaultValidateError("Atributo " + getAttributeName() + " da classe " + getClassName() + " est� com a data " + dtfOut.print(value) + 
					" e o prazo m�ximo para este campo � " + dtfOut.print(referenceValue));
			setError(error);
		}
	}

	@Override
	public void readAnnotation(Annotation an) {
		PeriodFromCurrentTime checkDays = (PeriodFromCurrentTime) an;
		this.numberOfDays = checkDays.numberOfDays();
	}
	
}
