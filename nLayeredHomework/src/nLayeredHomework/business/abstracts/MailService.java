package nLayeredHomework.business.abstracts;

import nLayeredHomework.entities.concretes.User;

public interface MailService {
	boolean checkIfValidMail(User user);
}
