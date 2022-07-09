package com.example.CafeInfoOne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.CafeInfoOne.model.CafeInfo;
import com.example.CafeInfoOne.service.CafeInfoService;

@Controller
@EnableAutoConfiguration
public class CafeInfoController {
	
	@Autowired
	CafeInfoService cafeInfoService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/addCafe")
	public String addCafe(@ModelAttribute("cafeName")String cafeName,@ModelAttribute("cafeDesc")String cafeDesc)
	{
		CafeInfo cafeInfo = new CafeInfo(cafeName,cafeDesc);
		CafeInfo savedCafeInfo=cafeInfoService.addCafe(cafeInfo);
		if(savedCafeInfo!=null)
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}
	@GetMapping("/getCafes")
	@ResponseBody
	public List<CafeInfo> getCafes()
	{
		return cafeInfoService.getCafes();
	}
	@GetMapping("/count")
	@ResponseBody
	public String getCafeCount()
	{
		return String.valueOf(cafeInfoService.getCafes().size());
	}
	
	@GetMapping("/getAll/{cafeId}")
	public ModelAndView getAll(@PathVariable("cafeId")Integer cafeId)
	{
		System.out.println("===========================");
		System.out.println("Request served at get all");
		return cafeInfoService.getAll(cafeId);
	}
}
