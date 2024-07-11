package com.palani.PoultryAssist.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.palani.PoultryAssist.Model.BreedSpecification;
import com.palani.PoultryAssist.Model.PoultryBreeds;
import com.palani.PoultryAssist.Model.SpeciesClassification;
import com.palani.PoultryAssist.Repository.BreedListRepository;
import com.palani.PoultryAssist.Repository.SpeciesRepository;

@Service
public class SpeciesClassificationService {
	@Autowired 
	private SpeciesRepository speciesRepo;
	@Autowired 
	private BreedListRepository breedRepo;

	public ResponseEntity<List<SpeciesClassification>> postAllSpeciesDetails(List<SpeciesClassification> speciesDetails) {
		
		List<SpeciesClassification> savedSpeciesList = speciesRepo.saveAll(speciesDetails);
		if(savedSpeciesList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} 
		return ResponseEntity.status(HttpStatus.CREATED).body(savedSpeciesList);
	}
	
	public ResponseEntity<SpeciesClassification> postSpeciesDetails(SpeciesClassification speciesDetails)
	{
	 
		 for (PoultryBreeds breed : speciesDetails.getPoultryBreeds()) {
	            breed.setSpeciesClassification(speciesDetails);
	            breed.setHatchingPeriod(speciesDetails.getHatchingPeriod());
	            breed.setLoadingPeriod(speciesDetails.getLoadingPeriod());
	           
	        }
	        SpeciesClassification savedSpecies = speciesRepo.save(speciesDetails);        
		return ResponseEntity.status(HttpStatus.CREATED).body(savedSpecies);
	}

	public ResponseEntity<List<SpeciesClassification>> getSpeciesDetails() {
		List<SpeciesClassification> savedSpecies = speciesRepo.findAll();
		if(savedSpecies.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} 
		return  ResponseEntity.status(HttpStatus.OK).body(savedSpecies);
	}

}
