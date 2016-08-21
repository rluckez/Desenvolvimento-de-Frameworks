package report;

import java.util.List;

import framework.ValidateError;
import framework.Validator;

public class ConsoleReport implements ReportGenerator {

	@Override
	public void generateReport(Validator validator) {
		List<ValidateError> errors = validator.getErrors();
		System.out.println(".......:::::::: Iniciando relatório de validação de erros ::::::::.......");
		System.out.println("Foram encontrados os seguintes erros durante o processo de validação: ");
		for (ValidateError validatorError : errors) {
			System.out.println(validatorError.getDescription());
		}		
		System.out.println("No total foram realizadas " + validator.getNumberOfValidations() + " validações e " + errors.size() + " erros foram encontrados.");
		System.out.println(".......:::::::: Final do relatório de validação ::::::::.......");
		System.out.println("");
		System.out.println("");
	}

}
