package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.User;

@Repository
public class LoginDaoImpl implements LoginDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public LoginDaoImpl() 
	{
		super();
	}

	@Override
	public User validateUser(String uname, String pass)
	{
		return jdbcTemplate.queryForObject("select * from user where uname=? and password=?", 
				new Object[] {uname,pass},BeanPropertyRowMapper.newInstance(User.class));
	}

}
