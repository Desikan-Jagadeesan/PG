package com.palani.PoultryAssist.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palani.PoultryAssist.Model.SpeciesClassification;
import com.palani.PoultryAssist.Service.SpeciesClassificationService;

@RestController
@RequestMapping(value ="/species",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
public class SpeciesController {
	@Autowired
	private SpeciesClassificationService speciesClasificationSerivce;
	
	@PostMapping("/post-all-species-details")
	public ResponseEntity<List<SpeciesClassification>> postAllSpeciesDetails(@RequestBody List<SpeciesClassification> speciesDetails)
	{
		return speciesClasificationSerivce.postAllSpeciesDetails(speciesDetails);
	}
	@PostMapping("/post-sepcies-details")
	public ResponseEntity<SpeciesClassification> postSpeciesDetails(@RequestBody SpeciesClassification speciesDetails)
	{
		System.out.println("1");
		return speciesClasificationSerivce.postSpeciesDetails(speciesDetails);
	}
	@GetMapping("/get-sepcies-details")
	public ResponseEntity<List<SpeciesClassification>> getSpeciesDetails()
	{
		return speciesClasificationSerivce.getSpeciesDetails();
	}
}
