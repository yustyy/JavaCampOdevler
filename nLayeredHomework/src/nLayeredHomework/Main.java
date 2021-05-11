package nLayeredHomework;

import nLayeredHomework.business.abstracts.UserService;
import nLayeredHomework.business.abstracts.UserVerificationService;
import nLayeredHomework.business.concretes.UserManager;
import nLayeredHomework.business.concretes.UserVerificationManager;
import nLayeredHomework.core.adapters.GoogleMailApiAdapter;
import nLayeredHomework.dataAccess.concretes.HibernateUserDao;
import nLayeredHomework.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao(),new UserVerificationManager(), new GoogleMailApiAdapter());
		UserVerificationService userVerificationService = new UserVerificationManager();
		
		User yusuf = new User(1,"Yusuf","Açmacı","yusuf.acmaci@gmail.com","12345x");//hata yok
		User baran = new User(2,"Baran","Taşoğlu","barantasoglu@gmail.com","12345x");// hata yok
		User baran2 = new User(3,"Baran","Taşoğlu","barantasoglu@gmail.com","12345x");//bu mail adresi zaten kullanımda
		User ekin = new User(4,"Ekin Yaren","Ergin","ekinyarenergin@gmail.com","12345");//parola 6 karakterden fazla olmalı!
		User nisa = new User(2,"Nisa Naz","Melen","nisanazmelen@hotmail.com","12345x");// mail, google tarafından doğrulanamadı!
		
		System.out.println("");
		System.out.println("--VERİ TABANI--");
		System.out.println("");
		
		userService.add(yusuf);
		userService.add(baran);
		userService.add(baran2);
		userService.add(ekin);
		userService.add(nisa);
		
		System.out.println("");
		System.out.println("--DOĞRULAMA--");
		System.out.println("");
		
		userVerificationService.verificate(yusuf);
		userVerificationService.verificate(baran);
		userVerificationService.verificate(baran2);
		userVerificationService.verificate(ekin);
		userVerificationService.verificate(nisa);
		
		System.out.println("");
		System.out.println("--BİLGİLENDİRME EKRANI--");
		System.out.println("");
		
		userService.login("yusuf.acmaci@gmail.com", "12345x");//başarılı giriş!
		userService.login("", "");//başarısız giriş, email ve şifre alanları boş olamaz!
		userService.login("barantasoglu@gmail.com","12345x");
		userService.login("ekinyarenergin@gmail.com","12345");
		userService.login("nisanazmelen@hotmail.com","12345x");
		
		

	}

}
