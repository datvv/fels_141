/**
 * Jun 2, 2016, UserLoginAction.java, datvv
 */
package framgiavn.project01.web.action;

import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.EmailValidator;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;

/**
 * Process data input login from user
 * 
 * @author datvv
 * 
 */
public class UserLoginAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {

	private UserBusiness userBusiness = null;
	private User user;
	private String message = "";
	private User userLogin;
	private SessionMap<String, Object> session;
	private boolean cbRemember = false;

	protected HttpServletRequest servletRequest;
	protected HttpServletResponse servletResponse;

	/**
	 * Login required to system use cookie
	 * 
	 * @return input: return the login page, addminlogin : return addmin page,
	 *         userlogin: return user page, error: return page error
	 */
	@Override
	public String execute() throws Exception {
		User userCookie = checkCookieUser();
		if (userCookie == null) {
			return INPUT;
		} else {
			User userCk = userBusiness.checkExistUser(userCookie);
			if (userCk != null && userCk.getIsAdmin()) {
				return "adminlogin";
			} else if (userCk != null && !userCk.getIsAdmin()) {
				return "userlogin";
			} else {
				return ERROR;
			}
		}
	}

	/**
	 * Check exist user in database;
	 * 
	 * @return input: return the login page with input errors, addminlogin :
	 *         return addmin page, userlogin: return user page, error: return
	 *         page error
	 * 
	 */
	public String checkUserLogin() {

		if (!EmailValidator.getInstance().isValid(user.getEmail())) {
			message = "Email is not valid";
			return INPUT;
		}
		try {
			userLogin = userBusiness.checkExistUser(user);
			if (userLogin != null) {
				// create session
				session.put("email", userLogin.getEmail());
				// check tick remember me
				if (this.cbRemember) {
					// set cookie for email
					Cookie ckEmail = new Cookie("email", userLogin.getEmail());
					ckEmail.setMaxAge(3600);
					servletResponse.addCookie(ckEmail);
					// set cookie for password
					Cookie ckPassword = new Cookie("password", userLogin.getPassword());
					ckPassword.setMaxAge(3600);
					servletResponse.addCookie(ckPassword);
				}
				if (userLogin.getIsAdmin()) {
					return "adminlogin";
				} else {
					return "userlogin";
				}
			} else {
				message = "Wrong email or password";
				return INPUT;
			}
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			return ERROR;
		}

	}

	/**
	 * Check the existence of cookie
	 * 
	 * @return user: cookie user , null:not existence of cookie user
	 */

	public User checkCookieUser() {
		User user = null;
		String email = "";
		String password = "";
		for (Cookie ck : servletRequest.getCookies()) {
			if (ck.getName().equalsIgnoreCase("email")) {
				email = ck.getValue();
			}
			if (ck.getName().equalsIgnoreCase("password")) {
				password = ck.getValue();
			}
		}
		if (!email.isEmpty() && !password.isEmpty()) {
			user = new User();
			user.setEmail(email);
			user.setPassword(password);

		}
		return user;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		session = (SessionMap<String, Object>) map;
	}

	public SessionMap<String, Object> getSession() {
		return session;
	}

	public void setSession(SessionMap<String, Object> session) {
		this.session = session;
	}

	public boolean isCbRemember() {
		return cbRemember;
	}

	public void setCbRemember(boolean cbRemember) {
		this.cbRemember = cbRemember;
	}

	@Override
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public User getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(User userLogin) {
		this.userLogin = userLogin;
	}

}