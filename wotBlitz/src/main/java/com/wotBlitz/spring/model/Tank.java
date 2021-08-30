package com.wotBlitz.spring.model;

import java.util.List;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "TANK")
public class Tank {
	
	@Id
	private String label;
	private String type;
	private int dpm;
	private int speed;
	private int frontalArmor;
	private int healthPoints;
	private int gunDepression;
	private int silverAlpha;
	private int goldAlpha;
	private int heAlpha;
	
	public Tank () {}
	public String getLabel(){
		return label;
	}
	public String getType(){
		return type;
	}	
	public int getDpm(){
		return dpm;
	}
	public int getSpeed(){
		return speed;
	}
	public int getFrontalArmor(){
		return frontalArmor;
	}
	public int getHealthPoints(){
		return healthPoints;
	}
	public int getGunDepression(){
		return gunDepression;
	}
	public int getSilverAlpha(){
		return silverAlpha;
	}
	public int getGoldAlpha(){
		return goldAlpha;
	}
	public int getHeAlpha(){
		return heAlpha;
	}
	
	public void setLabel(String label){
		this.label = label;
	}
	public void setType(String type){
		this.type = type;
	}
	public void setDpm(int dpm){
		this.dpm = dpm;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	public void setFrontalArmor(int frontalArmor){
		this.frontalArmor = frontalArmor;
	}
	public void setHealthPoints(int healthPoints){
		this.healthPoints = healthPoints;
	}
	public void setGunDepression(int gunDepression){
		this.gunDepression = gunDepression; 
	}
	public void setSilverAlpha(int silverAlpha){
		this.silverAlpha = silverAlpha;
	}
	public void setGoldAlpha(int goldAlpha){
		this.goldAlpha = goldAlpha;
	}
	public void setHeAlpha(int heAlpha){
		this.heAlpha = heAlpha;		
	}
		
}
