package com.altimetrik.ee.demo.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.ee.demo.entity.FoodEntity;
import com.altimetrik.ee.demo.entity.LocationEntity;
import com.altimetrik.ee.demo.entity.RestaurantEntity;
import com.altimetrik.ee.demo.repository.LocationRepository;
import com.altimetrik.ee.demo.repository.RestaurantRepository;
import com.altimetrik.ee.demo.service.FoodDeliveryService;

@Service
public class FoodDeliveryServiceImpl implements FoodDeliveryService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public List<FoodEntity> getFoodListForRestaurant(long restaurantId, int locationCode) {
		Optional<RestaurantEntity> restaurantEntity = restaurantRepository.findById(restaurantId);
		if(!restaurantEntity.isPresent() || !isDeliverable(restaurantEntity, locationCode)) {
			//change to custom exception
			throw new RuntimeException("Restaurant is not available to order");
		}
		return restaurantEntity.get().getFoodsList();
	}
	
	
	private boolean isDeliverable(Optional<RestaurantEntity> restaurant, int locationCode) {
		Optional<Long> isDeliverableLocation = restaurant.get().getDeliverableLocationEntityList()
				.stream()
				.map(locationEntity -> locationEntity.getLocationId())
				.filter(locationId -> locationId.equals(locationCode))
				.findAny();
		return isDeliverableLocation.isPresent();
	}


	@Override
	public List<RestaurantEntity> getDeliverableRestaurants(long locationId) {
		Optional<LocationEntity> locationEntity = locationRepository.findById(locationId);
		return locationEntity.isPresent()? locationEntity.get().getRestaurantList(): Collections.emptyList();
	}

}
