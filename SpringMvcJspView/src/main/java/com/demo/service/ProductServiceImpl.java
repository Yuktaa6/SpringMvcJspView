package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductDao pdao;
	
	public ProductServiceImpl() 
	{
		super();
	}

	@Override
	public List<Product> displayAll()
	{
		return pdao.showAll();
	}

	@Override
	public int deleteProduct(int id)
	{
		return pdao.removeProduct(id);
	}

	@Override
	public Product displayById(int id) 
	{
		return pdao.showById(id);
	}

	@Override
	public int updateById(Product product)
	{
		return pdao.modifyById(product);
	}

	@Override
	public int addnewProduct(Product product)
	{
		return pdao.addProduct(product);
	}

	

}
