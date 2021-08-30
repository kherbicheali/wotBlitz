package com.wotBlitz.spring.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TankManagerController {
	
	private static final Logger logger = LoggerFactory.getLogger(TankManagerController.class);
	
	@GetMapping("/test")
	public String test() {
		logger.info("-- url=/test");
		return "test:mehenna";
	}
	@GetMapping("/tanklist")
	public String tankList () {
		logger.info("-- url=/tanklist");
		String bob =
				" status: NOT_FOUND"
				+ " errors:0"
				+ " timestamp: 2019–03–13T07:47:10.990+0000"
				+ " message: Requested stop with code — STPF does not exist.";
		return bob; 
	}
	
	@GetMapping("/deletetank")
	public void deleteTank (String id) {
		
	}
	
	@GetMapping("/findbyid")
	public void findById (String id) {
		
	}
	
	@PostMapping("/savetank")
	public void saveTank () {
		
	}
	
	@PostMapping("/updatetank")
	public void updateTank () {
		
	}
	
}
