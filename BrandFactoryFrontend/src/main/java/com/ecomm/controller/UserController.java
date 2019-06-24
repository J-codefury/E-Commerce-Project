package com.ecomm.controller;



import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;

@Controller
public class UserController
{
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	UserDAO userdetailDao;
	
@RequestMapping(value="/login_success")
public String loginSuccess(HttpSession session,Model m)
{
	
String page="";
boolean loggedIn=false;


SecurityContext sContext=SecurityContextHolder.getContext();
Authentication authority=sContext.getAuthentication();

String username=authority.getName();

Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authority.getAuthorities();

List<Product> listProduct=productDao.listProduct();
m.addAttribute("productlist", listProduct);

List<Category> categoryList=categoryDao.listCategories();
session.setAttribute("categorylist", categoryList);


for(GrantedAuthority role:roles)
{
	
	session.setAttribute("role", role.getAuthority());
	
	if(role.getAuthority().equals("ROLE_USER"))
	{
		loggedIn=true;
		page="UserHome";
		session.setAttribute("username", username);
		session.setAttribute("loggedIn", loggedIn);
		return page;
	}
	else
	{
		loggedIn=true;
		page="AdminHome";
		session.setAttribute("username", username);
		session.setAttribute("loggedIn", loggedIn);
		return page;
	}
	
}
System.out.println("Success"+username);
return "ProductDisplay";

}

@RequestMapping(value="/perform_logout")
public String logOut(HttpSession s,Model m)
{
	
	s.invalidate();
	return "Login";
	
}


@RequestMapping(value="/relogin")
public String relogin(HttpSession s,Model m)
{
	
	s.invalidate();
	return "Relogin";
	
}






@RequestMapping("/registerUser")
public String registerUser(@RequestParam("username")String username, @RequestParam("email")String email,@RequestParam("address")String address,@RequestParam("mobile")String mobile, @RequestParam("password")String password, Model m)
{
	
	UserDetail user=new UserDetail();
	
	user.setUsername(username);
	user.setAddress(address);
	user.setEmailId(email);
	user.setPassword(password);
	user.setMobileNo(mobile);
	user.setRole("ROLE_USER");
	user.setEnabled(true);

  userdetailDao.registerUser(user); 
  System.out.println("Register Successfully");
    
	return "Login";
}
}