package com.wkk.domin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class UserForm {
	private int id;
	private String username;
	private String password;
	private String email;
	private String birthday;
	private String repassword;
	Map<String, String> msg = new HashMap<String, String>();
	
	public boolean validate() {
		//判断用户名
		if ("".equals(username) || username == null) {
			msg.put("username","用户名不能为空");
		}
		else if (!username.matches("\\w{3,8}")){
			msg.put("username", "用户名为3~8位字符组成");
		}
		//判断密码
		if ("".equals(password) || password == null) {
			msg.put("password","密码不能为空");
		}
		else if (!password.matches("\\d{3,8}")){
			msg.put("password", "密码为3~8位数字组成");
		}
		//确认密码，和密码保持一致
		if (password == null || !repassword.equals(password)) {
			msg.put("repassword","两次密码不一致");
		}
		//判断邮箱
		if ("".equals(email) || email == null) {
			msg.put("email", "邮箱不能为空");
		}else if(!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")){
			msg.put("email", "邮箱格式不正确");
		}
		//判断生日
		if ("".equals(birthday) || birthday == null) {
			msg.put("birthday", "生日不能空");
		}
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sdf.parse(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				msg.put("birthday", "生日格式不正确"); 
			}
		}
		
		
		return msg.isEmpty();//当Map集合没有数据时返回true
	}
	
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Map<String, String> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
	
	
}
