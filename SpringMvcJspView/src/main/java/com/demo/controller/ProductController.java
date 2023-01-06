package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	private ProductService pservice;
	public ProductController()
	{
		super();
	}
	
	@GetMapping("/viewProduct")
	public ModelAndView displayAll()
	{
		 List<Product> plist=pservice.displayAll();
		 return new ModelAndView("displayall","plist",plist);
	}
	
	@GetMapping("/deleteProduct/{pid}")
	public ModelAndView deleteProduct(@PathVariable ("pid") int id)
	{
		pservice.deleteProduct(id);
		return new ModelAndView("redirect:/product/viewProduct");
	}
	
	@GetMapping("/editProduct/{pid}")
	public ModelAndView editProduct(@PathVariable ("pid") int id)
	{
		Product p=pservice.displayById(id);
		return new ModelAndView("editProduct","prod",p);
	}
	
	@PostMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam int pid,@RequestParam String pname,@RequestParam int qty,@RequestParam double price)
	{
		pservice.updateById(new Product(pid,pname,qty,price));
		return new ModelAndView("redirect:/product/viewProduct");
	}
	
	@GetMapping("/addproduct")
	public String addproductformdisplay() 
	{
		return "addproduct";
	}
	
	@PostMapping("/insertProduct")
	public ModelAndView insertProduct(@RequestParam int pid,@RequestParam String pname,@RequestParam int qty,@RequestParam double price)
	{
		pservice.addnewProduct(new Product(pid,pname,qty,price));
		return new ModelAndView("redirect:/product/viewProduct");
	
	}

}
