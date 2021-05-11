package nLayeredHomework.dataAccess.concretes;

import java.util.List;
import java.util.ArrayList;

import nLayeredHomework.dataAccess.abstracts.UserDao;
import nLayeredHomework.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	
	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName()+ " successfully added!");
		users.add(user);
		
	}

	@Override
	public void delete(User user) {
		for(var _user: users) {
			if(_user.getId()==user.getId()) {
				users.remove(user);
				System.out.println(user.getFirstName()+ " successfully deleted!");
			}else {
				System.out.println(user.getFirstName()+ " doesnt exist in db!");
			}
		}
		
	}

	@Override
	public void update(User user) {
		for(var _user: users) {
			if(_user.getId()==user.getId()) {
				_user.setFirstName(user.getFirstName());
				_user.setLastName(user.getLastName());
				_user.setEmail(user.getEmail());
				_user.setPassword(user.getPassword());
				
				System.out.println(_user.getFirstName()+ " successfully updated!");
			}
		}
		System.out.println(user.getFirstName()+ " doesnt exist in db!");
		
	}

	@Override
	public User get(int id) {
		for(User _user:users) {
			if(_user.getId()==id) {
				return _user;
			}
		}
		System.out.println("User doesnt exist in db!");
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
