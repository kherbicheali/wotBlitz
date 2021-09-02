package com.wotBlitz.spring.service;

import java.util.List;
import com.wotBlitz.spring.model.Tank;

public interface IManagerTankService {
	
	void save(Tank entity);

	void update(Tank entity);

	void remove(String id);

	Tank findById(String id);

	List<Tank> findAll();
}
