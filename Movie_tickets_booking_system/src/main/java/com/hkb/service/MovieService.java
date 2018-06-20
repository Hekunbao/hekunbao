package com.hkb.service;


import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hkb.entity.Movie;

public interface MovieService {
	public void addMovie(CommonsMultipartFile poster, CommonsMultipartFile descrition,String movieName, String startToShow) throws Exception;
	public List<Movie> threeLastestMovie();
	public Movie selectByMovieId(String movieId);
	public List<Movie> allMovie();
}
