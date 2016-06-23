package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.model.Activity;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;
import framgiavn.project01.web.ulti.Logit2;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	// private static final Logit2 log = Logit2.getInstance(UserDAOImpl.class);
	public static final String NAME = "customerName";

	protected void initDAO() {
		// Do nothing
	}

	@Override
	public User findByUserId(Integer user_id) throws Exception {
		return findByUserId(user_id, false);
	}

	public User findByUserId(Integer user_id, boolean lock) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.SelectUserByUserId");
			if (lock)
				query.setLockMode("User", LockMode.UPGRADE);
			query.setParameter("user_id", user_id);
			return (User) query.uniqueResult();
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public User findByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User checkExistUser(User user) throws Exception {
		Query query = getSession().getNamedQuery("User.SearchUserByUser");
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		if (query.uniqueResult() != null) {
			return (User) query.uniqueResult();
		} else {
			return null;
		}
	}

	@Override
	public User findByEmail(String email) throws Exception {
		return findByEmail(email, false);
	}

	public User findByEmail(String email, boolean lock) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.SelectUserByEmail");
			if (lock)
				query.setLockMode("User", LockMode.UPGRADE);
			query.setParameter("email", email);
			return (User) query.uniqueResult();
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void addNewUser(User user) throws Exception {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	@Override
	public List<Word> findWordLearnedInCategory(int user_id, int category_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.FindWordLearnedInCategory");
			query.setParameter("user_id", user_id);
			query.setParameter("category_id", category_id);
			return query.list();
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Word> findWordNotLearnedInCategory(int user_id, int category_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.FindWordNotLearnedInCategory");
			query.setParameter("user_id", user_id);
			query.setParameter("category_id", category_id);
			return query.list();
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Long getAllWordLearned(int user_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.FindWordLearned");
			query.setParameter("user_id", user_id);
			return (Long) query.uniqueResult();
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Activity> getActivityListByUserId(Integer user_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.GetActivityListByUserId");
			query.setParameter("user_id", user_id);
			return query.list();
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<User> getFollowingListByUserId(Integer user_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.GetFollowingListByUserId");
			query.setParameter("user_id", user_id);
			return query.list();
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Word> getWordLearnedListByUserId(Integer user_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.GetWordLearnedListByUserId");
			query.setParameter("user_id", user_id);
			return query.list();
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	public List<WordAnswer> findAnswers(int word_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.FindAnswers");
			query.setParameter("word_id", word_id);
			return query.list();
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public int findAnswerByContent(String answer) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.SelectWordAnswer");
			query.setParameter("wordAnswer_content", answer);
			return (int) query.uniqueResult();
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Boolean getResultByWordAnswerId(int user_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.getResultByWordAnswerId");
			query.setParameter("user_id", user_id);
			return (Boolean)query.uniqueResult();
		} catch (RuntimeException re) {
			// log.error("get failed",re);
			throw re;
		}
	}
}