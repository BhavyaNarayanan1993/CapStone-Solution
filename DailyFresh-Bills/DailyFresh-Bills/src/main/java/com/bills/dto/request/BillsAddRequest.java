package com.bills.dto.request;

import com.bills.model.Bill;


public class BillsAddRequest {
		
		Bill bills;

		public Bill getBills() {
			return bills;
		}

		public void setBills(Bill bills) {
			this.bills = bills;
		}

		@Override
		public String toString() {
			return "BillsAddRequest [bills=" + bills + "]";
		}
		
		
			
}
