package com.hkb.DAOIpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hkb.DAO.MovieFieldDAO;
import com.hkb.entity.MovieField;
@Repository("MovieFieldDAO")
public class MovieFieldDAOImpl implements MovieFieldDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional(readOnly=false)
	public void addMovieField(MovieField movieField) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(movieField);
	}

	@Override
	public ArrayList<MovieField> allMovieField() {
		// TODO Auto-generated method stub
		Query<MovieField> query = sessionFactory.getCurrentSession().createQuery("From MovieField");
		ArrayList<MovieField> list= (ArrayList<MovieField>) query.getResultList();
		return list;
	}

	@Override
	public ArrayList<MovieField> selectByMovieId(String movieId) {
		// TODO Auto-generated method stub
		Query<MovieField> query = sessionFactory.getCurrentSession().createQuery("From MovieField where movieId=?");
		query.setParameter(0, movieId);
		ArrayList<MovieField> list = (ArrayList<MovieField>) query.getResultList();
		return list;
	}

}
