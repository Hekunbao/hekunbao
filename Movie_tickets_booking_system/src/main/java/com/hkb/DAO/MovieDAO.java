package com.hkb.DAO;

import java.util.List;

import com.hkb.entity.Movie;

public interface MovieDAO {
	public void addMovie(Movie movie);
	public List<Movie> orderByDate();
	public Movie selectByMovieId(String movieId);
	public List<Movie> allMovie();
}
