package com.altimetrik.ee.demo.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.altimetrik.ee.demo.entity.CustomerEntity;
import com.altimetrik.ee.demo.entity.FoodEntity;
import com.altimetrik.ee.demo.entity.LocationEntity;
import com.altimetrik.ee.demo.entity.RestaurantDeliverableLocationEntity;
import com.altimetrik.ee.demo.entity.RestaurantEntity;
import com.altimetrik.ee.demo.entity.RestaurantInventoryEntity;
import com.altimetrik.ee.demo.repository.CustomerRepository;
import com.altimetrik.ee.demo.repository.FoodRepository;
import com.altimetrik.ee.demo.repository.LocationRepository;
import com.altimetrik.ee.demo.repository.RestaurantDeliverableLocationRepository;
import com.altimetrik.ee.demo.repository.RestaurantInventoryRepository;
import com.altimetrik.ee.demo.repository.RestaurantRepository;

@Component
public class DataPrePopulationCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private RestaurantInventoryRepository restaurantInventoryRepository;
	
	@Autowired
	private RestaurantDeliverableLocationRepository deliverableLocationRespository;
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {
		
//		foodRepository.deleteAll();
//		locationRepository.deleteAll();
//		restaurantRepository.deleteAll();
//		restaurantInventoryRepository.deleteAll();
//		customerRepository.deleteAll();
//		deliverableLocationRespository.deleteAll();
//		
//		List<FoodEntity> foodsList = new ArrayList<>();
//		List<RestaurantEntity> restaurantsList = new ArrayList<>();
//		List<LocationEntity> locationEntityList = new ArrayList<>();
//		List<RestaurantDeliverableLocationEntity> deliverableLocationsList = new ArrayList<>();
//		List<RestaurantInventoryEntity> resInvList = new ArrayList<>();
//		List<CustomerEntity> customerList = new ArrayList<>();
//		IntStream.range(1, 20).forEach(index -> {
//			foodsList.add(prePopulateFoodEntity(index));
//			restaurantsList.add(prePopulateRestaurantEntity(index));
//			resInvList.add(prePopulateRestaurantInventoryEntity(index));
//			customerList.add(prePopulateCustomerEntity(index));
//			locationEntityList.add(prePopulateLocationEntity(index));
//			deliverableLocationsList.add(prePopulateDeliverableLocationEntity(index));
//		});
//		foodRepository.saveAll(foodsList);
//		locationRepository.saveAll(locationEntityList);
//		restaurantRepository.saveAll(restaurantsList);
//		restaurantInventoryRepository.saveAll(resInvList);
//		customerRepository.saveAll(customerList);
//		deliverableLocationRespository.saveAll(deliverableLocationsList);
	}

	private RestaurantDeliverableLocationEntity prePopulateDeliverableLocationEntity(int index) {
		return new RestaurantDeliverableLocationEntity(index, index);
	}

	private LocationEntity prePopulateLocationEntity(int index) {
		return new LocationEntity("Location name" + index);
	}

	private CustomerEntity prePopulateCustomerEntity(int index) {
		return new CustomerEntity("Customer " + index);
	}

	private RestaurantInventoryEntity prePopulateRestaurantInventoryEntity(int index) {
		return new RestaurantInventoryEntity(index, index, 1);
	}

	private RestaurantEntity prePopulateRestaurantEntity(int index) {
		return new RestaurantEntity(index, "Restaurant  " + index);
	}

	private FoodEntity prePopulateFoodEntity(int index) {
		return new FoodEntity("Food " + index, 10 * index);
	}

}
