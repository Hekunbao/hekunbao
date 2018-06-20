package com.hkb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hkb.service.SeatService;

@Controller
public class UpdateSeatingTableController {
	@Autowired
	private SeatService seatService;
	
	@RequestMapping("/updateSeatingTable")
	public void updateSeatingTable(){}
	//获取request中座位表的行数和列数，生成座位表
	@RequestMapping("/submitSeatingTable")
	public String submitSeatingTable(@RequestParam("rows") String rows,@RequestParam("cols") String cols){
		seatService.createSeatTable(Integer.parseInt(rows),Integer.parseInt(cols));
		return "redirect:staffFunction";
	}
	//清空座位表
	@RequestMapping("/deleteSeatingTable")
	public String deleteSeatingTable(){
		seatService.truncate();
		return "redirect:staffFunction";
	}
}
