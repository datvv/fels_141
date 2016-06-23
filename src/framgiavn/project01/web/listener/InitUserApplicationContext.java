package framgiavn.project01.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import framgiavn.project01.web.model.User;

public class InitUserApplicationContext implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// User user = new User();
		// user.setId(9);
		// sce.getServletContext().setAttribute("currentUser", user);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
