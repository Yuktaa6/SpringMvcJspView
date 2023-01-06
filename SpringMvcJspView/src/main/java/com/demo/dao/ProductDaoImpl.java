package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ProductDaoImpl() 
	{
		super();
	}

	@Override
	public List<Product> showAll() 
	{
		return jdbcTemplate.query("select * from product11", BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public int removeProduct(int id)
	{
		return jdbcTemplate.update("delete from product11 where pid=?", new Object[] {id});
	}

	@Override
	public Product showById(int id)
	{
		Product p=(Product) jdbcTemplate.queryForObject("select * from product11 where pid=?", new Object[] {id},
				BeanPropertyRowMapper.newInstance(Product.class));
		return p;
	}

	@Override
	public int modifyById(Product product)
	{
		return jdbcTemplate.update("update product11 set pname=?,qty=?,price=? where pid=?",
				new Object[] {product.getPname(),product.getQty(),product.getPrice(),product.getPid()});
	}

	@Override
	public int addProduct(Product p)
	{
		return jdbcTemplate.update("insert into product11 values (?,?,?,?)",
				new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
	}

	

}
