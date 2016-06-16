package framgiavn.project01.web.business;

import framgiavn.project01.web.model.User;

public interface UserBusiness {
	public User findByUserId(Integer user_id) throws Exception;

	public User findByUsername(String username) throws Exception;

	/**
	 * Check exist user in database
	 * 
	 * @param user:
	 *            object need to check in database
	 * @return user if exist, null if not exist
	 */
	public User checkExistUser(User user);
	
	public User findByEmail(String email) throws Exception;
		
	public void addNewUser(User user) throws Exception;
}