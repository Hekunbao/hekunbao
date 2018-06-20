package com.hkb.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkb.entity.Movie;
import com.hkb.entity.Staff;
import com.hkb.service.MovieService;
import com.hkb.service.StaffService;

@Controller
public class StaffController {
	@Autowired
	private StaffService staffService;
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/staff")
	public String staff(){
		return "staffLogin";
	}
	@RequestMapping("/staffFunction")
	public void staffFunction(){}
	
	@RequestMapping("/staffAddMovie")
	public void staffAddMovie(){}
	
	//获取所有电影信息放置session之中，返回staffAllMovie页面
	@RequestMapping("/staffAllMovie")
	public String staffAllMovie(HttpServletRequest request){
		ArrayList<Movie> list = (ArrayList<Movie>) movieService.allMovie();
		HttpSession session = request.getSession();
		
		session.setAttribute("list", list);
		return "staffAllMovie";
	}
	
	//获取request中staffAccount，password，验证成功后，将staff对象放置session中，返回staffFunction
	@RequestMapping("/staffLogin")
	public String staffLogin(HttpServletRequest request) throws Exception{
		String staffAccount = request.getParameter("staffAccount");
		String password = request.getParameter("password");
		
		Staff staff = staffService.staffLogin(staffAccount, password);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("staff", staff);
		return "staffFunction";
	}
}
