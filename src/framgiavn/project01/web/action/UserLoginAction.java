/**
 * Jun 2, 2016, UserLoginAction.java, datvv
 */
package framgiavn.project01.web.action;

import java.util.Date;
import java.util.Map;
import org.apache.commons.validator.EmailValidator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;

/**
 * Process user login/logout
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
	 * @return success: return to userLoginSuccess page 
	 * 			error: return to login page
	 * 
	 */
	public String checkUserLogin() {

		if (!EmailValidator.getInstance().isValid(user.getEmail())) {
			message = "Email is not valid";
			return ERROR;
		}
		try {
			User userCheck = userBusiness.checkExistUser(user);
			if (userCheck != null) {
				Map session = ActionContext.getContext().getSession();
				session.put("logined", "true");
				return SUCCESS;
			} else {
				message = "Wrong email or password";
				return ERROR;
			}
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			return ERROR;
		}
	}
	
	/**
	 * Logout user, remove session
	 * @return success: return to login page
	 */

	public String logout() {
		Map session = ActionContext.getContext().getSession();
		session.remove("logined");
		return SUCCESS;
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
