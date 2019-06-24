package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTest 
{

static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		
		product.setProductname("Samsung");
		product.setProductdesc("M30");
		product.setStock(15);
		product.setSupplierid(2);
		product.setCategoryid(2);
		product.setPrice(13000);
		
		assertTrue("Problem in Adding Category: ",productDAO.addProduct(product));
	}
	@Ignore
	@Test
	public void listProductTest()
	{
		List<Product> listProducts=productDAO.listProduct();
		
		assertTrue("Problem in Listing the Products",listProducts.size()>0);
		
		System.out.println("-----All Products-----");
		for(Product product:listProducts)
		{
			System.out.print(product.getProductid()+":::");
			System.out.print(product.getProductname()+":::");
			System.out.print(product.getProductdesc()+":::");
			System.out.print(product.getStock()+":::");
			System.out.println(product.getPrice()+":::");
		}
	}
	@Ignore
	@Test
	public void listProductCategoryWiseTest()
	{
		List<Product> listProducts=productDAO.listProductCategoryWise(2);
		
		assertTrue("Problem in Listing the Products",listProducts.size()>0);
		
		System.out.println("-----CategoryWise-----");
		for(Product product:listProducts)
		{
			System.out.print(product.getProductid()+":::");
			System.out.print(product.getProductname()+":::");
			System.out.print(product.getProductdesc()+":::");
			System.out.print(product.getStock()+":::");
			System.out.println(product.getPrice()+":::");
		}
	}

}