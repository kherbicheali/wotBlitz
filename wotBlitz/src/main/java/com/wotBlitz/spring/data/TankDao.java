package com.wotBlitz.spring.data;

import com.wotBlitz.spring.model.Tank;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wotBlitz.spring.data.EMProvider;

public class TankDao implements IDao <String, Tank> {
	private static final Logger logger = LoggerFactory.getLogger(TankDao.class);
	
	public Tank save(Tank entity) {
		logger.info("-- save()");
		EMProvider.beginTransaction();
		EMProvider.getEntityManager().persist(entity);
		EMProvider.commit();
		return null;
	}
	public Tank update(Tank entity) {
		logger.info("-- update()");
		EMProvider.beginTransaction();
		EMProvider.getEntityManager().merge(entity);
		EMProvider.commit();
		return null;
	}
	public void remove(String id) {
		logger.info("-- remove()");
	}
	public Tank findById(String id) {
		logger.info("-- findById()");
		EMProvider.beginTransaction();
		Tank tank = EMProvider.getEntityManager().find(Tank.class, id);
		EMProvider.commit();
		return tank;
	}
	public List<Tank> findAll(){
		logger.info("-- findAll()");
		EMProvider.beginTransaction();
		List<Tank> listTank = EMProvider.getEntityManager().createNamedQuery("Entity.findAll").getResultList();
		EMProvider.commit();
		return listTank;
	}
	public void closeResource() {
		logger.info("-- closeResource()");
		EMProvider.closeEntityManager();
	}
}
