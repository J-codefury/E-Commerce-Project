 package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartDAO;
import com.ecomm.model.Cart;

public class CartDAOTest
{
static CartDAO cartDao;
@BeforeClass

public static void executefirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ecomm");
	context.refresh();
	cartDao=(CartDAO)context.getBean("cartDao");
	
}

	@Test
	@Ignore
	public void addCartItem()
	{
		Cart  cartItem=new Cart();
	cartItem.setProductid(9);
	cartItem.setProductname("Apple");
	cartItem.setPrice(40000);
	cartItem.setQuantity(6);
	cartItem.setProductStatus("NP");
	cartItem.setUserName("Aravind");

		assertTrue("the problem is with cart Insertion:", cartDao.addCartItem(cartItem));
	}
    @Test
    @Ignore
	public void listCartItems()
	{
		List<Cart> CartItemlist=cartDao.listCartItems("Aravind");
		assertTrue("the problem is with  CartItemlist :", CartItemlist.size()>0);
		for(Cart cart:CartItemlist)
		{
			System.out.println(cart.getCartItemId()+":::");
			System.out.println(cart.getProductname()+":::");
			System.out.println(cart.getQuantity()+":::");
		}
	}
}