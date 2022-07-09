package com.example.CafeInfoOne.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CafeInfoOne.model.CafeInfo;
public interface CafeInfoRepository extends JpaRepository<CafeInfo,Integer>{

}
