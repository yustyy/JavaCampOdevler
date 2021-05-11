package nLayeredHomework.core.adapters;

import nLayeredHomework.business.abstracts.MailService;
import nLayeredHomework.entities.concretes.User;
import nLayeredHomework.googleMailApi.GoogleMailManager;

public class GoogleMailApiAdapter implements MailService {

	@Override
	public boolean checkIfValidMail(User user) {
		GoogleMailManager googleMailApiAdapter = new GoogleMailManager();
		boolean result = googleMailApiAdapter.checkIfValidMail(user);
		return result;
	}

}
