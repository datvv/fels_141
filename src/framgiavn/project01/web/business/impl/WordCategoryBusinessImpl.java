/**
 * Jun 5, 2016, WordCategoryBusinessImpl.java, vuvandat
 */
package framgiavn.project01.web.business.impl;

import java.util.List;
import framgiavn.project01.web.business.WordCategoryBusiness;
import framgiavn.project01.web.dao.WordCategoryDAO;
import framgiavn.project01.web.model.WordCategory;
import framgiavn.project01.web.ulti.Logit2;

/**
 * @author vuvandat
 *
 */
public class WordCategoryBusinessImpl implements WordCategoryBusiness {

	private WordCategoryDAO wordCategoryDAO = null;
	private static final Logit2 log = Logit2.getInstance(WordCategoryBusinessImpl.class);

	@Override
	public List<WordCategory> getListWordCategory() {
		try {
			return getWordCategoryDAO().getListWordCategory();
		} catch (Exception e) {
			log.error("get failed ", e);
			return null;
		}
	}

	@Override
	public List<WordCategory> getListWordByCategory(String category, String learnedStatus, int userId) {
		try {
			return getWordCategoryDAO().getListWordByCategory(category, learnedStatus, userId);
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
