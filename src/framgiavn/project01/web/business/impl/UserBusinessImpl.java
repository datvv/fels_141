package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.dao.impl.UserDAOImpl;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Logit2;

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
			throw e;
		}
	}

	@Override
	public User findByUsername(String username) throws Exception {
		try {
			return getUserDAO().findByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User checkExistUser(User user) {
		try {
			return getUserDAO().checkExistUser(user);
		} catch (Exception e) {
			log.error("get failed ", e);
		}
		return null;
	}

	@Override
	public User findByEmail(String email) throws Exception {
		try {
			return getUserDAO().findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void addNewUser(User user) throws Exception {
		try {
			getUserDAO().addNewUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}