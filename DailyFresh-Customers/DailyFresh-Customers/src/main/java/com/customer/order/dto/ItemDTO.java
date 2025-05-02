package com.customer.order.dto;

import com.order.model.Item;

public class ItemDTO {
	private int id;
	
	private String itemName;
	
	private String quantity;
	
	private double price;

	public Item(int id, String itemName, String quantity, double price) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	public Item() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", quantity=" + quantity + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Item))
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
