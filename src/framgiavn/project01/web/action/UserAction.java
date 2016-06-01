package framgiavn.project01.web.action;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.AvatarUtils;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Logit2 log = Logit2.getInstance(UserAction.class);

	private UserBusiness userBusiness = null;
	private User user = null;
	private String passwordConfirm;

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String findByUserId() {
		try {
			user = userBusiness.findByUserId(user.getUser_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String findByUsername() {
		try {
			user = userBusiness.findByUsername(user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String homePage() {
		System.out
				.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		return SUCCESS;
	}
		
	public String signUp(){		
		try {
			user.setAvatar(AvatarUtils.getAvatarURL(user.getEmail()));
			userBusiness.addNewUser(user);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}


	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public void validate(){
		if(user != null){
			if(user.getEmail() == null || user.getEmail().trim().equals("")){
				addFieldError("user.email", "Email is required");
			}
			else{
				User oldUser = null;
				try {
					oldUser = userBusiness.findByEmail(user.getEmail());
				} catch (Exception e){
					e.printStackTrace();
				}
				if(oldUser != null){
					addFieldError("user.email", "This email was used, try another one.");
				}
			}
			if(user.getUsername() == null || user.getUsername().trim().equals("")){
				addFieldError("user.username", "Username is required");
			}
			else if(user.getUsername().length() > 20 || user.getUsername().length() < 5){
				addFieldError("user.username", "Length of Username is from 5 to 20");
			}
			if(user.getPassword() == null || user.getPassword().trim().equals("")){
				addFieldError("user.password", "Password can not be empty");
			}
			else if(user.getPassword().length() > 16 || user.getPassword().length() < 5){
				addFieldError("user.password", "Length of Password is from 5 to 16");
			}
			else if(!user.getPassword().equals(this.passwordConfirm)){
				addFieldError("passwordConfirm", "Password is not matched");
			}
		}
	}
}