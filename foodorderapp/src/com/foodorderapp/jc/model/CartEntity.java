package com.foodorderapp.jc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "cart") 
public class CartEntity {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "quantity")
	private int quantity;
	
	public CartEntity() {
	}

	public CartEntity(int id, int customerId, int productId, int quantity) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
