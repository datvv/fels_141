/**
 * Jun 2, 2016, UserLoginAction.java, datvv
 */
package framgiavn.project01.web.action;

import org.apache.commons.validator.EmailValidator;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;

/**
 * Process data input login from user
 * 
 * @author datvv
 * 
 */
public class UserLoginAction extends ActionSupport {

	private UserBusiness userBusiness = null;
	private User user;
	private String message = "";

	/**
	 * Check exist user in database;
	 * 
	 * @return input: return page input with error input, addminlogin : return
	 *         addmin page, userlogin: return user page, error: return page
	 *         error
	 * 
	 */
	public String checkUserLogin() {

		if (!EmailValidator.getInstance().isValid(user.getEmail())) {
			message = "Email is not valid";
			return INPUT;
		}
		try {
			User userCheck = userBusiness.checkExistUser(user);
			if (userCheck != null) {

				if (userCheck.getIsAdmin()) {
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

}
