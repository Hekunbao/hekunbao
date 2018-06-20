package com.hkb.controller;


import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hkb.entity.User;
import com.hkb.service.UserService;

@Controller
public class UserController{
	@Autowired
	private UserService userService;
	@RequestMapping(value="/register")
	public void register(){}
	@RequestMapping(value="/login")
	public void login(){}
	@RequestMapping(value="/modify")
	public void modify(){}

	//��ȡ�û�ע����Ϣ����֤�ɹ���������û�������loginҳ��
	@RequestMapping(value="/userRegister",method=RequestMethod.POST)
	public String register(HttpServletRequest request)throws Exception{
		String userAccount = request.getParameter("userAccount");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		LocalDate createDate = LocalDate.now();
		User user = new User();
		user.setUserAccount(userAccount);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setCreateDate(createDate);
		
		userService.userRegister(user);
		
		return "redirect:login";
	}
	
	//
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	public String login(HttpServletRequest request)throws Exception{
		
		String userAccount = request.getParameter("userAccount");
		String password = request.getParameter("password");
		
		try{
			User user= userService.userLogin(userAccount, password);
			HttpSession session = request.getSession();
			
			session.setAttribute("user",user);
		}catch(Exception e){
			String message = e.getMessage();
			request.setAttribute("message", message);
			return "forward:welcome";
		}
		
		return "redirect:welcome";
	}
	//��session���Ƴ�user����
	@RequestMapping(value="/userLoginOut")
	public String userLoginOut(HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null){
			session.removeAttribute("user");
		}
		return "forward:welcome";
	}
	@RequestMapping(value="/userMessage")
	public String userMessage(HttpServletRequest request)throws Exception{
		//�ж�session���Ƿ���user����,����ʾ��Ϣ,û������ʾ"���ȵ�¼����"
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			request.setAttribute("message", "���ȵ�¼������");
			return "forward:welcome";
		}
		return "userMessage";
	}
	
	@RequestMapping(value="/modifyUserInformation",method=RequestMethod.POST)
	public String modifyUserInformation(HttpServletRequest request)throws Exception{
		
		//��ȡ���޸ĵ�user�������Ե������ݺ� httpSession����
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String password = (String) request.getParameter("password");
		String email = (String) request.getParameter("email");
		
		user.setPassword(password);
		user.setEmail(email);
		
		//����޸���Ϣ�ɹ�,session������µ�user������redirect��userMessageҳ��,
		//�����׳��쳣��session remove��������redirect��welcomeҳ��,��ʾ���µ�½
		try{
			session.setAttribute("user",user);
			return "forward:userMessage";
		}catch(Exception e){
			session.removeAttribute("user");
			String message = e.getMessage();
			request.setAttribute("message", message);
			return "redirect:welcome";
		}
	}
}
