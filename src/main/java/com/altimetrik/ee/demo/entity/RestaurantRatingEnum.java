package com.altimetrik.ee.demo.entity;

public enum RestaurantRatingEnum {
	
	ONE_STAR(1),
	
	TWO_STAR(2),
	
	THREE_STAR(3),
	
	FOUR_STAR(4),
	
	FIVE_STAR(5);
	
	private RestaurantRatingEnum(int rating) {
		this.rating = rating;
	}

	int rating;
	

}
