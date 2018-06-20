package com.hkb.DAO;

import com.hkb.entity.User;

public interface UserDAO {
	public boolean addUser(User user);
	public User selectByUserAccount(String userAccount);
	public int updateUser(User user);
}
