package com.gotomkt.svc.model;

public class Category {

	private String category;

	private String[] subCategories;
	
	public String[] getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(String[] subCategories) {
		this.subCategories = subCategories;
	}

	public String getCategory() {
		return category;
	}

	public void setSubCategory(String subCategory) {
		this.category = subCategory;
	}
	
}
