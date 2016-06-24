/**
 * Jun 17, 2016, LessonCategoryBusiness.java, datvv
 */
package framgiavn.project01.web.business;

import java.util.List;

/**
 * @author datvv
 *
 */
public interface LessonCategoryBusiness {
	
	/**
	 * Handle Logic to get total number of lesson and get total number
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
	 * Handle Logic to get list category
	 * 
	 * @return list category
	 */
	public List<String> getListCategory();

	/**
	 * Handle Logic to get list words follow category
	 * 
	 * @param userId:
	 *            id of user
	 * @param category:
	 *            category of lesson's user
	 * @return content of category
	 */
	public String getContentCategory(int userId, String category);

}
