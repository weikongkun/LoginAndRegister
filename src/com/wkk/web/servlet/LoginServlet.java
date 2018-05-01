package com.wkk.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wkk.domin.User;
import com.wkk.exception.UsersException;
import com.wkk.service.UserService;
import com.wkk.service.impl.UserServiceimpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取表单数据
		User user = new User();

		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 调用处理逻辑
		UserService us = new UserServiceimpl();
		User u;
		try {
			u = us.login(user);

			if (u != null) {
				// 分发转向
				request.getSession().setAttribute("u", user);// 如果登录成功就把用户信息放到session中
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (UsersException e) {
			request.setAttribute("msg", "用户名或密码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (Exception e) {
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
