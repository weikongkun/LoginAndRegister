package com.wkk.service;

import org.omg.CORBA.UserException;

import com.wkk.domin.User;
import com.wkk.exception.UserExistException;
import com.wkk.exception.UsersException;

public interface UserService {
	/**
	 * 注册用户
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user) throws Exception;
	/**
	 * 根据用户名查找用户是否存在
	 * @param name
	 * @return
	 * @throws UserExistException
	 */
	public boolean findUserByName(String name) throws Exception;
		
}
