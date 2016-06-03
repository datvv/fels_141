/**
 * Jun 3, 2016, UserLogoutAction.java, vuvandat
 */
package framgiavn.project01.web.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Process handle logout
 * 
 * @author vuvandat
 *
 */
public class UserLogoutAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {

	private SessionMap<String, Object> session;
	protected HttpServletRequest servletRequest;
	protected HttpServletResponse servletResponse;

	/**
	 * Remove session and cookie when user Logout.
	 * 
	 * @return success: returns the login page
	 */
	@Override
	public String execute() throws Exception {
		// remove Session
		session.invalidate();
		// remove Cookie
		for (Cookie ck : servletRequest.getCookies()) {
			if (ck.getName().equalsIgnoreCase("email")) {
				ck.setMaxAge(0);
				servletResponse.addCookie(ck);
			}
			if (ck.getName().equalsIgnoreCase("password")) {
				ck.setMaxAge(0);
				servletResponse.addCookie(ck);
			}
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.session = (SessionMap<String, Object>) sessionMap;
	}

	public SessionMap<String, Object> getSession() {
		return session;
	}

	public void setSession(SessionMap<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

}
