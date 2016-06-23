package framgiavn.project01.web.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	private String password;
	private String email;
	private String avatar;
	private boolean isAdmin;

	List<Activity> activityList;
	List<User> followingList;
	List<Word> wordLearnedList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

	public List<User> getFollowingList() {
		return followingList;
	}

	public void setFollowingList(List<User> followingList) {
		this.followingList = followingList;
	}

	public List<Word> getWordLearnedList() {
		return wordLearnedList;
	}

	public void setWordLearnedList(List<Word> wordLearnedList) {
		this.wordLearnedList = wordLearnedList;
	}

}