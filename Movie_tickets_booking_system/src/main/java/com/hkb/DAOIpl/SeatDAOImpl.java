package com.hkb.DAOIpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hkb.DAO.SeatDAO;
import com.hkb.entity.Seat;
@Repository("SeatDAO")
public class SeatDAOImpl implements SeatDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional(readOnly=false)
	public void saveSeat(Seat seat) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(seat);
	}

	@Override
	public void truncate() {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createSQLQuery("truncate table seat");
	}

}
