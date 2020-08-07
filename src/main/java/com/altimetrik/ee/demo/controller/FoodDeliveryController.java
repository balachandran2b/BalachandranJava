package com.altimetrik.ee.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.ee.demo.entity.FoodEntity;
import com.altimetrik.ee.demo.entity.RestaurantEntity;
import com.altimetrik.ee.demo.service.FoodDeliveryService;

@RestController
@RequestMapping("/foodDelivery")
public class FoodDeliveryController {

	@Autowired
	private FoodDeliveryService foodDeliveryService;

	@GetMapping(value = "/searchFoods/{restaurantId}", params = { "locationCode" })
	public ResponseEntity<List<FoodEntity>> searchFoods(@PathVariable long restaurantId,
			@RequestParam int locationCode) {
		List<FoodEntity> foodList = foodDeliveryService.getFoodListForRestaurant(restaurantId, locationCode);
		return new ResponseEntity(foodList, HttpStatus.OK);
	}

	@GetMapping(value = "/deliverableRestaurants/{locationCode}")
	public List<RestaurantEntity> deliverableRestaurants(@PathVariable long locationId) {
		List<RestaurantEntity> restaurantEntityList = foodDeliveryService.getDeliverableRestaurants(locationId);
		return restaurantEntityList;
	}

}
