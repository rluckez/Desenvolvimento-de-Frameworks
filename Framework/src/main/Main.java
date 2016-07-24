package main;
import bean.FormA;
import framework.Validator;

public class Main {

	public static void main(String[] args) {
		
		FormA example = new FormA();
		example.setNome("Rafael");
		example.setSexo("M");
		example.setIdade(-5);
		
		Validator validator = new Validator();
		validator.validate(example);
		if(validator.isNotValid()){
			validator.generateReport();
		}
		
	}

}
