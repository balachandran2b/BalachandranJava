package com.altimetrik.ee.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "order_trn")
public class OrderEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private long orderId;
	
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "restaurant_id")
	private long restaurantId;
	
	@Column(name = "location_code")
	private int locationCode;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate;

	public OrderEntity(long customerId, long restaurantId, int locationCode) {
		super();
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.locationCode = locationCode;
	}

	public OrderEntity() {
		super();
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
