package com.example.CanfeReviewOne.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CanfeReviewOne.model.CafeReview;
import com.example.CanfeReviewOne.repo.CafeReviewRepository;

@Service
public class CafeReviewService {

	@Autowired
	CafeReviewRepository cafeReviewRepository;
	
	public CafeReview addReview(CafeReview cafeReview) {
		return cafeReviewRepository.save(cafeReview);
	}
	
	public List<CafeReview> getReviews(){
		return cafeReviewRepository.findAll();
	}
	
	public List<CafeReview> getReview(Integer cafeId){
		return cafeReviewRepository.findAllByCafeId(cafeId);
	}
}
