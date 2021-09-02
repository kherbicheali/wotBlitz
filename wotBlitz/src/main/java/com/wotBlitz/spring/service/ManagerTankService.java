package com.wotBlitz.spring.service;

import com.wotBlitz.spring.model.Tank;
import com.wotBlitz.spring.data.IDao;
import java.util.List;
import com.wotBlitz.spring.model.Tank;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("managerTankService")
public class ManagerTankService implements IManagerTankService {
	
	private static final Logger logger = LoggerFactory.getLogger(ManagerTankService.class);
	
	@Autowired(required = true)
	private IDao<String, Tank> tankdao;

	@Override
	public void save(Tank entity){
		logger.info("-- save()");
		this.tankdao.save(entity);
	}
	
	@Override
	public void update(Tank entity){
		this.tankdao.update(entity);
	}

	@Override
	public void remove(String id){
		this.tankdao.remove(id);
	}

	@Override
	public Tank findById(String id){
		return this.tankdao.findById(id);
	}

	@Override
	public List<Tank> findAll(){
		return this.tankdao.findAll();
	}
	
}
