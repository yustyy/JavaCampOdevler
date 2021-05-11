package nLayeredHomework.business.concretes;

import java.util.List;

import nLayeredHomework.business.abstracts.MailService;
import nLayeredHomework.business.abstracts.UserService;
import nLayeredHomework.business.abstracts.UserVerificationService;
import nLayeredHomework.dataAccess.abstracts.UserDao;
import nLayeredHomework.entities.concretes.User;

public class UserManager implements UserService {
	
	UserDao userDao;
	UserVerificationService userVerificationService;
	MailService mailService;
	
	public UserManager(UserDao userDao, UserVerificationService userVerificationService, MailService mailService) {
		this.userDao = userDao;
		this.userVerificationService = userVerificationService;
		this.mailService = mailService;
	}

	@Override
	public void add(User user) {
		if(checkIfUserExists(user.getEmail())) {
			System.out.println("Bu mail adresi zaten kullanımda!");
			return;
		}
		
		if(!mailService.checkIfValidMail(user)) {
			System.out.println("Mail adresiniz @gmail.com uzantılı değil, Google tarafından doğrulanamadı!");
			return;
		}
		
		
		if(!userVerificationService.checkPerson(user)) {
			System.out.println("Ad ve soyad 2 karakterden fazla, parolanız ise 6 karakterden uzun olmalıdır!");
			return;
		}
		
		userDao.add(user);
		userVerificationService.sendMail(user.getEmail());
		
	}

	private boolean checkIfUserExists(String email) {
		for(User user : userDao.getAll()) {
			if(user.getEmail() == email) {
				return true;
			}
			
		}
		return false;
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void login(String email, String password) {
		if(!userVerificationService.checkEmailPassword(email, password)) {
			System.out.println("Başarısız giriş, email ve şifre alanları boş olamaz!");
			return;
		}
		
		for(User user : userDao.getAll()) {
			if(user.getEmail()== email && user.getPassword() == password && user.isUserVerification()) {
				System.out.println(user.getFirstName()+ " "+user.getLastName()+ " adlı kullanıcı için giriş başarılı!");
				return;
			}
		}

		System.out.println("Hatalı giriş, bilgilerinizi doğrulayıp tekrar deneyiniz!");
		
	}
	
}
