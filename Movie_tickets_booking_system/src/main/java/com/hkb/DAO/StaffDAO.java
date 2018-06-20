package com.hkb.DAO;

import com.hkb.entity.Staff;

public interface StaffDAO {
	public Staff selectByStaffAccount(String staffAccount) throws Exception;
}
