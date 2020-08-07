package com.altimetrik.ee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.ee.demo.entity.RestaurantDeliverableLocationEntity;
import com.altimetrik.ee.demo.entity.RestaurantInventoryEntity;

@Repository
public interface RestaurantDeliverableLocationRepository extends JpaRepository<RestaurantDeliverableLocationEntity, Long> {

}
