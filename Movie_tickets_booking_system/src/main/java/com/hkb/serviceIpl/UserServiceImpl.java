package com.hkb.serviceIpl;


import org.springframework.beans.factory.annotation.Autowired;

import com.hkb.DAO.UserDAO;
import com.hkb.commons.SystemUtils;
import com.hkb.commons.myException;
import com.hkb.entity.User;
import com.hkb.service.UserService;


public class UserServiceImpl implements UserService {	
	@Autowired
	private UserDAO userDAO;
	@Override
	public boolean userRegister(User user) {
		// TODO Auto-generated method stub
		userDAO.addUser(user);
		return false;
	}
	
	public User userLogin(String userAccount,String password) throws Exception{
		SystemUtils.notNullMessage(userAccount,"账户不能为空！");
		SystemUtils.notNullMessage(password,"密码不能为空！");
		
		User user = userDAO.selectByUserAccount(userAccount);
		if(user==null){
			throw new myException("用户不存在");
		}
		if(user!=null&&!user.getPassword().equals(password)){
//			System.out.println(user.getPassword());
//			System.out.println(password);
			throw new myException("密码错误");
		}
		return user;
		
	}

	@Override
	public void updateUserInformation(User user) throws Exception{
		// TODO Auto-generated method stub
		
		if(userDAO.updateUser(user)!=1){
			throw new myException("修改信息失败");
		}
		
	}

}
