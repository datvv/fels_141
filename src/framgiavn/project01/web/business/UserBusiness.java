package framgiavn.project01.web.business;

import java.util.List;
import java.util.Map;

import framgiavn.project01.web.model.Activity;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;
import framgiavn.project01.web.ulti.WordAnswerObjectCSV;

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

	public List<User> getListUser();

	public void saveOrUpdateUser(User user);

	public void deleteUser(User user);

	public void createCategoryWordAndAnswer(String categoryName, String wordContent, Map<String, Boolean> wordAnswerMap)
			throws Exception;

	public void createWordAnswerByCSV(List<WordAnswerObjectCSV> wordAndAnswerList) throws Exception;

	public Category findCategoryByName(String categoryName) throws Exception;

	public Word findWordInCategory(String wordContent, String categoryName) throws Exception;
	
	public User findUserByUserName(String userName);

}