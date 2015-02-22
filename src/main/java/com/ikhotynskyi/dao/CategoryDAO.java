package com.ikhotynskyi.dao;

import java.util.List;

import com.ikhotynskyi.entity.Category;

public interface CategoryDAO {
	
	void addCategory(Category c);
    void updateCategory(Category c);
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    void removeCategory(int id);

}
	