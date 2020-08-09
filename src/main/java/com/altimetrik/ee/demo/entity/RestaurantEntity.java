package com.altimetrik.ee.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "restaurant_mst")
public class RestaurantEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "restaurant_id")
	private long restaurantId;
	
	@Column(name = "location_code")
	private int locationCode;
	
	@Column(name = "restaurant_name")
	private String restaurantName;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "restaurant_delivarable_location_trn", joinColumns = {
			@JoinColumn(name = "restaurant_id")
	}, inverseJoinColumns = {@JoinColumn(name = "location_id")})
	private List<LocationEntity> deliverableLocationEntityList;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "restaurant_inventory_trn", joinColumns = {
			@JoinColumn(name = "restaurant_id")
	}, inverseJoinColumns = {@JoinColumn(name = "food_id")})
	private List<FoodEntity> foodsList;
	
	@Column(name = "rating")
	private RestaurantRatingEnum rating;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate;
	
	public RestaurantEntity() {
		super();
	}

	public RestaurantEntity(int locationCode, String restaurantName) {
		super();
		this.locationCode = locationCode;
		this.restaurantName = restaurantName;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(int locationCode) {
		this.locationCode = locationCode;
	}


	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public List<FoodEntity> getFoodsList() {
		return foodsList;
	}

	public void setFoodsList(List<FoodEntity> foodsList) {
		this.foodsList = foodsList;
	}
	
	public List<LocationEntity> getDeliverableLocationEntityList() {
		return deliverableLocationEntityList;
	}

	public void setDeliverableLocationEntityList(List<LocationEntity> deliverableLocationEntityList) {
		this.deliverableLocationEntityList = deliverableLocationEntityList;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public RestaurantRatingEnum getRating() {
		return rating;
	}

	public void setRating(RestaurantRatingEnum rating) {
		this.rating = rating;
	}

}
