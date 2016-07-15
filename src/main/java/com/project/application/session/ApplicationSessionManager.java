package com.project.application.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.hibernate.pojo.Employee;

public class ApplicationSessionManager implements Serializable {

	private static Map<String, Employee> sessionMap;

	public static void initialize() {
		if (sessionMap == null) {
			sessionMap = new HashMap<String, Employee>();
		}
	}

	public void put(String token, Employee employee) {
		sessionMap.put(token, employee);
		System.out.println(employee.getName() + " in put " + employee.getSurname());
	}

	public void remove(String token) {
		sessionMap.remove(token);
	}

	public List<Employee> getList() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.addAll(sessionMap.values());
		for (int i = 0; i < employeeList.size(); i++) {
			Employee employee = employeeList.get(i);
			System.out.println(employee.getName() + " " + employee.getSurname());
		}
		return employeeList;
	}

	public static Employee getValue(int key) {
		return sessionMap.get(key);
	}

	public static void destory() {
		if (sessionMap != null) {
			sessionMap.clear();
			sessionMap = null;
		}
	}
}
