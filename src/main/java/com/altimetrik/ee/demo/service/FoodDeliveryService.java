package com.altimetrik.ee.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.altimetrik.ee.demo.entity.FoodEntity;
import com.altimetrik.ee.demo.entity.RestaurantEntity;

@Service
public interface FoodDeliveryService {

	public List<FoodEntity> getFoodListForRestaurant(long restaurantId, int locationCode);

	public List<RestaurantEntity> getDeliverableRestaurants(long locationId);
	

}
