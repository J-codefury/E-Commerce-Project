package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;



@Controller
public class CartController
{
	
@Autowired
CartDAO cartDao;

@Autowired
ProductDAO productDao;

@RequestMapping(value="/showCart")
public String showCart(Model m,HttpSession session)
{
	
	String username=(String)session.getAttribute("username");
	List<Cart>cartItemList=cartDao.listCartItems(username);
	m.addAttribute("cartItemList", cartItemList);
	m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
	session.setAttribute("cartSize", new Integer(cartItemList.size()));
	 
	return "Cart";
	
	
}


@RequestMapping(value="/addToCart/{productid}")
public String addToCart(@PathVariable("productid")int productid,@RequestParam("quantity")int quantity,HttpSession session,Model m)
{
	
	String username=(String)session.getAttribute("username");
	Product product=productDao.getProduct(productid);
	Cart cartItem=new Cart();
	cartItem.setProductId(product.getProductid());
	cartItem.setProductName(product.getProductname());
	cartItem.setPrice(product.getPrice());
	cartItem.setQuantity(quantity);
	cartItem.setUserName(username);
	cartItem.setProductStatus("NP");
	
	cartDao.addCartItem(cartItem);
	List<Cart>cartItemList=cartDao.listCartItems(username);
	m.addAttribute("cartItemList", cartItemList);
	m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
	session.setAttribute("cartSize", new Integer(cartItemList.size()));
	return "Cart";
}

@RequestMapping(value="/updateCartItem/{cartItemId}")
public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,HttpSession session,Model m)
{
	
	String username=(String)session.getAttribute("username");
	Cart cartItem=cartDao.getCartItem(cartItemId);
	cartItem.setQuantity(quantity);
	cartDao.updateCartItem(cartItem);

	List<Cart>cartItemList=cartDao.listCartItems(username);
	m.addAttribute("cartItemList", cartItemList);
	m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
	session.setAttribute("cartSize", new Integer(cartItemList.size()));

	return "Cart";
	
}

@RequestMapping(value="/deleteCartItem/{cartItemId}")
public String updateCartItem(@PathVariable("cartItemId")int cartItemId,HttpSession session,Model m)
{
	
	String username=(String)session.getAttribute("username");
	Cart cartItem=cartDao.getCartItem(cartItemId);
	cartDao.deleteCartItem(cartItem);
	List<Cart>cartItemList=cartDao.listCartItems(username);
	m.addAttribute("cartItemList", cartItemList);
	m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
	session.setAttribute("cartSize", new Integer(cartItemList.size()));
	return "Cart";

}

public int getGrandTotal(List<Cart>cartItemList)
{
	
	int grandTotal=0;
	int count=0;
	
while(count<cartItemList.size())
{
	Cart cartItem=cartItemList.get(count);
	grandTotal= grandTotal+(cartItem.getQuantity()*cartItem.getPrice());
	count++;
}
 
return grandTotal;

}

@RequestMapping(value="/checkOut")
public String showOderConfirm(HttpSession session,Model m)
{
	
	String username=(String)session.getAttribute("username");
	List<Cart>cartItemList=cartDao.listCartItems(username);
	m.addAttribute("cartItemList", cartItemList);
	m.addAttribute("grandtotal", this.getGrandTotal(cartItemList));
	session.setAttribute("cartSize", new Integer(cartItemList.size()));
	
	return "OrderConfirm";
	
}
}