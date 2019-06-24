package com.ecomm.dao;

import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.OrderDetail;


@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	 
	public boolean paymentProcess(OrderDetail orderDetail) {
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	 
	public boolean updateCartItemStatus(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart set productstatus='P' where username=:uname");
		query.setParameter("uname", username);
		
		
		int row_eff=query.executeUpdate();
		if(row_eff>0)
			return true;
		else
			return false;
		
	}

	 
	public boolean updateOrderDetail(String username, int orderId) {
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart Set orderId=:oid where username=:uname");
		query.setParameter("uname", username);
		query.setParameter("oid", orderId);
		int row_eff=query.executeUpdate();
		
		
		if(row_eff>0)
			return true;
		else
			return false;
	}

}