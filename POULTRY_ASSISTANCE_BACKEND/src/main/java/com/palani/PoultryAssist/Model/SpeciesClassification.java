package com.palani.PoultryAssist.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="SPECIES_CLASSIFICATION")
public class SpeciesClassification {
	@Id
	@Column(name="SPECIES_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long speciesId;

	@Column(name="SPECIES_NAME")
	private String speciesName;

	@Column(name="HATCHING_PERIOD")
	private long hatchingPeriod;

	@Column(name="LOADING_PERIOD")
	private long loadingPeriod;

	@OneToMany(mappedBy="speciesClassification", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PoultryBreeds> poultryBreeds = new ArrayList<>();

	public long getSpeciesId() {
		return speciesId;
	}

	public void setSpeciesId(long speciesId) {
		this.speciesId = speciesId;
	}

	public List<PoultryBreeds> getPoultryBreeds() {
		return poultryBreeds;
	}

	public void setPoultryBreeds(List<PoultryBreeds> poultryBreeds) {
		this.poultryBreeds = poultryBreeds;
	}

	public long getHatchingPeriod() {
		return hatchingPeriod;
	}

	public void setHatchingPeriod(long hatchingPeriod) {
		this.hatchingPeriod = hatchingPeriod;
	}

	public long getLoadingPeriod() {
		return loadingPeriod;
	}

	public void setLoadingPeriod(long loadingPeriod) {
		this.loadingPeriod = loadingPeriod;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	@Override
	public String toString() {
		return "SpeciesClassification [speciesId=" + speciesId + ", speciesName=" + speciesName + ", poultryBreeds="
				+ poultryBreeds + ", hatchingPeriod=" + hatchingPeriod + ", loadingPeriod=" + loadingPeriod + "]";
	}
}
