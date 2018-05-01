package com.wkk.dao;

import com.wkk.domin.User;

public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	/**
	 * 根据用户名和密码查找
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser(User user) throws Exception;
	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return
	 */
	public boolean findUserByName(String name) throws Exception;
}
