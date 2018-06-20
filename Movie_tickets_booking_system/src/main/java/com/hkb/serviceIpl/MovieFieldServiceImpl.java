package com.hkb.serviceIpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkb.DAO.MovieFieldDAO;
import com.hkb.entity.MovieField;
import com.hkb.service.MovieFieldService;
@Service("MovieFieldService")
public class MovieFieldServiceImpl implements MovieFieldService {
	@Autowired
	private MovieFieldDAO movieFieldDAO;
	@Override
	public void addMovieField(MovieField movieField) {
		// TODO Auto-generated method stub
		movieFieldDAO.addMovieField(movieField);
	}

	@Override
	public ArrayList<MovieField> allMovieField() {
		// TODO Auto-generated method stub
		return movieFieldDAO.allMovieField();
	}

	@Override
	public ArrayList<MovieField> selectByMovieId(String movieId) {
		// TODO Auto-generated method stub
		return movieFieldDAO.selectByMovieId(movieId);
	}

}
