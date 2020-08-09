package com.altimetrik.ee.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.altimetrik.ee.demo.Vo.OrderInfo;
import com.altimetrik.ee.demo.entity.FoodEntity;
import com.altimetrik.ee.demo.entity.OrderEntity;
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
		return new ResponseEntity<List<FoodEntity>>(foodList, HttpStatus.OK);
	}

	@GetMapping(value = "/deliverableRestaurants/{locationCode}")
	public List<RestaurantEntity> deliverableRestaurants(@PathVariable long locationId) {
		List<RestaurantEntity> restaurantEntityList = foodDeliveryService.getDeliverableRestaurants(locationId);
		return restaurantEntityList;
	}
	
	@PostMapping(value = "/order")
	public ResponseEntity<Object> createOrder(@RequestBody OrderInfo orderInfo) {
		long orderId = foodDeliveryService.createOrder(orderInfo);
		URI location = ServletUriComponentsBuilder.
				fromCurrentRequestUri().path("{orderId}").buildAndExpand(orderId).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(value = "/order/{orderId}")
	public OrderEntity getOrderDetail(@PathVariable long orderId) {
		Optional<OrderEntity> orderEntity = foodDeliveryService.getOrderDetail(orderId);
		if(orderEntity.isPresent()) {
			//change to custom exception.
			throw new RuntimeException("Order not present");
		}
		return orderEntity.get();
	}
	
	@DeleteMapping(value = "/order/{orderId}")
	public ResponseEntity<Object> deleteOrder(@PathVariable long orderId) {
		boolean isDeleted = foodDeliveryService.deleteOrder(orderId);
		if(isDeleted) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping(value = "/order/{orderId}")
	public ResponseEntity<Object> updateOrder(@PathVariable long orderId, @RequestBody OrderInfo orderInfo) {
		boolean isUpdated = foodDeliveryService.updateOrder(orderId, orderInfo);
		if(!isUpdated) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}

}
