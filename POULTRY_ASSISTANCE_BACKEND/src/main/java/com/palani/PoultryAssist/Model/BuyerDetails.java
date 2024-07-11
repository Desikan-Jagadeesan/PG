package com.palani.PoultryAssist.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "BUYER_DETAILS")
public class BuyerDetails {

	@Id
	@Column(name ="BUYER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long buyerId;
	@Column(name ="BUYER_NAME")
	private String buyerName;
	@OneToMany(mappedBy="buyerDetails",cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails;
	public long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	@Override
	public String toString() {
		return "BuyerDetails [buyerId=" + buyerId + ", buyerName=" + buyerName + ", orderDetails=" + orderDetails + "]";
	}
	
	
}
