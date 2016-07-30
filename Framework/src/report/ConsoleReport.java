package report;

import java.util.List;

import framework.Validator;
import framework.ValidatorError;

public class ConsoleReport implements ReportGenerator {

	@Override
	public void generateReport(Validator validator) {
		List<ValidatorError> errors = validator.getErrors();
		System.out.println(".......:::::::: Iniciando relat�rio de valida��o de erros ::::::::.......");
		System.out.println("Foram encontrados os seguintes erros durante o processo de valida��o: ");
		for (ValidatorError validatorError : errors) {
			System.out.println(validatorError.getDesc());
		}		
		System.out.println("No total foram realizadas " + validator.getNumberOfValidations() + " valida��es e " + errors.size() + " erros foram encontrados.");
		System.out.println(".......:::::::: Final do relat�rio de valida��o ::::::::.......");
		System.out.println("");
		System.out.println("");
	}

}
