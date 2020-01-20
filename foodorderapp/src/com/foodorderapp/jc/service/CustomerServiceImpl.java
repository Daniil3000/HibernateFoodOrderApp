package com.foodorderapp.jc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodorderapp.jc.dao.CustomerDao;
import com.foodorderapp.jc.model.CustomerEntity;
import com.foodorderapp.jc.model.ProductEntity;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;

	@Override
	@Transactional
	public boolean addCustomer(CustomerEntity customer) {
		return customerDao.insertcustomer(customer)>0;
	}

	@Override
	@Transactional
	public List<CustomerEntity> getCustomers() {
		return customerDao.getcustomers();
	}

	@Override
	@Transactional
	public boolean isCustomerExist(String email, String pass) {
		List<CustomerEntity> customers = this.getCustomers();
		boolean result = false;
		for (CustomerEntity dbcustomer : customers) {
			if (dbcustomer.getEmail().equals(email) && dbcustomer.getPass().equals(pass)) {
				result = true;				
			}	
		}
		return result;
	}

	@Override
	public List<ProductEntity> getProducts() {
		return customerDao.getproducts();
	}

	@Override
	public CustomerEntity getCustomerById(int customerId) {
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public CustomerEntity getCustomerByEmail(String email) {
		return customerDao.getCustomerByEmail(email);
	}

	@Override
	public boolean addItemToCart(int customerId, int productId) {
		return customerDao.insertCartItem(customerId, productId)>0;
	}

	@Override
	public List<ProductEntity> getCartProducts(int customerId) {
		return customerDao.getProductsFromCart(customerId);
	}

}
