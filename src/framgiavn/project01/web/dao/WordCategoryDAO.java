/**
 * Jun 5, 2016, WordCategoryDAO.java, vuvandat
 */
package framgiavn.project01.web.dao;

import java.util.List;
import framgiavn.project01.web.model.*;

/**
 * Handle data in database for show word list function
 * 
 * @author vuvandat
 *
 */
public interface WordCategoryDAO {

	/**
	 * Get all words follow category in database
	 * 
	 * @return listWord follow category
	 */
	public List<WordCategory> getListWordCategory() throws Exception;

	/**
	 * Get list words by some conditions (learned, not learned, all)
	 * 
	 * @param category:
	 *            category user chose
	 * @param learnedStatus:
	 *            learned status of user
	 * @return list filtered words
	 */
	public List<WordCategory> getListWordByCategory(String category, String learnedStatus, int userId);

}
