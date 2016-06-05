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
	 * Process login show list all words to word list screen.
	 * @return list word
	 */
	public List<WordCategory> getListWordCategory();
}
