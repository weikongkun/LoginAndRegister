package com.wkk.service.impl;

import javax.enterprise.inject.New;

import com.wkk.dao.UserDao;
import com.wkk.dao.impl.UserDaoImpl;
import com.wkk.domin.User;
import com.wkk.exception.UserExistException;
import com.wkk.exception.UsersException;
import com.wkk.service.UserService;

public class UserServiceimpl implements UserService{
	UserDao userDao = new UserDaoImpl();

	@Override
	public void register(User user) {
		try {
			userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User login(User user) throws UsersException{
		User u = null; 
		try {
			u = userDao.findUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (u == null) 
				throw new UsersException("用户名或密码不正确");
		
		return u;
	}

	@Override
	public boolean findUserByName(String name) throws UserExistException {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			b = userDao.findUserByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b) {
			throw new com.wkk.exception.UserExistException("用户名已存在");
		}
		return b;
	}
	

}
