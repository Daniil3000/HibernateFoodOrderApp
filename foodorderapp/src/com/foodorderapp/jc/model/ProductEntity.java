package com.foodorderapp.jc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "product") 
public class ProductEntity {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="size")
	private String size;
	
	@Column(name="price")
	private Float price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="category")
	private String category;
	
	@Column(name="in_stock")
	private int inStock;


	public ProductEntity() {
	}
	
	

	public ProductEntity(int id, String name, String size, Float price, String description, String category,
			int inStock) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.price = price;
		this.description = description;
		this.category = category;
		this.inStock = inStock;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	

}
