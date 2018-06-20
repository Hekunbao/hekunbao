package com.hkb.DAOIpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hkb.DAO.UserDAO;
import com.hkb.entity.User;
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional(readOnly=false)
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
		return false;
	}
	@Override
	public User selectByUserAccount(String userAccount) {
		// TODO Auto-generated method stub
		Query<User> query = sessionFactory.getCurrentSession().createQuery("from User u where u.userAccount=?");
		
		query.setParameter(0, userAccount);
		List<User> list = query.getResultList();
		User user = (User) list.iterator().next();
		return user;
	}
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		String userAccount = user.getUserAccount();
		String username = user.getUsername();
		
		String password = user.getPassword();
		String email = user.getEmail();
		System.out.println(password+" "+email);
		String hql = "update User set username = ?,password = ?,"+"email = ?"+"where userAccount = ?";
		Query<User> query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setParameter(0,username);
		query.setParameter(1,password);
		query.setParameter(2, email);
		query.setParameter(3, userAccount);
		
		return query.executeUpdate();
	}

}
