package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.Activity;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.model.Word;

public interface UserDAO {
	public User findByUserId(Integer user_id) throws Exception;

	public User findByUsername(String username) throws Exception;

	/**
	 * Check exist user in database
	 * 
	 * @param user:
	 *            object need to check in database
	 * @return user if exist, null if not exist
	 */
	public User checkExistUser(User user) throws Exception;

	public User findByEmail(String email) throws Exception;

	public void addNewUser(User user) throws Exception;
	
	public List<Activity> getActivityListByUserId(Integer user_id) throws Exception;
	
	public List<User> getFollowingListByUserId(Integer user_id) throws Exception;
	
	public List<Word> getWordLearnedListByUserId(Integer user_id) throws Exception;
	
}