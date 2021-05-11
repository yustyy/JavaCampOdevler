package nLayeredHomework.business.abstracts;

import nLayeredHomework.entities.concretes.User;

public interface UserVerificationService {
	boolean checkIfEmailExists(String email);
	
	boolean checkFirstName(String firstName);
	
	boolean checkLastName(String lastName);
	
	boolean checkPassword(String password);
	
	boolean checkPerson(User user);
	
	boolean checkEmailPassword(String mail, String password);
	
	void sendMail(String mail);
	
	void verificate(User user);
}
