package com.bills.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bills")
public class Bill {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billNumber;
	
	private LocalDate billDate;
	private String billItems;
	private double billAmount;
	private int	rewardPoints;
	@OneToOne(cascade =CascadeType.ALL)
	private Customer customer;
	public int getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	public LocalDate getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}
	public String getBillItems() {
		return billItems;
	}
	public void setBillItems(String billItems) {
		this.billItems = billItems;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Bill [billNumber=" + billNumber + ", billDate=" + billDate + ", billItems=" + billItems
				+ ", billAmount=" + billAmount + ", rewardPoints=" + rewardPoints + ", customer=" + customer + "]";
	}
	
	
}
