package com.hkb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Seat")
public class Seat {
	@Id
	@Column(name="seatId",nullable=false)
	private String seatId;
//	private Hall hall;
	@Column(name="positionX",nullable=false)
	private int positionX;
	@Column(name="positionY",nullable=false)
	private int positionY;
	
	public Seat(){}
	
	public Seat(String seatId, int positionX, int positionY) {
		super();
		this.seatId = seatId;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
//	public Hall getHall() {
//		return hall;
//	}
//	public void setHall(Hall hall) {
//		this.hall = hall;
//	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	
	
}
