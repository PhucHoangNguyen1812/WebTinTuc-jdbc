package com.webtintuc.service.impl;

import javax.inject.Inject;

import com.webtintuc.dao.IUserDAO;
import com.webtintuc.dao.impl.UserDAO;
import com.webtintuc.model.UserModel;
import com.webtintuc.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
	
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

	
}
