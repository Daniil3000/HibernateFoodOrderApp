package com.foodorderapp.jc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foodorderapp.jc.model.CustomerEntity;
import com.foodorderapp.jc.model.ProductEntity;
import com.foodorderapp.jc.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService service;

	@RequestMapping("/home")
	public String gohome() {

		return "home";
	}

	@RequestMapping("/registration")
	public ModelAndView getRegistrationForm() {
		ModelAndView mv = new ModelAndView("registration");
		mv.addObject("customer", new CustomerEntity());
		return mv;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute("customer") CustomerEntity customer) {
		if (service.addCustomer(customer))
			return "redirect:/home";
		else {
			return "ErrorPage";
		}
	}

	@RequestMapping("/login")
	public ModelAndView getLoginForm() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("customer", new CustomerEntity());
		return mv;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginAction(@ModelAttribute("customer") CustomerEntity customer) {
		if (service.isCustomerExist(customer.getEmail(), customer.getPass())) {
			CustomerEntity fetchedCustomer = service.getCustomerByEmail(customer.getEmail());
			int userId = fetchedCustomer.getId();
			return "redirect:/order?cust_id=" + userId;
		}

		else {
			return ("redirect:/registration");
		}

	}

	@RequestMapping(value = "/order")
	public ModelAndView getOrderPage(@RequestParam("cust_id") int customerId) {
		ModelAndView mv = new ModelAndView("order");
		List<ProductEntity> products = service.getProducts();
		CustomerEntity fetchedCustomer = service.getCustomerById(customerId);
		List<ProductEntity> cartProducts = service.getCartProducts(fetchedCustomer.getId());
		mv.addObject("loggedCustomer", fetchedCustomer);
		mv.addObject("productList", products);
		mv.addObject("orderedProductList", cartProducts);
		mv.addObject("product", new ProductEntity());
		return mv;
	}

	@RequestMapping(value = "additem")
	public String addToCart(@RequestParam("itemId") int prodId,
			@RequestParam("custId") int custId) {
		int customerId = custId;
		int productId = prodId;
		if (service.addItemToCart(customerId, productId))
			return "redirect:/order?cust_id=" + customerId;
		else
			return "ErrorPage";
	}

}
