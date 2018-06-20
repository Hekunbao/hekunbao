package com.hkb.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hkb.service.MovieService;

@Controller
public class uploadMovieMessageController {
	@Autowired
	private MovieService movieService;
	//��ȡ��Ӱ��Ϣ�������ϴ��ĺ����������ļ���url����������
	@RequestMapping(value="/uploadMovieMessage",method=RequestMethod.POST)
	public String register(@RequestParam("poster") CommonsMultipartFile poster,
									   @RequestParam("descrition") CommonsMultipartFile descrition,
									   HttpServletRequest request)throws Exception{
		
		String movieName = request.getParameter("movieName");
		String startToShow = request.getParameter("startToShow");
		
	
		movieService.addMovie(poster, descrition, movieName, startToShow);
		
		return "redirect:staffFunction";
	}
}
