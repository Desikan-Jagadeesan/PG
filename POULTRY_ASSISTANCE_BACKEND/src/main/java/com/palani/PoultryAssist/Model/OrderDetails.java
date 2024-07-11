package com.palani.PoultryAssist.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="ORDER_DETAILS")
public class OrderDetails {
	@Id
	@Column(name="ORDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	@Column(name = "BREED_NAME")
	private String breedname;
	@Column(name="CHICK_COUNT")
	private int chickCount;
	@Column(name ="ORDER_STATUS")
	private String orderStatus;
	@Column(name ="COMMENTS")
	private String comments;
	
	@Column(name="ORDER_PLACED_DATE")
	private Date orderPlacedDate;
	@ManyToOne
    @JoinColumn(name = "BUYER_ID")
    private BuyerDetails buyerDetails;
	
	public void setBuyerDetails(BuyerDetails buyerDetails) {
		this.buyerDetails = buyerDetails;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getBreedname() {
		return breedname;
	}
	public void setBreedname(String breedname) {
		this.breedname = breedname;
	}
	public int getChickCount() {
		return chickCount;
	}
	public void setChickCount(int chickCount) {
		this.chickCount = chickCount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getOrderPlacedDate() {
		return orderPlacedDate;
	}
	public void setOrderPlacedDate(Date orderPlacedDate) {
		this.orderPlacedDate = orderPlacedDate;
	}
	
}
