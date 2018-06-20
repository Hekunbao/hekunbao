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
		
		SystemUtils.notNullMessage(staffAccount, "�˺Ų���Ϊ��");
		SystemUtils.notNullMessage(password, "���벻��Ϊ��");
		
		Staff staff = staffDAO.selectByStaffAccount(staffAccount);
		if(staff==null){
			throw new myException("û�д�ְԱ......");
		}
		if(staff!=null && !(staff.getPassword()).equals(password)){
			throw new myException("�������......");
		}
		
		return staff;
	}

}
