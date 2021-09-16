package com.wotBlitz.spring.controllers;

import com.wotBlitz.spring.model.Tank;
import com.wotBlitz.spring.service.IManagerTankService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TankManagerController {
	
	private static final Logger logger = LoggerFactory.getLogger(TankManagerController.class);
	
	@Autowired(required = true)
	@Qualifier("managerTankService")
	private IManagerTankService managerTankService;
	
	@GetMapping("/test")
	public String test() {
		logger.info("-- url=/test");
		return "test:mehenna";
	}
	
	
	@GetMapping("/tanklist")
	public List<Tank> tankList () {
		logger.info("-- url=/tanklist");
		//List<String> listTank = new ArrayList<String>();
		//listTank.add("label:T62A, dpm:3550, speed:50, gunDepression:7, healthPoints:1800, frontalPoints:230, silver Alpha:310, goldAlpha:280, heAlpha:420");
		
		return managerTankService.findAll(); 
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
