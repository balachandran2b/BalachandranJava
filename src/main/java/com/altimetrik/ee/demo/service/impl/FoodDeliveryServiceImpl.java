package com.altimetrik.ee.demo.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.ee.demo.Vo.OrderInfo;
import com.altimetrik.ee.demo.entity.FoodEntity;
import com.altimetrik.ee.demo.entity.LocationEntity;
import com.altimetrik.ee.demo.entity.OrderDetailEntity;
import com.altimetrik.ee.demo.entity.OrderEntity;
import com.altimetrik.ee.demo.entity.RestaurantEntity;
import com.altimetrik.ee.demo.repository.FoodRepository;
import com.altimetrik.ee.demo.repository.LocationRepository;
import com.altimetrik.ee.demo.repository.OrderRepository;
import com.altimetrik.ee.demo.repository.RestaurantRepository;
import com.altimetrik.ee.demo.service.FoodDeliveryService;

@Service
public class FoodDeliveryServiceImpl implements FoodDeliveryService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private FoodRepository foodRepository;

	@Override
	public List<FoodEntity> getFoodListForRestaurant(long restaurantId, int locationCode) {
		Optional<RestaurantEntity> restaurantEntity = restaurantRepository.findById(restaurantId);
		if (!restaurantEntity.isPresent() || !isDeliverable(restaurantEntity, locationCode)) {
			// change to custom exception
			throw new RuntimeException("Restaurant is not available to order");
		}
		return restaurantEntity.get().getFoodsList();
	}

	private boolean isDeliverable(Optional<RestaurantEntity> restaurant, int locationCode) {
		Optional<Long> isDeliverableLocation = restaurant.get().getDeliverableLocationEntityList().stream()
				.map(locationEntity -> locationEntity.getLocationId())
				.filter(locationId -> locationId.equals(locationCode)).findAny();
		return isDeliverableLocation.isPresent();
	}

	@Override
	public List<RestaurantEntity> getDeliverableRestaurants(long locationId) {
		Optional<LocationEntity> locationEntity = locationRepository.findById(locationId);
		return locationEntity.isPresent() ? locationEntity.get().getRestaurantList() : Collections.emptyList();
	}

	@Override
	public long createOrder(OrderInfo orderInfo) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomerId(orderInfo.getCustomerId());
		orderEntity.setLocationCode(orderInfo.getLocationId());
		orderEntity.setRestaurantId(orderInfo.getRestaurantId());
		orderEntity = orderRepository.save(orderEntity);
		List<OrderDetailEntity> orderDetailEntityList = createOrderDetailList(orderInfo, orderEntity);
		orderEntity.setOrderDetailEntityList(orderDetailEntityList);
		double price = getOrderPrice(orderDetailEntityList);
		orderEntity.setPrice(price);
		orderRepository.flush();
		return orderEntity.getOrderId();
	}

	private List<OrderDetailEntity> createOrderDetailList(OrderInfo orderInfo, OrderEntity orderEntity) {
		List<OrderDetailEntity> orderDetailEntityList = orderInfo.getFoodQuantityMap().entrySet().stream()
				.map(orderEntry -> {
					FoodEntity foodEntity = foodRepository.findById(orderEntry.getKey()).get();
					OrderDetailEntity orderDetail = new OrderDetailEntity();
					orderDetail.setFood(foodEntity);
					orderDetail.setOrder(orderEntity);
					orderDetail.setQuantity(orderEntry.getValue());
					return orderDetail;
				}).collect(Collectors.toList());
		return orderDetailEntityList;
	}

	private double getOrderPrice(List<OrderDetailEntity> orderDetailEntityList) {
		return orderDetailEntityList.stream()
				.map(orderDetail -> (orderDetail.getFood().getPrice()) * orderDetail.getQuantity())
				.reduce(0D, (carry, current) -> carry + current);

	}

	@Override
	public Optional<OrderEntity> getOrderDetail(long orderId) {
		return orderRepository.findById(orderId);
	}

	@Override
	public boolean deleteOrder(long orderId) {
		Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
		if(orderEntity.isPresent()) {
			return false;
		}else {
			orderRepository.delete(orderEntity.get());
			return true;
		}
	}

	@Override
	public boolean updateOrder(long orderId, OrderInfo orderInfo) {
		Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
		if(orderEntity.isPresent()) {
			return false;
		}else {
			OrderEntity updateOrderEntity = orderEntity.get();
			updateOrderEntity.setCustomerId(orderInfo.getCustomerId());
			updateOrderEntity.setLocationCode(orderInfo.getLocationId());
			updateOrderEntity.setRestaurantId(orderInfo.getRestaurantId());
			List<OrderDetailEntity> orderDetailEntityList = createOrderDetailList(orderInfo, updateOrderEntity);
			updateOrderEntity.setOrderDetailEntityList(orderDetailEntityList);
			double price = getOrderPrice(orderDetailEntityList);
			updateOrderEntity.setPrice(price);
			orderRepository.flush();
			return true;
		}
	}

}
