package com.project.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.project.hibernate.dao.BaseHibernateDAO;
import com.project.hibernate.pojo.Employee;

public class EmployeeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(EmployeeDAO.class);

	public void save(Employee employeeInstance) {
		System.out.println("empdao save");
		log.debug("saving Employee instance");
		try {
			getSession().save(employeeInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Employee employeeInstance) {
		log.debug("deleting Employee instance");
		try {
			getSession().delete(employeeInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public List<Employee> findAll(){
		//System.out.println("findAll");
		log.debug("finding all Employee instances");
		
		try {
			String queryString = "from Employee";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}	
		
	}
	

	/*public static void main(String[] args) {

		Employee employee = new Employee();
		EmployeeDAO employeeDao = new EmployeeDAO();
		
		Session session = employeeDao.getSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			employee.setName("ekta");
			employee.setSurname("c");
			employeeDao.save(employee);			
			//session.save(employee);
			if (!transaction.wasCommitted()) {
				transaction.commit();
			}
		} catch (Exception ex) {
			transaction.rollback();
			System.err.println(ex.getMessage() + " " + ex.getCause().getMessage());
		} finally {
			session.clear();
		}

	}*/

}
