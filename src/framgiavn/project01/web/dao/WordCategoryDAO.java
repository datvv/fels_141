/**
 * Jun 5, 2016, WordCategoryDAO.java, vuvandat
 */
package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.*;

/**
 * Handle data in database for show list words
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
	public List<WordCategory> getListWordCategory();

	/**
	 * Get list words by some codidtions (learned, not learned, all)
	 * 
	 * @param category:
	 *            category user chose
	 * @param statusLearn:
	 *            status learning of user
	 * @return list filtered words
	 */
	public List<WordCategory> getListWordCategory(String category, String statusLearn, int userId);
}
