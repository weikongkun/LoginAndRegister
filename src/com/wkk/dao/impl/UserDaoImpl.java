package com.wkk.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

import com.mysql.jdbc.PreparedStatement;
import com.wkk.dao.UserDao;
import com.wkk.domin.User;
import com.wkk.utils.DBUtils;

public class UserDaoImpl implements UserDao{
	@Override
	public void addUser(User user) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("INSERT INTO users(username,PASSWORD,email,birthday) VALUES (?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(4, sdf.format(user.getBirthday()));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("���ʧ�ܣ�");
		} finally {
			DBUtils.closeAll(null, ps, conn);
		}
	}

	@Override
	public User findUser(User user) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return u;
	}

	@Override
	public boolean findUserByName(String name) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from users where username=?");
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return false;
	}

}