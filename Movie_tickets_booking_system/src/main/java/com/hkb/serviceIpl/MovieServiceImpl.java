package com.hkb.serviceIpl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hkb.DAO.MovieDAO;
import com.hkb.commons.DateFormatUtils;
import com.hkb.commons.myException;
import com.hkb.commons.uploadFileUtils;
import com.hkb.entity.Movie;
import com.hkb.service.MovieService;


public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDAO movieDAO;
	@Override
	public void addMovie(CommonsMultipartFile poster, CommonsMultipartFile descrition,String movieName, String startToShow) throws Exception {
		// TODO Auto-generated method stub
			String posterUrl = uploadFileUtils.uploadFile(poster, startToShow);
			String descritionUrl = uploadFileUtils.uploadFile(descrition, startToShow);
			File posterFile = new File(posterUrl);
			File descritionFile = new File(descritionUrl);
			if(!posterFile.exists()){
				String message = "poster上传失败";
				throw new myException(message);
			}
			if(!descritionFile.exists()){
				String message = "descrition上传失败";
				throw new myException(message);
			}
			
			Date date = DateFormatUtils.DateFormat("yyyy-MM-dd", startToShow);
			
			System.out.println(date);
			Movie movie = new Movie();
			
			String movieId = movieName+startToShow;
			
			movie.setMovieId(movieId);
			movie.setMovieName(movieName);
			movie.setStartToShow(date);
			movie.setPosterUrl(posterUrl);
			movie.setDescritionUrl(descritionUrl);
			
			movieDAO.addMovie(movie);
	}
	@Override
	public List<Movie> threeLastestMovie() {
		// TODO Auto-generated method stub
//		ArrayList<Movie>list = (ArrayList<Movie>) movieDAO.orderByDate();
//		for(Movie m:list){
//			System.out.println(m.getMovieId());
//			System.out.println(m.getMovieName());
//			System.out.println(m.getStartToShow());
//			System.out.println(m.getPosterUrl());
//			System.out.println(m.getDescritionUrl());
//		}
		return movieDAO.orderByDate();
	}
	@Override
	public Movie selectByMovieId(String movieId) {
		// TODO Auto-generated method stub
		Movie movie = movieDAO.selectByMovieId(movieId);
		return movie;
	}
	@Override
	public List<Movie> allMovie() {
		return movieDAO.allMovie();
	}
		
}

