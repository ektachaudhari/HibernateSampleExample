package com.project.hibernate.dao;

import org.hibernate.Session;
import com.project.hibernate.util.HibernateSessionFactory;

public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
		
}