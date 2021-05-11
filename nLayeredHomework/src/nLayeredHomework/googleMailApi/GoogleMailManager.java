package nLayeredHomework.googleMailApi;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


import nLayeredHomework.entities.concretes.User;

public class GoogleMailManager {
	public boolean checkIfValidMail(User user) {
		Pattern pattern = Pattern.compile("@gmail.com", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(user.getEmail());
		return matcher.find();
	}
}
