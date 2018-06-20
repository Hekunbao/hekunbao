package com.hkb.DAO;

import java.util.ArrayList;

import com.hkb.entity.MovieField;

public interface MovieFieldDAO {
	public void addMovieField(MovieField movieField); 
	public ArrayList<MovieField> allMovieField();
	public ArrayList<MovieField> selectByMovieId(String movieId);
}
