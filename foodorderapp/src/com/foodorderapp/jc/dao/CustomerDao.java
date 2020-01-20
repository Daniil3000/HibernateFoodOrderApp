package com.foodorderapp.jc.dao;

import java.util.List;

import com.foodorderapp.jc.model.CustomerEntity;
import com.foodorderapp.jc.model.ProductEntity;

public interface CustomerDao {
	public int insertcustomer(CustomerEntity customer);
	public List<CustomerEntity> getcustomers();
	public List<ProductEntity> getproducts();
	public CustomerEntity getCustomerById(int customerId);
	public CustomerEntity getCustomerByEmail(String email);
	public int insertCartItem(int customerId, int productId);
	public List<ProductEntity> getProductsFromCart(int customerId);

}
