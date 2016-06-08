/**
 * Jun 8, 2016, UserCategoryDAO.java, datvv
 */
package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.*;

/**
 * @author datvv
 *
 */
public interface UserCategoryDAO {

	/**
	 * Get total number of lesson and get total number
	 * 
	 * @param userId
	 *            : id of user
	 * @param category:
	 *            category user learned
	 * @param learnedStatus:
	 *            status learned or not learned.
	 * @return total numbers, learned numbers
	 */
	public int getLearnedNumberUser(int userId, String category, int learnedStatus);

	/**
	 * Get list categories of user
	 * 
	 * @return list categies of lesson's user
	 */
	public List<String> getListCategory();

	/**
	 * Get list words follow category
	 * 
	 * @param userId:
	 *            id of user
	 * @param category:
	 *            category of lesson's user
	 * @return content of category
	 */
	public String getContentCategory(int userId, String category);

}
