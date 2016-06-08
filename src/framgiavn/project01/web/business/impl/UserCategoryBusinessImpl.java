/**
 * Jun 8, 2016, UserCategoryBusiness.java, datvv
 */
package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.UserCategoryBusiness;
import framgiavn.project01.web.dao.UserCategoryDAO;
import framgiavn.project01.web.model.UserCategory;
import framgiavn.project01.web.model.WordCategory;

/**
 * @author datvv
 *
 */
public class UserCategoryBusinessImpl implements UserCategoryBusiness {
	private UserCategoryDAO userCategoryDAO;

	@Override
	public int getLearnedNumberUser(int userId, String category, int learnedStatus) {
		try {
			return getUserCategoryDAO().getLearnedNumberUser(userId, category, learnedStatus);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public UserCategoryDAO getUserCategoryDAO() {
		return userCategoryDAO;
	}

	public void setUserCategoryDAO(UserCategoryDAO userCategoryDAO) {
		this.userCategoryDAO = userCategoryDAO;
	}

	@Override
	public List<String> getListCategory() {
		try {
			return getUserCategoryDAO().getListCategory();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public String getContentCategory(int userId, String category) {
		try {
			return getUserCategoryDAO().getContentCategory(userId, category);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
