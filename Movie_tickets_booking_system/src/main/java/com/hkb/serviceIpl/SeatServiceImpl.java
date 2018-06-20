package com.hkb.serviceIpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkb.DAO.SeatDAO;
import com.hkb.entity.Seat;
import com.hkb.service.SeatService;
@Service("SeatService")
public class SeatServiceImpl implements SeatService {
	@Autowired
	private SeatDAO seatDAO;
	@Override
	public void createSeatTable(int rows, int cols) {
		// TODO Auto-generated method stub
		for(int positionX = 1; positionX<= rows; positionX++){
			
			for(int positionY = 1; positionY<= cols; positionY++){
				
				String seatId = positionY+"-"+positionX;
				
				Seat seat =new Seat(seatId,positionX,positionY);
//				System.out.println(seat);
				seatDAO.saveSeat(seat);
			}
		}
	}

	@Override
	public void truncate() {
		// TODO Auto-generated method stub
		seatDAO.truncate();
	}

}
