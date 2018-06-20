package com.hkb.service;

import com.hkb.entity.Staff;

public interface StaffService {
	public Staff staffLogin(String staffAccount,String password) throws Exception;
}
