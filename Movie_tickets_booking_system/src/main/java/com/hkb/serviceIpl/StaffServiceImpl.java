package com.hkb.serviceIpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkb.DAO.StaffDAO;
import com.hkb.commons.SystemUtils;
import com.hkb.commons.myException;
import com.hkb.entity.Staff;
import com.hkb.service.StaffService;
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDAO staffDAO;
	@Override
	public Staff staffLogin(String staffAccount, String password) throws Exception {
		// TODO Auto-generated method stub
		
		SystemUtils.notNullMessage(staffAccount, "账号不能为空");
		SystemUtils.notNullMessage(password, "密码不能为空");
		
		Staff staff = staffDAO.selectByStaffAccount(staffAccount);
		if(staff==null){
			throw new myException("没有此职员......");
		}
		if(staff!=null && !(staff.getPassword()).equals(password)){
			throw new myException("密码错误......");
		}
		
		return staff;
	}

}
