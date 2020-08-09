package com.altimetrik.ee.demo.Vo;

import java.util.Map;

public class OrderInfo {
	
	private long customerId;
	
	private long restaurantId;
	
	private long locationId;
	
	private Map<Long, Integer> foodQuantityMap;
	
	public OrderInfo() {
		super();
	}
	
	public OrderInfo(long customerId, long restaurantId, long locationId, Map<Long, Integer> foodQuantityMap) {
		super();
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.locationId = locationId;
		this.foodQuantityMap = foodQuantityMap;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public Map<Long, Integer> getFoodQuantityMap() {
		return foodQuantityMap;
	}

	public void setFoodQuantityMap(Map<Long, Integer> foodQuantityMap) {
		this.foodQuantityMap = foodQuantityMap;
	}

}
