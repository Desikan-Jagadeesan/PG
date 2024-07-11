package com.palani.PoultryAssist.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palani.PoultryAssist.Model.HatchingDetails;
import com.palani.PoultryAssist.Service.HatchingDetailsService;

@RestController
@RequestMapping(value="/hatch",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public class HatchingDetailsController {

	
	@Autowired
	private HatchingDetailsService hatchingService;
	
	@PostMapping("/save-hatching-details")
	public ResponseEntity<HatchingDetails> saveHatchingDetails(@RequestBody HatchingDetails hatchingDetails)
	{
		return hatchingService.saveHatchingDetails(hatchingDetails);	
	}
	
	@PutMapping("update-hatching-details/{id}")
	public ResponseEntity<HatchingDetails> updateHatchingDetails(@PathVariable long id,  @RequestBody HatchingDetails hatchingDetails){
		return hatchingService.updateHatchingDetails(id,hatchingDetails);	
	}
	
	@GetMapping("/get-hatching-details/{id}")
	public ResponseEntity<HatchingDetails> getHatchingDetails(@PathVariable long id)
	{
		return hatchingService.getHatchingDetails(id);	
	}
	@DeleteMapping("/get-hatching-details/{id}")
	public ResponseEntity<HatchingDetails> deleteHatchingDetails(@PathVariable long id)
	{
		return hatchingService.deleteHatchingDetails(id);	
	}
	@GetMapping("/get-all-hatching-details")
	public ResponseEntity<List<HatchingDetails>> getAllHatchingDetails()
	{
		return hatchingService.getAllHatchingDetails();	
	}
}
