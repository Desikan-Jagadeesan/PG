package com.palani.PoultryAssist.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.palani.PoultryAssist.Model.BuyerDetails;
import com.palani.PoultryAssist.Model.OrderDetails;
import com.palani.PoultryAssist.Repository.BuyerRepository;
import com.palani.PoultryAssist.Repository.OrderDetailsInterface;

@Service
public class OrderDetailService {

	@Autowired
	private OrderDetailsInterface orderRepo;
	
	@Autowired
	private BuyerRepository buyerRepo;
	
	public ResponseEntity<List<OrderDetails>> fetchAllOrderDetails() {
		List<OrderDetails> orderList = orderRepo.findAll();
		if(!orderList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(orderList);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
	}

	public ResponseEntity<OrderDetails> fetchOrderDetails(long orderId) {
		OrderDetails orderDetail = orderRepo.findById(orderId).orElse(null);
		if(orderDetail == null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
		}
		return ResponseEntity.status(HttpStatus.OK).body(orderDetail);
	}

	public ResponseEntity<List<OrderDetails>> fetchBuyerOrderDetails(long buyerId) {
		
		BuyerDetails buyerDetail = buyerRepo.findById(buyerId).orElse(null);
		if(buyerDetail == null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
		System.out.println(buyerDetail.toString());
		return ResponseEntity.status(HttpStatus.OK).body(buyerDetail.getOrderDetails());
	}

	public ResponseEntity<OrderDetails> updateOrderDetails(long id, OrderDetails updatedOrderDetails) {
		OrderDetails oldOrderDetails = orderRepo.findById(id).orElse(null);
		LocalDate localDate = LocalDate.now();
		Date currSqlDate = Date.valueOf(localDate);
		
		if(oldOrderDetails==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		if(updatedOrderDetails.getOrderStatus()!=null&&updatedOrderDetails.getOrderStatus().equalsIgnoreCase("Active")) {
			if(oldOrderDetails.getOrderPlacedDate().compareTo(currSqlDate)<=1)
			{
				oldOrderDetails.setChickCount(updatedOrderDetails.getChickCount());
				oldOrderDetails.setOrderStatus(updatedOrderDetails.getOrderStatus());
				oldOrderDetails.setComments(updatedOrderDetails.getComments());
			}
			else
			{
				return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).header("Custom-Header", "Date Past Can't Update Chicks Count").body(null);
			}
		}
		else 
		{
			oldOrderDetails.setOrderStatus(updatedOrderDetails.getOrderStatus());
			oldOrderDetails.setComments(updatedOrderDetails.getComments());
			
		}
		orderRepo.save(oldOrderDetails); 
		return ResponseEntity.status(HttpStatus.OK).body(oldOrderDetails);
	}

}
