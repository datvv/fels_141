/**
 * Jun 2, 2016, UserLoginAction.java, datvv
 */
package framgiavn.project01.web.action;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Logit2;

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
	private User userCheck;
	private Logit2 log = Logit2.getInstance(UserLoginAction.class);

	/**
	 * Check exist user in database;
	 * 
	 * @return success: return to userLoginSuccess page, error: return to login
	 * 
	 */
	public String checkUserLogin() {
		try {
			validateDataInput();
			userCheck = userBusiness.checkExistUser(user);
			if (userCheck != null) {
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("currentUser", userCheck);
				return SUCCESS;
			} else {
				message = "Wrong email or password";
				return ERROR;
			}
		} catch (Exception e) {
			log.error("get failed ", e);
			return ERROR;
		}
	}

	public void validateDataInput() {
		if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
			addFieldError("user.email", "Email can not empty");
		}
		if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			addFieldError("user.password", "Password can not empty");
		}
	}

	/**
	 * Logout user, remove session
	 * 
	 * @return success: return to login page
	 */
	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("currentUser");
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

	public User getUserCheck() {
		return userCheck;
	}

	public void setUserCheck(User userCheck) {
		this.userCheck = userCheck;
	}

}
