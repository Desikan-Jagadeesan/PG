package com.palani.PoultryAssist.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.palani.PoultryAssist.Model.HatchingDetails;
import com.palani.PoultryAssist.Model.PoultryBreeds;
import com.palani.PoultryAssist.Repository.BreedListRepository;
import com.palani.PoultryAssist.Repository.HatchingDetailsRepository;
import com.palani.PoultryAssist.Repository.SpeciesRepository;

@Service
public class HatchingDetailsService {
	@Autowired
	private HatchingDetailsRepository hatchingRepo;
	@Autowired
	private SpeciesRepository speciesRepo;
	@Autowired
	private BreedListRepository breedRepo;

	public ResponseEntity<HatchingDetails> saveHatchingDetails(HatchingDetails hatchingDetails) {
		if(hatchingDetails!=null)
		{
			System.out.println(hatchingDetails.getBreedName());
			PoultryBreeds poultryBreed=breedRepo.findByBreedNameIgnoreCase(hatchingDetails.getBreedName());
			System.out.println(poultryBreed.getBreedName());
			hatchingDetails.setHatchingDate(hatchingDetails.getStartDate(),poultryBreed.getHatchingPeriod());
			hatchingDetails.setLoaderEndDate(hatchingDetails.getStartDate(),poultryBreed.getLoadingPeriod());
			HatchingDetails savedHatchingDetails = hatchingRepo.save(hatchingDetails);
			if(savedHatchingDetails!=null)
			{
				return ResponseEntity.status(HttpStatus.CREATED).body(savedHatchingDetails);
			}
			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	public ResponseEntity<HatchingDetails> updateHatchingDetails(long id,HatchingDetails hatchingDetails) {
		HatchingDetails existHatchingDetails = hatchingRepo.findById(id).orElse(null);
		if(existHatchingDetails==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		existHatchingDetails.setFertileEggCount(hatchingDetails.getFertileEggCount());
		existHatchingDetails.setStartDate(hatchingDetails.getStartDate());
		
		return ResponseEntity.status(HttpStatus.OK).body(existHatchingDetails);
	}

	public ResponseEntity<HatchingDetails> getHatchingDetails(long id) {
		
		HatchingDetails hatchingDetails = hatchingRepo.findById(id).orElse(null);
		if(hatchingDetails==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(hatchingDetails);
	}

	public ResponseEntity<HatchingDetails> deleteHatchingDetails(long id) {
		HatchingDetails hatchingDetails = hatchingRepo.findById(id).orElse(null);
		if(hatchingDetails==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		hatchingRepo.deleteById(id);
		if(hatchingRepo.findById(id).isPresent())
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}

	public ResponseEntity<List<HatchingDetails>> getAllHatchingDetails() {
		
		List <HatchingDetails> allHatchingDetails = hatchingRepo.findAll();
		if(allHatchingDetails.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(allHatchingDetails);
	}
	

}
