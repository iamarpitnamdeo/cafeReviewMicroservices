package com.example.CafeInfoOne.service;

import java.net.URI;
import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.CafeInfoOne.model.CafeInfo;
import com.example.CafeInfoOne.model.CafeReview;
import com.example.CafeInfoOne.repo.CafeInfoRepository;



@Service
@EnableAutoConfiguration
public class CafeInfoService {
	@Autowired
	CafeInfoRepository cafeInfoRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public CafeInfo addCafe(CafeInfo cafeInfo) {
		return cafeInfoRepository.save(cafeInfo);
	}
	public List<CafeInfo> getCafes(){
		return cafeInfoRepository.findAll();
	}
	public Optional<CafeInfo> getCafe(Integer cafeId){
		return cafeInfoRepository.findById(cafeId);
	}
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Value("${pivotal.cafereviewservice.name}")
	protected String cafereviewservice;
	
	public ModelAndView getAll(Integer cafeId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("cafeInfo",this.getCafe(cafeId).get());
		
		//getting instances using discoveryClient object
		List<ServiceInstance> instances = discoveryClient.getInstances(cafereviewservice);
		URI uri = instances.get(0).getUri();
		String url = uri.toString()+"/getReview/"+cafeId;
		
		@SuppressWarnings("unchecked")
		List<CafeReview> result = restTemplate.getForObject(url, List.class);
		System.out.println("details of results:"+result.toString());
		mv.addObject("cafeReview",result);
		mv.setViewName("cafeAll");
		return mv;
	}
}
