package com.company.dao;

public class CartDAO {
	public void addToCart() {
		String sql = "insert into cart(user_id,product_id,quantity) values(?,?,?)";
	}
	
}
