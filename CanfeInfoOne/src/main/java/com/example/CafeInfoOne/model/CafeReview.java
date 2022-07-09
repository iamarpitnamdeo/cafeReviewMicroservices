package com.example.CafeInfoOne.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CafeReview {
	@Id
	@GeneratedValue
	private Integer reviewId;
	private Integer cafeId;
	private Integer cafeRating;
	private String cafeRemarks;
	public CafeReview() {
		super();
	}
	public CafeReview(Integer reviewId, Integer cafeId, Integer cafeRatings, String cafeRemarks) {
		super();
		this.reviewId = reviewId;
		this.cafeId = cafeId;
		this.cafeRating = cafeRatings;
		this.cafeRemarks = cafeRemarks;
	}
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	public Integer getCafeId() {
		return cafeId;
	}
	public void setCafeId(Integer cafeId) {
		this.cafeId = cafeId;
	}
	public Integer getCafeRatings() {
		return cafeRating;
	}
	public void setCafeRatings(Integer cafeRatings) {
		this.cafeRating = cafeRatings;
	}
	public String getCafeRemarks() {
		return cafeRemarks;
	}
	public void setCafeRemarks(String cafeRemarks) {
		this.cafeRemarks = cafeRemarks;
	}
}
