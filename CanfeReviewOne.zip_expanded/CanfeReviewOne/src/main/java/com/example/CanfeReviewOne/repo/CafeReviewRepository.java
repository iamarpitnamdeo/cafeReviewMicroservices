package com.example.CanfeReviewOne.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CanfeReviewOne.model.CafeReview;

public interface CafeReviewRepository extends JpaRepository<CafeReview,Integer>{

	List<CafeReview> findAllByCafeId(Integer cafeId);
}
