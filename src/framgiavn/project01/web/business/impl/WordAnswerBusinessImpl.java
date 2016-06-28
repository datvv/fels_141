/**
 * Jun 28, 2016, WordAnswerBusinessImpl.java, vuvandat
 */
package framgiavn.project01.web.business.impl;

import java.util.List;
import framgiavn.project01.web.business.WordAnswerBusiness;
import framgiavn.project01.web.dao.*;
import framgiavn.project01.web.model.WordAnswer;
import framgiavn.project01.web.ulti.Logit2;

/**
 * @author vuvandat
 *
 */
public class WordAnswerBusinessImpl implements WordAnswerBusiness {

	private WordAnswerDAO wordAnswerDAO;
	private static final Logit2 log = Logit2.getInstance(WordBusinessImpl.class);

	@Override
	public List<WordAnswer> getListWordAnswerByWordId(int wordId) {
		try {
			return getWordAnswerDAO().getListWordAnswerByWordId(wordId);
		} catch (Exception e) {
			 log.error("get failed ", e);
		}
		return null;

	}

	public WordAnswerDAO getWordAnswerDAO() {
		return wordAnswerDAO;
	}

	public void setWordAnswerDAO(WordAnswerDAO wordAnswerDAO) {
		this.wordAnswerDAO = wordAnswerDAO;
	}

}
