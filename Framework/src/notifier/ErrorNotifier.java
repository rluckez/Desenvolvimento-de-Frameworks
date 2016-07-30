package notifier;

import framework.Validator;

public interface ErrorNotifier {

	public void notifyError(Validator validator);
	
}
