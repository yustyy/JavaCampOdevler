package nLayeredHomework.business.concretes;

import java.util.regex.Pattern;

import nLayeredHomework.business.abstracts.UserVerificationService;
import nLayeredHomework.core.utils.RunRules;
import nLayeredHomework.entities.concretes.User;

public class UserVerificationManager implements UserVerificationService {
	
	public static final Pattern mailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	@Override
	public boolean checkIfEmailExists(String email) {
		return mailRegex.matcher(email).find();
	}

	@Override
	public boolean checkFirstName(String firstName) {
		if(firstName.length()>=2) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean checkLastName(String lastName) {
		if(lastName.length()>=2) {
			return true;
		}else {
			return false;
			}
		}

	@Override
	public boolean checkPassword(String password) {
		if(password.length()>=6) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean checkPerson(User user) {
		boolean result = RunRules.run(
				checkFirstName(user.getFirstName()),
				checkLastName(user.getLastName()),
				checkPassword(user.getPassword()),
				checkIfEmailExists(user.getEmail())
				);
		
		return result;
	}

	@Override
	public boolean checkEmailPassword(String mail, String password) {
		if(mail != "" && password!="") {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void sendMail(String mail) {
		System.out.println("Lütfen "+mail+" adresinize yollanan doğrulama linkine tıklayınız.");
		
	}

	@Override
	public void verificate(User user) {
		if(checkPerson(user)) {
		user.setUserVerification(true);
		System.out.println(user.getEmail()+ " mail adresininz başarıyla doğrulandı, başarıyla giriş yapabilirsiniz!");
		}else {
			System.out.println("Kullanıcı doğrulanamadı!");
		}
		
		
	}

}
