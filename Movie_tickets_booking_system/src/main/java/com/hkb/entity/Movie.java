package com.hkb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movie")
public class Movie {
	@Id
	@Column(name="movieId",nullable=false)
	private String movieId;
	@Column(name="movieName",nullable=false)
	private String movieName;
	@Column(name="startToShow",nullable=false)
	private Date startToShow;
	@Column(name="posterUrl",nullable=false)
	private String posterUrl;
	@Column(name="descritionUrl",nullable=false)
	private String descritionUrl;
	
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getStartToShow() {
		return startToShow;
	}
	public void setStartToShow(Date startToShow) {
		this.startToShow = startToShow;
	}
	public String getPosterUrl() {
		return posterUrl;
	}
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	public String getDescritionUrl() {
		return descritionUrl;
	}
	public void setDescritionUrl(String descritionUrl) {
		this.descritionUrl = descritionUrl;
	}
}
