package com.customer.order.dto;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.OneToMany;

public class OrderDTO {
	
	
	private LocalDate orderDate;
	
	
	private List<ItemDTO> items;
	
	private String deliveryLocation;
	
	private double orderAmount;

	public OrderDTO( LocalDate orderDate, List<ItemDTO> items, String deliveryLocation, double orderAmount) {
		super();
		
		this.orderDate = orderDate;
		this.items = items;
		this.deliveryLocation = deliveryLocation;
		this.orderAmount = orderAmount;
	}

	public OrderDTO() {
		super();
	}

	

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Override
	public String toString() {
		return "Order [orderDate=" + orderDate + ", items=" + items + ", deliveryLocation="
				+ deliveryLocation + ", orderAmount=" + orderAmount + "]";
	}

	
}
