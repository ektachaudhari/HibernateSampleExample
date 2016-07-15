package com.project.hibernate.bdo;

import com.project.application.exception.ApplicationException;

public interface BDO {
	public String create(String jsonString) throws ApplicationException, Exception;

	public String update(String jsonString) throws ApplicationException, Exception;

	public String delete(String jsonString) throws ApplicationException, Exception;

	public String list() throws ApplicationException, Exception;
}
