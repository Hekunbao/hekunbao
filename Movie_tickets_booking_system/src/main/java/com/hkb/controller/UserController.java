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

	//获取用户注册信息，验证成功后添加新用户，返回login页面
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
	//在session中移除user对象
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
		//判断session中是否有user对象,有显示信息,没有则提示"请先登录。。"
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			request.setAttribute("message", "请先登录。。。");
			return "forward:welcome";
		}
		return "userMessage";
	}
	
	@RequestMapping(value="/modifyUserInformation",method=RequestMethod.POST)
	public String modifyUserInformation(HttpServletRequest request)throws Exception{
		
		//获取所修改的user对象属性的新内容和 httpSession对象
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String password = (String) request.getParameter("password");
		String email = (String) request.getParameter("email");
		
		user.setPassword(password);
		user.setEmail(email);
		
		//如果修改信息成功,session里添加新的user对象并且redirect回userMessage页面,
		//否则抛出异常且session remove掉该属性redirect回welcome页面,提示重新登陆
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
