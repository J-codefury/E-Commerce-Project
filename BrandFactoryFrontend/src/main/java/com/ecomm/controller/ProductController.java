package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;

@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/product")
	public String showProduct(Model m)
	{
		Product product=new Product();
		m.addAttribute("product",product);
		
		List<Product>productList=productDAO.listProduct();
		m.addAttribute("productList",productList);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categorylist",categoryList);
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		List<Supplier>supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierlist",supplierList);
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
		
		
		return "Product";
	}
	
	
	
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> categoryList)
	{
		LinkedHashMap categoryList1=new LinkedHashMap();
		
		int i=0;
		while(i<categoryList.size())
		{
			Category category=categoryList.get(i);
			categoryList1.put(category.getCategoryid(),category.getCategoryname());
			i++;
		}
		
		
		
		return categoryList1;
	}
	
	
	
	
	public LinkedHashMap<Integer,String> getSupplierList(List<Supplier> supplierList)
	{
		LinkedHashMap supplierList1=new LinkedHashMap();
		
		int i=0;
		while(i<supplierList.size())
		{
			Supplier supplier=supplierList.get(i);
			supplierList1.put(supplier.getSupplierid(),supplier.getSuppliername());
			i++;
		}
		
		
		
		return supplierList1;
	}
	
	
	
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product1,Model m)
	{
		productDAO.addProduct(product1);
		
		
		
		
		/*String path="C:\\Users\\DELL\\eclipse-workspace\\BrandFactoryFrontend\\src\\main\\webapp\\resources\\images\\";
		
		path=path+String.valueOf(product1.getProductid())+".jpg";
		
		File image=new File(path);
		
		if(!fileImage.isEmpty())
		{
			try
			{
				byte[] buffer=fileImage.getBytes();
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(buffer);;
				bos.close();
				
 			}
			catch(Exception e)
			{
				m.addAttribute("ErrorInfo", e.getMessage());
			}
			
		}
		else
		{
			m.addAttribute("ErrorInfo", "Problem Occured");
		}
		*/
		
		/*Product product=new Product();
		m.addAttribute("product",product);
		*/
		MultipartFile file=product1.getPimage();
		byte[] buffer=new byte[(int)file.getSize()];
		try {
		InputStream s=file.getInputStream();
		s.read(buffer);
		FileOutputStream fout=new FileOutputStream("C:\\Users\\DELL\\eclipse-workspace\\BrandFactoryFrontend\\src\\main\\webapp\\resources\\images\\"+product1.getProductid()+".jpg");
		fout.write(buffer);
		fout.flush();
		
		fout.close();
		}
		catch(Exception e)
		{
		System.out.println(e);	
		}
		List<Product>productList=productDAO.listProduct();
		m.addAttribute("productList",productList);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		List<Supplier>supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
		
		
		
		
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productid}")
	public String deleteProduct(@PathVariable("productid")int productid,Model m)
	{
		Product product=productDAO.getProduct(productid);
		productDAO.deleteProduct(product);
		
		Product product1=new Product();
		m.addAttribute("product",product1);
		
		List<Product>productList=productDAO.listProduct();
		m.addAttribute("productList",productList);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		
		return "Product";
	}
	
	@RequestMapping(value="/editProduct/{productid}")
	public String editProduct(@PathVariable("productid")int productid,Model m)
	{
		Product product=productDAO.getProduct(productid);
		
		
		m.addAttribute("product",product);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		List<Supplier>supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
		
		return "UpdateProduct";
	}
	

	
	
	
	
	
	
	
	@RequestMapping(value="/productDisplay")
	public String productDisplay(Model m)
	{
		List<Product> listProducts=productDAO.listProduct();
		m.addAttribute("productlist",listProducts);
		
		
		
		
		return "ProductDisplay";
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/categoryDisplay")
	public String categoryDisplay(Model m)
	{
		List<Product> listProducts=productDAO.listProduct();
		m.addAttribute("productlist",listProducts);
		
		
		return "CategoryDisplay";
	}
	
	
	

	
	
	
	
	@RequestMapping(value="/productCategoryWise/{categoryId}")
	public String productCategoryWise(@PathVariable("categoryId")int categoryId,Model m)
	{
		List<Product> listProductCategoryWise=productDAO.listProductCategoryWise(categoryId); 
		m.addAttribute("productlist",listProductCategoryWise);
		
		
		return "ProductDisplay";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String updateProduct(@RequestParam("proId")int productid,@RequestParam("productName")String productname,@RequestParam("productDesc")String productDesc,@RequestParam("categoryId")int categoryid,@RequestParam("supplierId")int supplierid,@RequestParam("stock")int stock,@RequestParam("price")int price,@RequestParam("pimage") MultipartFile fileImage,Model m)
	{
		Product p1=new Product();
		Product product=productDAO.getProduct(productid);
		product.setProductname(productname);
		product.setProductdesc(productDesc);
		product.setCategoryid(categoryid);
		product.setSupplierid(supplierid);
		product.setStock(stock);
		product.setPrice(price);
		
		
		
		productDAO.updateProduct(product);
		
		
		String path="c:/Users/DELL/eclipse-workspace/BrandFactoryFrontend/src/main/webapp/resources/images/";
		
		path=path+String.valueOf(product.getProductid())+".jpg";
		
		File image=new File(path);
		
		if(!fileImage.isEmpty())
		{
			try
			{
				byte[] buffer=fileImage.getBytes();
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(buffer);
				bos.flush();
				bos.close();
				
 			}
			catch(Exception e)
			{
				m.addAttribute("ErrorInfo", e.getMessage());
			}
			
		}
		else
		{
			m.addAttribute("ErrorInfo", "Problem Occured");
		}
		
		
		
		List<Product>productList=productDAO.listProduct();
		m.addAttribute("productList",productList);
		m.addAttribute("product",p1);
		
		return "Product"; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/totalproductdisplay/{productid}")
	public String totalProductDisplay(@PathVariable("productid")int productid,Model m)
	{
		
		Product product=productDAO.getProduct(productid);
		m.addAttribute("product", product);
		
		
		
		return "TotalProductDisplay";
	}
	
	
}