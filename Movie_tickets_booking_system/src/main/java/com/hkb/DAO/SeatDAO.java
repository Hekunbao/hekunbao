package com.hkb.DAO;

import com.hkb.entity.Seat;

public interface SeatDAO {
	public void saveSeat(Seat seat);
	public void truncate();
}
