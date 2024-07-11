package com.palani.PoultryAssist.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name ="POULTRY_BREED_SPECIFICATION")
public class BreedSpecification {

	@Id
	@Column (name="SPECIFICATION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SPECIFICATION_ID_SEQ")
	private long specificationId;
	@Column (name="COLOR")
	private String color;
	@Column (name="MALE_WEIGHT")
	private String maleWeight;
	@Column (name="FEMALE_WEIGHT")
	private String femaleWeight;
	@Column (name="EGG_COUNT_PER_YEAR")
	private int eggCount;
	public long getSpecificationId() {
		return specificationId;
	}
	public void setSpecificationId(long specificationId) {
		this.specificationId = specificationId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaleWeight() {
		return maleWeight;
	}
	public void setMaleWeight(String maleWeight) {
		this.maleWeight = maleWeight;
	}
	public String getFemaleWeight() {
		return femaleWeight;
	}
	public void setFemaleWeight(String femaleWeight) {
		this.femaleWeight = femaleWeight;
	}
	public int getEggCount() {
		return eggCount;
	}
	public void setEggCount(int eggCount) {
		this.eggCount = eggCount;
	}
	
	
	
}
