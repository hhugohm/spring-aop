package org.neos.aop.dao;

import java.util.List;

import org.neos.aop.domain.User;
import org.springframework.stereotype.Repository;



@Repository("userDao")
public class UserDaoImpl implements UserDao {

	public User getUserByName(User user) {
		System.out.println("Se va a CONSULTAR el usuario: " + user.toString());
		return null;
	}

	public List<User> getAllUsers() {
		System.out.println("Se va a CONSULTAR ALL USERS: ");
		return null;
	}

	public void updateUser(User user) {
		System.out.println("Se va a MODIFICAR el usuario: " + user.toString());

	}

	public void saveUser(User user) {
		System.out.println("Se va a INSERTAR el usuario: " + user.toString());

	}
	
	public void deleteUser(User user) {
		System.out.println("Se va a BORRAR el usuario: " + user.toString());
	}

}
