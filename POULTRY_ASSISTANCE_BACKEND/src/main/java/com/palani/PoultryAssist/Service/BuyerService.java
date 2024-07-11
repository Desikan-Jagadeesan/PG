package com.palani.PoultryAssist.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.palani.PoultryAssist.Model.BuyerDetails;
import com.palani.PoultryAssist.Model.OrderDetails;
import com.palani.PoultryAssist.Model.PoultryBreeds;
import com.palani.PoultryAssist.Model.UserDetail;
import com.palani.PoultryAssist.Repository.BreedListRepository;
import com.palani.PoultryAssist.Repository.BuyerRepository;

@Service
public class BuyerService {

	@Autowired
	private BuyerRepository buyerRepo;
	@Autowired
	private BreedListRepository breedListRepo;
	
	public ResponseEntity<List<OrderDetails>> getOrderDetailsByBuyerId (UserDetail userDetail)
	{
		BuyerDetails buyerDetails = buyerRepo.findByBuyerName (userDetail.getUsername());
		if(buyerDetails!=null) {
			List <OrderDetails> orderDetails = buyerDetails.getOrderDetails();
			return ResponseEntity.status(HttpStatus.OK).body(orderDetails);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	public ResponseEntity<BuyerDetails> postOrderDetailsByBuyerId (BuyerDetails buyerDetails)
	{
		for(OrderDetails orderDetails:buyerDetails.getOrderDetails())
		{
			if (orderDetails.getBreedname()!=null)
			{
				PoultryBreeds breed =breedListRepo.findByBreedNameIgnoreCase(orderDetails.getBreedname());
				if(breed==null)
				{
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
			}
		}
		for(OrderDetails orderDetails:buyerDetails.getOrderDetails())
		{
			java.util.Date currentDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
			orderDetails.setOrderPlacedDate(sqlDate);
			orderDetails.setBuyerDetails(buyerDetails);
		
		}
		BuyerDetails savedBuyerDetails = buyerRepo.save(buyerDetails);
		
		if(savedBuyerDetails!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(savedBuyerDetails);
		}

		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	public ResponseEntity<BuyerDetails> updateOrderDetailsByBuyerId (BuyerDetails buyerDetails)
	{
		BuyerDetails savedBuyerDetails = buyerRepo.save(buyerDetails);
		if(savedBuyerDetails!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(savedBuyerDetails);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
