package framgiavn.project01.web.action;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.*;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nguyenanhvan
 *
 */
public class HomeScreenAction extends ActionSupport {

	private User user = null;
	private UserBusiness userBusiness = null;

	public String homePage() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = (User) session.get("currentUser");
		try {
			userBusiness.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String goToWordList() {
		return SUCCESS;
	}

	public String goToCategories() {
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

}
