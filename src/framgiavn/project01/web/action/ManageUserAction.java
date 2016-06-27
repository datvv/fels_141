/**
 * Jun 9, 2016, ManageUserAction.java, vuvandat
 */
package framgiavn.project01.web.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.*;

/**
 * Manage user in system
 * 
 * @author vuvandat
 *
 */
public class ManageUserAction extends ActionSupport {

	private UserBusiness userBusiness;
	private List<User> listUser;
	private int userId;
	private User userUpdate;

	/**
	 * show list user in system
	 * 
	 * @return success: display list user to manage
	 */
	public String showListUser() {
		listUser = userBusiness.getListUser();
		return SUCCESS;
	}

	public String adminPage() {
		return SUCCESS;
	}

	public String deleteUser() {
		try {
			userUpdate = userBusiness.findByUserId(userId);
			if (userUpdate != null) {
				userBusiness.deleteUser(userUpdate);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String updateUser() {
		try {
			userUpdate = userBusiness.findByUserId(userId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String updateAndSaveUser() {
		try {
			User user = userBusiness.findByUserId(userUpdate.getId());
			if (user != null && userUpdate != null) {
				user.setUsername(userUpdate.getUsername());
				user.setEmail(userUpdate.getEmail());
				user.setAvatar(userUpdate.getAvatar());
				user.setIsAdmin(userUpdate.getIsAdmin());
				userBusiness.saveOrUpdateUser(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(User userUpdate) {
		this.userUpdate = userUpdate;
	}

}
