package com.palani.PoultryAssist.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palani.PoultryAssist.Model.PoultryBreeds;
import com.palani.PoultryAssist.Repository.BreedListRepository;
import com.palani.PoultryAssist.Repository.BreedSpecificationRepository;

@RestController
@RequestMapping(value="/breed",produces = MediaType.APPLICATION_JSON_VALUE)
public class PoultyController {
	@Autowired
	private BreedListRepository breedRepo;
	 
	@Autowired
	private BreedSpecificationRepository breedSpeciRepo;

	@GetMapping ("/breed-list")
	public ResponseEntity<List<PoultryBreeds>> getBreedList ()
	{
		List <PoultryBreeds> bodyList = breedRepo.findAll();
		return ResponseEntity.ok().header("Breed-List", "Fetched Successfully").body(bodyList);
		
	}
	@PostMapping ("/single-breed-entry")
	public ResponseEntity<PoultryBreeds> saveBreedSingleEntry (@RequestBody PoultryBreeds poultryBreedDetails)
	{
		System.out.print(poultryBreedDetails.getBreedName());
		PoultryBreeds bodyList = breedRepo.save(poultryBreedDetails);
		return ResponseEntity.status(HttpStatus.CREATED).header("Breed-List", " POST Successfully").body(bodyList);
		
	}
	@PostMapping ("/breed-list")
	public ResponseEntity<List<PoultryBreeds>> saveBreedList (@RequestBody List<PoultryBreeds> poultryBreedDetails)
	{
		List <PoultryBreeds> bodyList = breedRepo.saveAll(poultryBreedDetails);
		return ResponseEntity.status(HttpStatus.CREATED).header("Breed-List", "POST Successfully").body(bodyList);
		
	}
	@GetMapping ("/breed-name")
	public ResponseEntity<PoultryBreeds> getBreedByName (@RequestParam String breedName)
	{
		System.out.println(breedName);
		PoultryBreeds breed = breedRepo.findByBreedNameIgnoreCase(breedName);
		if (breed==null)
		{
			 return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().header("Breed-List", "Fetched Successfully").body(breed);
		
	}
	@PutMapping ("/breed/{id}")
	public ResponseEntity<PoultryBreeds> updateBreedByName (@PathVariable long id, @RequestBody PoultryBreeds poultryBreedDetails)
	{	
		PoultryBreeds existingBreed = breedRepo.findById(id).orElse(null);
		if (existingBreed!=null)
		{
			existingBreed.setBreedPurpose(poultryBreedDetails.getBreedPurpose());
			breedRepo.save(existingBreed);
			return ResponseEntity.ok().header("Breed-List", "Updated Successfully").body(existingBreed);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
	}
	@DeleteMapping("/breed/{id}")
	public Object DeleteBreedEntry(@PathVariable long id)
	{
		PoultryBreeds existingBreed = breedRepo.findById(id).orElse(null);
	if (existingBreed!=null)
	{
		breedRepo.deleteById(id);
		return ResponseEntity.ok().header("Breed-List", "Deleted Successfully").build();
	}
	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
}
}
