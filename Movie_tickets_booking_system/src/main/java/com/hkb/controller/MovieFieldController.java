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
	
	//��request�е�movieId���Ի��movie������httpSession�У�����staffAddMovieField.jspҳ��
	@RequestMapping(value="/addMovieField",method=RequestMethod.POST)
	public String addMovieField(HttpServletRequest request){
		String movieId = request.getParameter("movieId");
		Movie movie = movieService.selectByMovieId(movieId);
		
		HttpSession session = request.getSession();
		session.setAttribute("movie", movie);
		
		return "staffAddMovieField";
	}
	
	
	//��request�л�ü�����ӵĳ�����Ϣ�����泡����Ϣ
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
		
		session.setAttribute("message", "��ӳ��γɹ�,��������");
		
		return "redirect:staffFunction";
	}
	
	//��ȡrequest��movieId������ֵ�����س���ArrayList���͵����г��η���session��
	@RequestMapping(value="/checkFieldByMovie")
	public String checkFieldByMovie(HttpServletRequest request){
		HttpSession session = request.getSession();
		String movieId = request.getParameter("movieId");
		
		ArrayList<MovieField> fieldList = movieFieldService.selectByMovieId(movieId);
		session.setAttribute("fieldList", fieldList);
		return "checkFieldByMovie";
	}
	
}
