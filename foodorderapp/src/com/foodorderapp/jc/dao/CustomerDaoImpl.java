package com.foodorderapp.jc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodorderapp.jc.model.CartEntity;
import com.foodorderapp.jc.model.CustomerEntity;
import com.foodorderapp.jc.model.ProductEntity;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int insertcustomer(CustomerEntity customer) {
		sessionFactory.getCurrentSession().save(customer);
		sessionFactory.getCurrentSession().save(customer.getAddress());
		return 1;
	}

	@Override
	public List<CustomerEntity> getcustomers() {
		return getSession().createQuery("from CustomerEntity", CustomerEntity.class).list();
	}

	@Override
	public List<ProductEntity> getproducts() {
		return getSession().createQuery("from ProductEntity", ProductEntity.class).list();
	}

	@Override
	public CustomerEntity getCustomerById(int customerId) {
		return (CustomerEntity)getSession().get(CustomerEntity.class, customerId);
		
	}

	@Override
	public CustomerEntity getCustomerByEmail(String email) {
		String hql = "from CustomerEntity where email= :e_mail";
		Query<?> query = getSession().createQuery(hql);
		query.setParameter("e_mail", email);
		if (query.list().size() > 0) {
			return (CustomerEntity)query.list().get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public int insertCartItem(int customerId, int productId) {
		CartEntity cart = new CartEntity();
		cart.setCustomerId(customerId);
		cart.setProductId(productId);
		cart.setQuantity(1);
		sessionFactory.getCurrentSession().save(cart);
		return 1;
	}

	@Override
	public List<ProductEntity> getProductsFromCart(int customerId) {
		String hql = "from ProductEntity p where p.id in (select c.productId from CartEntity c where c.customerId = :cust_id)";
		Query<?> query = getSession().createQuery(hql);
		query.setParameter("cust_id", customerId);
		return (List<ProductEntity>) query.list();
	}


}
