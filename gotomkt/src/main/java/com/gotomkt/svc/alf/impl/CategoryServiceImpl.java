package com.gotomkt.svc.alf.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gotomkt.svc.alf.ICategoryService;
import com.gotomkt.svc.model.Category;
import com.gotomkt.svc.model.CategoryList;

@Component
public class CategoryServiceImpl implements ICategoryService{

	@Override
	public Category getCategory(String category) {
		
		Category cate = null;
		if(category != null && category.equals("automobile")){
			System.out.println("inside:"+category);
			cate = new Category();
			cate.setSubCategory(category);
			cate.setSubCategories(new String[]{"Tire Fix", "Oil Change", "Auto Body Repair","Auto Glass Fix"});
		}
		return cate;
	}

	// iterate the comma separated list 
	@Override
	public CategoryList getCategories(String category) {
		String[] categories = category.split(",");
		System.out.println(categories);
		CategoryList catList = new CategoryList();
		List<Category> list = new ArrayList<Category>();
		
		Category cate = null;
		if(categories != null && categories.length >=1){
			
			for(String cat: categories){
				
				if(cat != null && cat.equals("automobile")){
					System.out.println("inside:"+cat);
					cate = new Category();
					cate.setSubCategory(cat);
					cate.setSubCategories(new String[]{"Tire Fix", "Oil Change", "Auto Body Repair","Auto Glass Fix"});
					list.add(cate);
				}
				if(cat != null && cat.equals("health")){
					System.out.println("inside:"+cat);
					cate = new Category();
					cate.setSubCategory(cat);
					cate.setSubCategories(new String[]{"Primary Care", "Orthopedic", "Medicine","Nurshing Home"});
					list.add(cate);
				}
			}
			catList.setCategories(list);
		}
		
		return catList;
	}

	//
	
}
