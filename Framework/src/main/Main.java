package main;
import java.util.Locale;

import org.joda.time.DateTime;

import bean.Boleto;
import bean.Pessoa;
import framework.Validator;
import notifier.MockEmailNotifier;
import notifier.MockSMSNotifier;

public class Main {

	public static void main(String[] args) {
		
		Pessoa example = new Pessoa();
		example.setNome("Rafael");
		example.setSexo("M");
		example.setIdade(300);
		
		DateTime dateToTest = new DateTime();
		Boleto boleto = new Boleto();
		boleto.setTeste("abc");
		boleto.setNome("Boleto 1");
		boleto.setBanco("Caixa Econômica Federal");
		boleto.setValor(999.99);
		boleto.setVencimento(dateToTest.plusDays(3).toDate());
		boleto.setVencimentoAsCalendar(dateToTest.plusDays(7).toCalendar(Locale.getDefault()));
		boleto.setVencimentoAsString("02/08/2016");
		
		Validator validator = new Validator();
		validator.validate(example);
		validator.validate(boleto);
		
		if(validator.isNotValid()){
			validator.generateReport();
			validator.addNotifier(new MockEmailNotifier());
			validator.addNotifier(new MockSMSNotifier());
			validator.notifyError();
		}
	}

}
