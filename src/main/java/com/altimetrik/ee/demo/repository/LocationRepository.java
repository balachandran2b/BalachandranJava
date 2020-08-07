package com.altimetrik.ee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.ee.demo.entity.LocationEntity;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

}
