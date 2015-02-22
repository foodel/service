package com.ikhotynskyi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ikhotynskyi.dao.CategoryDAO;
import com.ikhotynskyi.entity.Category;
import com.ikhotynskyi.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDAO categoryDAO;

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	@Transactional
	public void addCategory(Category c) {
		this.categoryDAO.addCategory(c);
	}

	@Override
	@Transactional
	public void updateCategory(Category c) {
		this.categoryDAO.updateCategory(c);
	}

	@Override
	@Transactional
	public List<Category> getCategoriesList() {
		return this.categoryDAO.getAllCategories();
	}

	@Override
	@Transactional
	public Category getCategoryById(int id) {
		return this.categoryDAO.getCategoryById(id);
	}

	@Override
	@Transactional
	public void removeCategory(int id) {
		this.categoryDAO.removeCategory(id);
	}

}
