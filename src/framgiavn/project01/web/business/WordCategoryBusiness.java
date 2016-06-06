/**
 * Jun 5, 2016, WordCategoryBusiness.java, vuvandat
 */
package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.WordCategory;

/**
 * Process logic for showing list words
 * 
 * @author vuvandat
 *
 */
public interface WordCategoryBusiness {

	/**
	 * Process logic show list all words to word list screen.
	 * 
	 * @return list word
	 */
	public List<WordCategory> getListWordCategory();

	/**
	 * Process logic to filter list words by some conditions
	 * 
	 * @param category : category user select fileter
	 * @param learnedStatus : status learned or notlearned
	 * @param userId : id of user
	 * @return list filtered words
	 */
	public List<WordCategory> getListWordCategory(String category, String learnedStatus, int userId);
}
