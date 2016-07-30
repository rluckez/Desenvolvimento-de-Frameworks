package notifier;

import framework.Validator;

public class MockEmailNotifier implements ErrorNotifier {

	@Override
	public void notifyError(Validator validator) {
		System.out.println("Enviando SMS");
	}

}
