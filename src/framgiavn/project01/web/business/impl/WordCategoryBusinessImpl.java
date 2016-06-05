/**
 * Jun 5, 2016, WordCategoryBusinessImpl.java, vuvandat
 */
package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.WordCategoryBusiness;
import framgiavn.project01.web.dao.WordCategoryDAO;
import framgiavn.project01.web.model.WordCategory;

/**
 * @author vuvandat
 *
 */
public class WordCategoryBusinessImpl implements WordCategoryBusiness {
	private WordCategoryDAO wordCategoryDAO = null;

	@Override
	public List<WordCategory> getListWordCategory() {
		try {
			return getWordCategoryDAO().getListWordCategory();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public WordCategoryDAO getWordCategoryDAO() {
		return wordCategoryDAO;
	}

	public void setWordCategoryDAO(WordCategoryDAO wordCategoryDAO) {
		this.wordCategoryDAO = wordCategoryDAO;
	}

}
