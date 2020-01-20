package com.foodorderapp.jc.service;

import java.util.List;


import com.foodorderapp.jc.model.CustomerEntity;
import com.foodorderapp.jc.model.ProductEntity;

public interface CustomerService {
	
	public boolean addCustomer(CustomerEntity customer);
	public List<CustomerEntity> getCustomers();
	public boolean isCustomerExist(String email, String pass);
	public List<ProductEntity> getProducts();
	public CustomerEntity getCustomerById(int customerId);
	public CustomerEntity getCustomerByEmail(String email);
	public boolean addItemToCart(int customerId, int productId);
	public List<ProductEntity> getCartProducts(int customerId);
}
