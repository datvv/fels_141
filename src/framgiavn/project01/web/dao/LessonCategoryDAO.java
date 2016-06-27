/**
 * Jun 17, 2016, LessonCategoryDAO.java, datvv
 */
package framgiavn.project01.web.dao;

import java.util.List;

/**
 * @author datvv
 *
 */
public interface LessonCategoryDAO {

	/**
	 * Get total learned word of the lesson/get total words of the lesson
	 * 
	 * @param userId
	 *            : id of user
	 * @param category:
	 *            category user learned
	 * @param learnedStatus:
	 *            status learned or not learned.
	 * @return total numbers, learned numbers
	 */
	public int getLearnedNumberUser(int userId, String category, String learnedStatus);

	/**
	 * Get list categories of user
	 * 
	 * @return list category
	 */
	public List<String> getListCategory();

	/**
	 * Get list words follow category
	 * 
	 * @param userId:
	 *            id of user
	 * @param category:
	 *            category of lesson's user
	 * @return content of a category
	 */
	public String getContentCategory(int userId, String category);

}
