package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> displayAll();

	int deleteProduct(int id);

	Product displayById(int id);

	int updateById(Product product);

	int addnewProduct(Product product);

}
