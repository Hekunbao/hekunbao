package com.hkb.controller;


import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hkb.commons.DateFormatUtils;
import com.hkb.entity.Movie;
import com.hkb.entity.MovieField;
import com.hkb.service.MovieFieldService;
import com.hkb.service.MovieService;

@Controller
public class MovieFieldController {
	
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private MovieFieldService movieFieldService;
	
	//用request中的movieId属性获得movie，放置httpSession中，返回staffAddMovieField.jsp页面
	@RequestMapping(value="/addMovieField",method=RequestMethod.POST)
	public String addMovieField(HttpServletRequest request){
		String movieId = request.getParameter("movieId");
		Movie movie = movieService.selectByMovieId(movieId);
		
		HttpSession session = request.getSession();
		session.setAttribute("movie", movie);
		
		return "staffAddMovieField";
	}
	
	
	//从request中获得即将添加的场次信息，保存场次信息
	@RequestMapping(value="/submitFieldMessage",method=RequestMethod.POST)
public String submitFieldMessage(HttpServletRequest request)throws Exception{
		
		Date showDate = DateFormatUtils.DateFormat("yyyy-MM-dd", request.getParameter("showDate"));
		System.out.println(request.getParameter("startTime"));
		System.out.println(request.getParameter("endTime"));
		Date endTime = DateFormatUtils.DateFormat("HH:mm:ss", request.getParameter("endTime"));
		Date startTime = DateFormatUtils.DateFormat("HH:mm:ss", request.getParameter("startTime"));
		int unitPrice =Integer.parseInt(request.getParameter("unitPrice"));
		
		HttpSession session = request.getSession();
		Movie movie = (Movie) session.getAttribute("movie");
		
		String movieFieldId = movie.getMovieId()+"/"+showDate;
		
		MovieField movieField = new MovieField(movieFieldId,movie,showDate,startTime,endTime,unitPrice);
		
		movieFieldService.addMovieField(movieField);
		
		session.setAttribute("message", "添加场次成功,继续操作");
		
		return "redirect:staffFunction";
	}
	
	//获取request中movieId参数的值，返回场次ArrayList类型的所有场次放置session中
	@RequestMapping(value="/checkFieldByMovie")
	public String checkFieldByMovie(HttpServletRequest request){
		HttpSession session = request.getSession();
		String movieId = request.getParameter("movieId");
		
		ArrayList<MovieField> fieldList = movieFieldService.selectByMovieId(movieId);
		session.setAttribute("fieldList", fieldList);
		return "checkFieldByMovie";
	}
	
}
