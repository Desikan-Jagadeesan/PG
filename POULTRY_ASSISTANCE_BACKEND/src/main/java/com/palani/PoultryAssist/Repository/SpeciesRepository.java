package com.palani.PoultryAssist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palani.PoultryAssist.Model.SpeciesClassification;

@Repository
public interface SpeciesRepository extends JpaRepository<SpeciesClassification, Long> {
	//SpeciesClassification findByPoultryBreeds_BreedName(String breedName);
}
