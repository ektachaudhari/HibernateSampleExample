package com.project.hibernate.pojo;

public class Employee {

	private int employeeIdPk;
	private String name;
	private String surname;

	public Employee() {

	}

	public Employee(String name, String surname) {
		super();
		//this.employeeIdPk = employeeIdPk;
		this.name = name;
		this.surname = surname;
	}

	public int getEmployeeIdPk() {
		return employeeIdPk;
	}

	public void setEmployeeIdPk(int employeeIdPk) {
		this.employeeIdPk = employeeIdPk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeIdPk;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeIdPk != other.employeeIdPk)
			return false;
		return true;
	}

}
