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
@Table(name = "restaurant_delivarable_location_trn")
public class RestaurantDeliverableLocationEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "restaurant_delivarable_location_trn_id")
	private long restaurantInventoryId;
	
	@Column(name = "restaurant_id")
	private long restaurantId;
	
	@Column(name = "location_id")
	private long locationId;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate;

	public RestaurantDeliverableLocationEntity() {
		super();
	}

	public RestaurantDeliverableLocationEntity(long restaurantId, long locationId) {
		super();
		this.restaurantId = restaurantId;
		this.locationId = locationId;
	}

	public long getRestaurantInventoryId() {
		return restaurantInventoryId;
	}

	public void setRestaurantInventoryId(long restaurantInventoryId) {
		this.restaurantInventoryId = restaurantInventoryId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
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
	
 
}
