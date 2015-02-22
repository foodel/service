package com.ikhotynskyi.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ikhotynskyi.dao.RoleDAO;
import com.ikhotynskyi.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{

	private static final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void addRole(Role r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(r);
		logger.info("Role saved successfully, Role Details=" + r);
	}

	@Override
	public void updateRole(Role r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(r);
		logger.info("Role updated successfully, Role Details=" + r);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRoles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Role> roles = session.createQuery("FROM Role").list();
		for (Role r : roles) {
			logger.info("Roles list:" + r);
		}
		return roles;
	}

	@Override
	public Role getRoleById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Role r = (Role) session.load(Role.class, new Integer(id));
		logger.info("Role loaded successfully, Role Details=" + r);
		return r;
	}

	@Override
	public void removeRole(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Role r = (Role) session.load(Role.class, new Integer(id));
		if(r != null){
			session.delete(r);
		}
		logger.info("Role deleted successfully, Role Details=" + r);
	}
	
	

}
