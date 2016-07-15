package com.project.application.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.project.application.session.ApplicationSessionManager;
import com.project.hibernate.dao.EmployeeDAO;;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
public class ApplicationListener implements ServletContextListener {

	public ApplicationListener() {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ApplicationSessionManager.initialize();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		ApplicationSessionManager.destory();
	}

}
