package com.somosbooking.somosBack.service;

import java.util.List;
import java.util.Optional;

import com.somosbooking.somosBack.model.article;
import com.somosbooking.somosBack.utils.SHAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somosbooking.somosBack.model.User;

import javax.transaction.TransactionRequiredException;
import javax.transaction.TransactionalException;


@Service
public class UserService {

	private final UserRepository userRep;


	@Autowired
	public UserService(UserRepository userRep) {
		this.userRep = userRep;
	}

	public List<User> getUsers() {
		return userRep.findAll();
	}

	public User getUser(Long userId) {
		return userRep.findById(userId).orElseThrow(() -> new IllegalStateException("el usuario con id " + userId + " No existe"));
	}


	public String addUser(User user) {
		String res = "Éxito";

		Optional<User> u = userRep.findByName(user.getUserName());
		if (u.isPresent()) {
			res = String.format("El usuario con nombre %s ya existe", user.getUserName());
		} else {
			try {
				;                //userRep.insertUser(user.getUserName(), user.getUserMail(), user.getUserPassword(), user.getUserPhone(), user.getUserType().ordinal());
				user.setUserPassword(SHAUtil.createHash(user.getUserPassword()));
				userRep.save(user);
			} catch (Exception te) {
				res = te.getMessage();
			}

		}

		return res;
	}

	public User login(String userName, String password) {
		User res = null;
		Optional<User> u = userRep.findByName(userName);

		if (u.isPresent()) {
			if (SHAUtil.verifyHash(password, u.get().getUserPassword())) {
				res = u.get();
			}
		}

		return res;
	}

}
