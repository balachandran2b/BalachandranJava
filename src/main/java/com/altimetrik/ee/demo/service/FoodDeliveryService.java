package com.altimetrik.ee.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.altimetrik.ee.demo.Vo.OrderInfo;
import com.altimetrik.ee.demo.entity.FoodEntity;
import com.altimetrik.ee.demo.entity.OrderEntity;
import com.altimetrik.ee.demo.entity.RestaurantEntity;

@Service
public interface FoodDeliveryService {

	public List<FoodEntity> getFoodListForRestaurant(long restaurantId, int locationCode);

	public List<RestaurantEntity> getDeliverableRestaurants(long locationId);

	public long createOrder(OrderInfo orderInfo);

	public Optional<OrderEntity> getOrderDetail(long orderId);

	public boolean deleteOrder(long orderId);

	public boolean updateOrder(long orderId, OrderInfo orderInfo);
	
}
