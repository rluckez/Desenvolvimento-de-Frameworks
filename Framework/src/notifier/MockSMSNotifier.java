package notifier;

import framework.Validator;

public class MockSMSNotifier implements ErrorNotifier {

	@Override
	public void notifyError(Validator validator) {
		System.out.println("Enviando email");
	}

}
