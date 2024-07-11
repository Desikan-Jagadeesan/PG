package com.palani.PoultryAssist.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palani.PoultryAssist.Model.OrderDetails;
import com.palani.PoultryAssist.Service.OrderDetailService;

@RestController
@RequestMapping(value ="/order",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public class OrderDetailsController {

	@Autowired
	private OrderDetailService orderService;
	
	@GetMapping("/get-all-orders")
	public ResponseEntity<List<OrderDetails>> getAllOrderDetails()
	{
		return orderService.fetchAllOrderDetails() ;
		
	}
	
	@GetMapping("/get-orderList-by-id")
	public ResponseEntity<OrderDetails> getOrderDetails(@RequestParam long orderId)
	{
		return orderService.fetchOrderDetails(orderId) ;
		
	}

	@GetMapping("/get-orderList-by-buyer-id")
	public ResponseEntity<List<OrderDetails>> getBuyerOrderDetails(@RequestParam long buyerId)
	{
		return orderService.fetchBuyerOrderDetails(buyerId) ;
		
	}
	
	@PutMapping("/update-order-details-by-order-id/{id}")
	public ResponseEntity<OrderDetails> updateOrderDetails (@PathVariable long id ,@RequestBody OrderDetails updatedOrderDetails)
	{
		return orderService.updateOrderDetails(id,  updatedOrderDetails );
		
	}
}

