package com.hkb.DAOIpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hkb.DAO.MovieDAO;
import com.hkb.entity.Movie;
@Repository("MovieDAO")
public class MovieDAOImpl implements MovieDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional(readOnly=false)
	public void addMovie(Movie movie) {
		sessionFactory.getCurrentSession().save(movie);
	}
	@Override
	public List<Movie> orderByDate() {
//		Query<Movie> query = (Query<Movie>) sessionFactory.getCurrentSession().createQuery("select * from movie order by startToShow desc limit 0,3");
		NativeQuery<Movie> query= (NativeQuery<Movie>)sessionFactory.getCurrentSession().createNativeQuery("select * from movie order by startToShow desc limit 0,3").addEntity(Movie.class);
		ArrayList<Movie>list = (ArrayList<Movie>) query.getResultList();
//		for(Movie m:list){
//			System.out.println(m.getMovieId());
//			System.out.println(m.getMovieName());
//			System.out.println(m.getStartToShow());
//			System.out.println(m.getPosterUrl());
//			System.out.println(m.getDescritionUrl());
//		}
		return list;
	}
	public Movie selectByMovieId(String movieId){
		Query<Movie> query = sessionFactory.getCurrentSession().createQuery("From Movie m where m.movieId = ?");
		query.setParameter(0, movieId);
		Movie movie = query.getSingleResult();
		return movie;
	}
	@Override
	public List<Movie> allMovie() {
		// TODO Auto-generated method stub
		Query<Movie> query = sessionFactory.getCurrentSession().createQuery("From Movie");
		ArrayList<Movie>list = (ArrayList<Movie>) query.getResultList();
		return list;
	}
}
