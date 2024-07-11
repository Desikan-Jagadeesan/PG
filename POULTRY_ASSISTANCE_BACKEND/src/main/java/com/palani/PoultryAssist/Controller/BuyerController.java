package com.palani.PoultryAssist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.palani.PoultryAssist.Model.BuyerDetails;
import com.palani.PoultryAssist.Service.BuyerService;

@RestController
@RequestMapping(value = "/buyer",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public class BuyerController {
	
	@Autowired
	private BuyerService buyerService;
	
	@PostMapping("/post-order-details")
	public ResponseEntity<BuyerDetails> postBuyerDetails(@RequestBody BuyerDetails buyerDetails)
	{
		return buyerService.postOrderDetailsByBuyerId(buyerDetails);
	}
	
}
