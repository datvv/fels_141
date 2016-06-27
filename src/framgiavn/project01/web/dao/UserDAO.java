package framgiavn.project01.web.dao;

import java.util.List;
import java.util.Map;

import framgiavn.project01.web.model.Activity;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

public interface UserDAO {
	public User findByUserId(Integer user_id) throws Exception;

	public User findByUsername(String username) throws Exception;

	public User checkExistUser(User user) throws Exception;

	public User findByEmail(String email) throws Exception;

	public void addNewUser(User user) throws Exception;

	public List<Activity> getActivityListByUserId(Integer user_id) throws Exception;

	public List<User> getFollowingListByUserId(Integer user_id) throws Exception;

	public List<Word> getWordLearnedListByUserId(Integer user_id) throws Exception;

	public List<Word> findWordLearnedInCategory(int user_id, int category_id) throws Exception;

	public List<Word> findWordNotLearnedInCategory(int user_id, int category_id) throws Exception;

	public Long getAllWordLearned(int user_id) throws Exception;

	public List<WordAnswer> findAnswers(int word_id) throws Exception;

	public int findAnswerByContent(String answer) throws Exception;

	public Boolean getResultByWordAnswerId(int user_id) throws Exception;

	/**
	 * Get list user in database
	 * 
	 * @return list user
	 */
	public List<User> getListUser() throws Exception;

	public void saveOrUpdateUser(User user) throws Exception;

	public void deleteUser(User user) throws Exception;

	public void createCategoryWordAndAnswer(String categoryName, String wordContent, Map<String, Boolean> wordAnswerMap)
			throws Exception;

	public Category findCategoryByName(String categoryName) throws Exception;

	public Word findWordInCategory(String wordContent, String categoryName) throws Exception;
}