package framgiavn.project01.web.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Logit2;
import framgiavn.project01.web.model.Activity;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

public class UserBusinessImpl implements UserBusiness {

	private UserDAO userDAO;
	private static final Logit2 log = Logit2.getInstance(UserBusinessImpl.class);

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findByUserId(Integer user_id) throws Exception {
		try {
			return getUserDAO().findByUserId(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByUsername(String username) throws Exception {
		try {
			return getUserDAO().findByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User checkExistUser(User user) {
		try {
			return getUserDAO().checkExistUser(user);
		} catch (Exception e) {
			log.error("get failed ", e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByEmail(String email) throws Exception {
		try {
			return getUserDAO().findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNewUser(User user) throws Exception {
		try {
			getUserDAO().addNewUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Activity> getActivityListByUserId(Integer user_id) throws Exception {
		try {
			return getUserDAO().getActivityListByUserId(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getFollowingListByUserId(Integer user_id) throws Exception {
		try {
			return getUserDAO().getFollowingListByUserId(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Word> getWordLearnedListByUserId(Integer user_id) throws Exception {
		try {
			return getUserDAO().getWordLearnedListByUserId(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setActivityListForFollowingByUserId(Integer user_id) throws Exception {
		List<User> followingList = getFollowingListByUserId(user_id);
		for (User u : followingList) {
			u.setActivityList(this.getActivityListByUserId(u.getId()));
		}
	}

	@Override
	public Map<String, List<? extends Object>> getAllInfoByUserId(Integer user_id) throws Exception {
		Map<String, List<? extends Object>> result = null;
		try {
			result = new HashMap<String, List<? extends Object>>();
			result.put("ActivityList", this.getActivityListByUserId(user_id));
			result.put("FollowingList", this.getFollowingListByUserId(user_id));
			result.put("WordList", this.getWordLearnedListByUserId(user_id));
			this.setActivityListForFollowingByUserId(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void updateUser(User user) throws Exception {
		try {
			int id = user.getId();
			user.setActivityList(this.getActivityListByUserId(id));
			user.setFollowingList(this.getFollowingListByUserId(id));
			user.setWordLearnedList(this.getWordLearnedListByUserId(id));
			this.setActivityListForFollowingByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Word> findWordLearnedInCategory(int user_id, int category_id) throws Exception {
		try {
			return getUserDAO().findWordLearnedInCategory(user_id, category_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Word> findWordNotLearnedInCategory(int user_id, int category_id) throws Exception {
		try {
			return getUserDAO().findWordNotLearnedInCategory(user_id, category_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getAllWordLearned(int user_id) throws Exception {
		try {
			return getUserDAO().getAllWordLearned(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<WordAnswer> findAnswers(int word_id) throws Exception {
		try {
			return getUserDAO().findAnswers(word_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<Word, List<WordAnswer>> getAllQuestion(int user_id, int category_id) throws Exception {
		Map<Word, List<WordAnswer>> result = new HashMap<Word, List<WordAnswer>>();
		try {
			List<Word> wordNotLearnedList = this.findWordNotLearnedInCategory(user_id, category_id);
			for (Word word : wordNotLearnedList) {
				List<WordAnswer> answerList = this.findAnswers(word.getId());
				result.put(word, answerList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int findAnswerByContent(String answer) throws Exception {
		try {
			return getUserDAO().findAnswerByContent(answer);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public Boolean getResultByWordAnswerId(int user_id) throws Exception {
		try {
			return getUserDAO().getResultByWordAnswerId(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getListUser() {
		try {
			return getUserDAO().getListUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveOrUpdateUser(User user) {
		try {
			this.getUserDAO().saveOrUpdateUser(user);
		} catch (Exception e) {
			log.error("get failed :", e);
		}
	}

	@Override
	public void deleteUser(User user) {
		try {
			this.getUserDAO().deleteUser(user);
		} catch (Exception e) {
			log.error("get failed :", e);
		}
	}

}