package com.hkb.entity;


public class order {
	private User user;
	private MovieField movieField;
	private Seat seat;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MovieField getMovieField() {
		return movieField;
	}
	public void setMovieField(MovieField movieField) {
		this.movieField = movieField;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
} 
