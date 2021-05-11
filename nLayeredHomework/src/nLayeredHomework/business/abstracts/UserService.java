package nLayeredHomework.business.abstracts;

import java.util.List;

import nLayeredHomework.entities.concretes.User;

public interface UserService {
	void add(User user);
	void delete(User user);
	void update(User user);
	
	void login(String email, String password);
	
	User get(int id);
	List<User> getAll();
}
