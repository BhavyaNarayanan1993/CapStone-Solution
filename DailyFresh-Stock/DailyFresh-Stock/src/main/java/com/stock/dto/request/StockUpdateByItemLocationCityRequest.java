package com.stock.dto.request;

public class StockUpdateByItemLocationCityRequest {

	 	private int itemId;
	    private int fromLocationId;
	    private int toLocationId;
	    private int cityId;
	    private Integer quantity;
		public int getItemId() {
			return itemId;
		}
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		public int getFromLocationId() {
			return fromLocationId;
		}
		public void setFromLocationId(int fromLocationId) {
			this.fromLocationId = fromLocationId;
		}
		public int getToLocationId() {
			return toLocationId;
		}
		public void setToLocationId(int toLocationId) {
			this.toLocationId = toLocationId;
		}
		public int getCityId() {
			return cityId;
		}
		public void setCityId(int cityId) {
			this.cityId = cityId;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		@Override
		public String toString() {
			return "StockUpdateByItemLocationCty [itemId=" + itemId + ", fromLocationId=" + fromLocationId
					+ ", toLocationId=" + toLocationId + ", cityId=" + cityId + ", quantity=" + quantity + "]";
		}
	    
}
