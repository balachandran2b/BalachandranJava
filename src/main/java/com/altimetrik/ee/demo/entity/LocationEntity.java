package com.altimetrik.ee.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "location_mst")
public class LocationEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "location_id")
	private long locationId;
	
	@Column(name = "location_name")
	private String locationName;
	
	@ManyToMany(mappedBy = "deliverableLocationEntityList", fetch = FetchType.LAZY)
	private List<RestaurantEntity> restaurantList;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate;	
	
	public LocationEntity() {
		super();
	}

	public LocationEntity(String locationName) {
		super();
		this.locationName = locationName;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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
	
	public List<RestaurantEntity> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(List<RestaurantEntity> restaurantList) {
		this.restaurantList = restaurantList;
	}

}
