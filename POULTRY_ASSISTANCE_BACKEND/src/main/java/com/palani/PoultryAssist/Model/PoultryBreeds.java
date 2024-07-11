package com.palani.PoultryAssist.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="POULTRY_BREEDS")
public class PoultryBreeds {

	@Id
	@Column(name="BREED_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BREED_ID_SEQ")
	private long breedId;

	@Column(name ="SPECIES")
	private String species;

	@Column(name ="BREED_NAME")
	private String breedName;

	@Column(name= "BREED_PURPOSE")
	private String breedPurpose;

	private long hatchingPeriod;

	private long loadingPeriod;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BREED_SPECIFICATION_ID", referencedColumnName = "SPECIFICATION_ID")
	private BreedSpecification specification;

	@ManyToOne
	@JoinColumn(name="SPECIES_ID")
	private SpeciesClassification speciesClassification;

	public long getBreedId() {
		return breedId;
	}

	public void setBreedId(long breedId) {
		this.breedId = breedId;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreedName() {
		return breedName;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public String getBreedPurpose() {
		return breedPurpose;
	}

	public void setBreedPurpose(String breedPurpose) {
		this.breedPurpose = breedPurpose;
	}

	public BreedSpecification getSpecification() {
		return specification;
	}

	public void setSpecification(BreedSpecification specification) {
		this.specification = specification;
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

	public void setSpeciesClassification(SpeciesClassification speciesClassification) {
		this.speciesClassification = speciesClassification;
	}

	@Override
	public String toString() {
		return "PoultryBreeds [breedId=" + breedId + ", species=" + species + ", breedName=" + breedName + ", breedPurpose="
				+ breedPurpose + ", specification=" + specification + ", speciesClassification=" + speciesClassification
				+ "]";
	}
}
