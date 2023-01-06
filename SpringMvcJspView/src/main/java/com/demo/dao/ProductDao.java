package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao 
{

	List<Product> showAll();

	int removeProduct(int id);
	
	Product showById(int id);

	int modifyById(Product product);

	int addProduct(Product product);

}
