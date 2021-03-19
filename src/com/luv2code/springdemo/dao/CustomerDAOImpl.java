package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//injecting the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int verifyCustomer(String email, String password) {

		// get current hibernate session
		int res = -1;
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			String hql = "from Customer where email=:email and password=:password";
			Query theQuery = currentSession.createQuery(hql,Customer.class);
			theQuery.setParameter("email", email);
			theQuery.setParameter("password", password);
			Customer theCustomer = (Customer) theQuery.getSingleResult();
			if(theCustomer==null)
				res = -1;
			else
				res = 1;
		}catch(NoResultException e) {
			
		}
		
		return res;
		
	}

	

}
