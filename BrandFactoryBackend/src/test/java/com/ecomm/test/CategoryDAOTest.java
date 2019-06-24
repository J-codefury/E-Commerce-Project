package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest 
{
	
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}

	@Test
	@Ignore
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryname("Apple");
		category.setCategorydesc("Mobile");
		
		assertTrue("Problem in category creation:",categoryDAO.addCategory(category));
	}
	

	@Test
	@Ignore
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(6);
		assertTrue("Problem in category deletion:",categoryDAO.deleteCategory(category));
	}

	@Test
	@Ignore
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(8);
		category.setCategoryname("DELL");
		assertTrue("Problem in category updation:",categoryDAO.updateCategory(category));
	}
	
	@Test
	@Ignore
	public void listCategoryTest()
	{
		List<Category> categoryList=categoryDAO.listCategories();
		
		assertTrue("Problem in Listing Categories",categoryList.size()>0);
		
		for(Category category:categoryList)
		{
			System.out.print(category.getCategoryid()+":::");
			System.out.print(category.getCategoryname()+":::");
			System.out.println(category.getCategorydesc());
		}
	}
}
	