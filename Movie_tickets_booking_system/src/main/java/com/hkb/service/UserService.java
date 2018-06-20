package com.hkb.service;


import com.hkb.entity.User;
public interface UserService {
	public boolean userRegister(User user);
	public User userLogin(String username,String password) throws Exception;
	public void updateUserInformation(User user) throws Exception;
}
