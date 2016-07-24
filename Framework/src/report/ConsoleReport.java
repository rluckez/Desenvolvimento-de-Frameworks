package report;

import java.util.List;

import framework.Validator;
import framework.ValidatorError;

public class ConsoleReport implements ReportGenerator {

	@Override
	public void generateReport(Validator validator) {
		List<ValidatorError> errors = validator.getErrors();
		System.out.println(".......:::::::: Iniciando relatório de validação de erros ::::::::.......");
		System.out.println("Foram encontrados os seguintes erros durante o processo de validação: ");
		for (ValidatorError validatorError : errors) {
			System.out.println(validatorError.getDesc());
		}		
		System.out.println("No total foram realizadas " + validator.getNumberOfValidations() + " validações e " + errors.size() + " erros foram encontrados.");
		System.out.println(".......:::::::: Final do relatório de validação ::::::::.......");
	}

}
