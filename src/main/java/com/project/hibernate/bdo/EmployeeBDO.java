package com.project.hibernate.bdo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.google.gson.Gson;
import com.project.application.exception.ApplicationException;
import com.project.application.session.ApplicationSessionManager;
import com.project.hibernate.dao.EmployeeDAO;
import com.project.hibernate.pojo.Employee;

public class EmployeeBDO {
	private static int empId = 0;
	private Gson gson = new Gson();
	EmployeeDAO employeeDAO = new EmployeeDAO();

	/* create Employee detail */
	public String create(String jsonString) throws ApplicationException, Exception {
		System.out.println("employeeBDO-create");
		Employee employee = gson.fromJson(jsonString, Employee.class);
		Session session = employeeDAO.getSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			new ApplicationSessionManager().put(jsonString, employee);
			session.save(employee);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			System.err.println(ex.getMessage() + " " + ex.getCause().getMessage());
		} finally {
			session.clear();
		}
		System.out.println("employeeBDO-end");
		return gson.toJson(employee, Employee.class);
	}

	/* update Employee detail */
	public String update(String jsonString) throws ApplicationException,Exception {
		
		Employee employee = gson.fromJson(jsonString, Employee.class);
		Session session = employeeDAO.getSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			new ApplicationSessionManager().put(jsonString, employee);
			session.save(employee);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			System.err.println(ex.getMessage() + " " + ex.getCause().getMessage());
		} finally {
			session.clear();
		}		
		return gson.toJson(employee, Employee.class);
	}
	
	/*get all employee list*/
	public String list() throws ApplicationException,Exception{		
		//System.out.println("in bdo-list");
		return gson.toJson(employeeDAO.findAll());
		
	}

}
