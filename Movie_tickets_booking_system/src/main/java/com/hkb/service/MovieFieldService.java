package com.hkb.service;

import java.util.ArrayList;

import com.hkb.entity.MovieField;

public interface MovieFieldService {
	public void addMovieField(MovieField movieField);
	public ArrayList<MovieField> allMovieField();
	public ArrayList<MovieField> selectByMovieId(String movieId);
}
