package main;
import java.util.List;

import bean.Bean;
import framework.Validator;
import framework.ValidatorError;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		Bean bean = new Bean();
		bean.setNome("Rafael");
//		bean.setSexo("M");
		
		Validator validator = new Validator();
		List<ValidatorError> errors = validator.validate(bean);
		if(errors.size() != 0){
			for(ValidatorError ve : errors){
				System.out.println("Erro: " + ve.getDesc());
			}
		}
	}

}
