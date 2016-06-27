package framgiavn.project01.web.business;

import java.util.List;
import java.util.Map;

import framgiavn.project01.web.model.Activity;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

public interface UserBusiness {
	public User findByUserId(Integer user_id) throws Exception;

	public User findByUsername(String username) throws Exception;

	public User checkExistUser(User user) throws Exception;

	public User findByEmail(String email) throws Exception;

	public void addNewUser(User user) throws Exception;

	public List<Activity> getActivityListByUserId(Integer user_id) throws Exception;

	public List<User> getFollowingListByUserId(Integer user_id) throws Exception;

	public List<Word> getWordLearnedListByUserId(Integer user_id) throws Exception;

	public void setActivityListForFollowingByUserId(Integer user_id) throws Exception;

	public Map<String, List<? extends Object>> getAllInfoByUserId(Integer user_id) throws Exception;

	public void updateUser(User user) throws Exception;

	public List<Word> findWordLearnedInCategory(int user_id, int category_id) throws Exception;

	public List<Word> findWordNotLearnedInCategory(int user_id, int category_id) throws Exception;

	public Long getAllWordLearned(int user_id) throws Exception;

	public List<WordAnswer> findAnswers(int word_id) throws Exception;

	public Map<Word, List<WordAnswer>> getAllQuestion(int user_id, int category_id) throws Exception;

	public int findAnswerByContent(String answer) throws Exception;

	public Boolean getResultByWordAnswerId(int user_id) throws Exception;

	/**
	 * Get list user
	 * 
	 * @return list user
	 */
	public List<User> getListUser();

	public void saveOrUpdateUser(User user);

	public void deleteUser(User user);

}