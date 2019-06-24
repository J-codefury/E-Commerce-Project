package com.ecomm.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Cart;

@Repository("cartDao")
@Transactional

public class CartDAOImpl implements CartDAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	

	 
	public boolean addCartItem(Cart cartItem)
	{
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
			
		}
		catch(Exception e)
		{
	
		return false;
	}
	
	}
	
	 
	public boolean deleteCartItem(Cart cartItem)
	{
		try
		{
		sessionFactory.getCurrentSession().delete(cartItem);
		return true;
		}
		catch(Exception e)
				{
					
			
		return false;
	}
	}
	

	 
	public boolean updateCartItem(Cart cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}

	}
	
	public List<Cart> listCartItems(String username)
	{
	 Session s=sessionFactory.openSession();
	 Query q=s.createQuery("from Cart c where c.username=:uname and productstatus='NP'");
	 q.setParameter("uname", username);
	 List<Cart> CartItemlist=q.list();
	 return CartItemlist;
	}
	
	public Cart getCartItem(int cartitemid) 
	{
		Session s=sessionFactory.openSession();
		Cart cartItem=s.get(Cart.class, cartitemid);
		s.close();
		return cartItem;
		
	}

}
