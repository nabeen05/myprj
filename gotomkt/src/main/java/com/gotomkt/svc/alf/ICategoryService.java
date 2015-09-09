package com.gotomkt.svc.alf;

import com.gotomkt.svc.model.Category;
import com.gotomkt.svc.model.CategoryList;

public interface ICategoryService {

	public Category getCategory(String category);
	
	public CategoryList getCategories(String category);
}