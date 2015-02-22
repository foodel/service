package com.ikhotynskyi.service;

import java.util.List;

import com.ikhotynskyi.entity.Category;

public interface CategoryService {
	
	    void addCategory(Category c);
	    void updateCategory(Category c);
	    List<Category> getCategoriesList();
	    Category getCategoryById(int id);
	    void removeCategory(int id);

}
