package com.hkb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="MovieField")
public class MovieField {
	@Id
	@Column(name="movieFieldId",nullable=false)
	private String movieFieldId;
	@ManyToOne
	@JoinColumn(name="movieId",nullable=false)
	private Movie movie;
	@Column(name="showDate",nullable=false)
	private Date showDate;
	@Column(name="startTime",nullable=false)
	private Date startTime;
	@Column(name="endTime",nullable=false)
	private Date endTime;
	@Column(name="unitPrice",nullable=false)
	private int unitPrice;
//	private Hall hall;
	public MovieField(){}
	
	public MovieField(String movieFieldId, Movie movie, Date showDate, Date startTime, Date endTime, int unitPrice) {
		super();
		this.movieFieldId = movieFieldId;
		this.movie = movie;
		this.showDate = showDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.unitPrice = unitPrice;
	}
	public String MovieFieldId() {
		return movieFieldId;
	}
	public void setMovieFieldId(String movieFieldId) {
		this.movieFieldId = movieFieldId;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
//	public Hall getHall() {
//		return hall;
//	}
//	public void setHall(Hall hall) {
//		this.hall = hall;
//	}
	
}
