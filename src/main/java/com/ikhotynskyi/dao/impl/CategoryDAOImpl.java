package com.ikhotynskyi.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ikhotynskyi.dao.CategoryDAO;
import com.ikhotynskyi.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(CategoryDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addCategory(Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Category saved successfully, Category Details=" + c);
	}

	@Override
	public void updateCategory(Category c) {
		 Session session = this.sessionFactory.getCurrentSession();
	        session.update(c);
	        logger.info("Category updated successfully, Category Details=" + c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		 Session session = this.sessionFactory.getCurrentSession();
	        List<Category> categoriesList = session.createQuery("FROM Category").list();
	        for(Category c : categoriesList){
	            logger.info("Person list:" + c);
	        }
	        return categoriesList;
	}

	@Override
	public Category getCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();      
		Category c = (Category) session.load(Category.class, new Integer(id));
        logger.info("Category loaded successfully, Category details=" + c);
        return c;
	}

	@Override
	public void removeCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category c = (Category) session.load(Category.class, new Integer(id));
        if(null != c){
            session.delete(c);
        }
        logger.info("Category deleted successfully, category details=" + c);
	}

}
