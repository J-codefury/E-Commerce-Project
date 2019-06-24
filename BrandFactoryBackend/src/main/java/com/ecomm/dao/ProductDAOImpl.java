package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	 
	public boolean addProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	 
	public boolean deleteProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	 
	public boolean updateProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	 
	public Product getProduct(int productid) 
	{
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, productid);
		session.close();
		return product;
	}
	
	
	 
	public List<Product> listProduct() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProduct=query.list();
		session.close();
		return listProduct;
	}

	 
	public List<Product> listProductCategoryWise(int categoryid) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product p where p.categoryid=:catid");
		query.setParameter("catid", categoryid);
		List<Product> listProduct=query.list();
		session.close();
		return listProduct;
	}
	
	
	
	
	

}