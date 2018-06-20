package com.hkb.DAOIpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hkb.DAO.StaffDAO;
import com.hkb.entity.Staff;
@Repository("StaffDAO")
public class StaffDAOImpl implements StaffDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Staff selectByStaffAccount(String staffAccount) {
		// TODO Auto-generated method stub
		Query<Staff> query = sessionFactory.getCurrentSession().createQuery("from Staff  where staffAccount=?");
		
		query.setParameter(0, staffAccount);
		List<Staff> list = query.getResultList();
		Staff staff = (Staff) list.iterator().next();
		return staff;
	}

}
