package com.altimetrik.ee.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "restaurant_inventory_trn")
public class RestaurantInventoryEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "restaurant_inventory_id")
	private long restaurantInventoryId;
	
	@Column(name = "restaurant_id")
	private long restaurantId;
	
	@Column(name = "food_id")
	private long foodId;
	
	@Column(name = "is_food_available")
	private int isFoodAvailable;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate;
	
	public long getRestaurantInventoryId() {
		return restaurantInventoryId;
	}

	public void setRestaurantInventoryId(int restaurantInventoryId) {
		this.restaurantInventoryId = restaurantInventoryId;
	}

	public long getRestaurant_id() {
		return restaurantId;
	}

	public void setRestaurant_id(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getFood_id() {
		return foodId;
	}

	public void setFood_id(int foodId) {
		this.foodId = foodId;
	}

	public int getIsFoodAvailable() {
		return isFoodAvailable;
	}

	public void setIsFoodAvailable(int isFoodAvailable) {
		this.isFoodAvailable = isFoodAvailable;
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
	
	public RestaurantInventoryEntity() {
		super();
	}
	
	public RestaurantInventoryEntity(long restaurant_id, long food_id, int isFoodAvailable) {
		super();
		this.restaurantId = restaurant_id;
		this.foodId = food_id;
		this.isFoodAvailable = isFoodAvailable;
	}

}
