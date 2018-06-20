package com.hkb.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkb.entity.Movie;
import com.hkb.service.MovieService;
@Controller
public class WelcomeController {
	@Autowired
	private MovieService movieService;
	@RequestMapping(value="/welcome")
	//获取电影信息放置在request中
	public String welcome(HttpServletRequest request){
		ArrayList<Movie> list= (ArrayList<Movie>) movieService.threeLastestMovie();
		request.getServletContext().setAttribute("list", list);
//		Iterator<?> iterator = list.iterator();
//		while(iterator.hasNext()){
//			Class<? extends Object> clazz = iterator.next().getClass();
//			
//			System.out.println(clazz);
//		}
//		for(Movie m:list){
//			System.out.println(m.getMovieId());
//			System.out.println(m.getMovieName());
//			System.out.println(m.getStartToShow());
//			System.out.println(m.getPosterUrl());
//			System.out.println(m.getDescritionUrl());
//		}
		return "welcome";
	}
	
	
}
