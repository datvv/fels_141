/**
 * Jun 28, 2016, WordBusinessImpl.java, vuvandat
 */
package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.WordBusiness;
import framgiavn.project01.web.dao.*;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;
import framgiavn.project01.web.ulti.Logit2;

/**
 * @author vuvandat
 *
 */
public class WordBusinessImpl implements WordBusiness {

	private WordDAO wordDAO;
	private CategoryDAO categoryDAO;
	private WordAnswerDAO wordAnswerDAO;
	private static final Logit2 log = Logit2.getInstance(WordBusinessImpl.class);

	@Override
	public Word getWordByWordId(int wordId) {
		try {
			return getWordDAO().getWordByWordId(wordId);
		} catch (Exception e) {
			log.error("get failed ", e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveWordAndWordAnswer(Word word, List<WordAnswer> listWordAnswer) {
		try {
			this.getWordDAO().saveWordAndWordAnswer(word, listWordAnswer);
		} catch (Exception e) {
			log.error("get failed ", e);
		}
	}

	@Override
	public void saveCreatedWords(String categoryName, Word word, List<WordAnswer> listWordAnswers) {
		try {
			Category category = getCategoryDAO().findCategoryByCategoryName(categoryName);
			word.setCategoryId(category.getId());
			if (getWordDAO().createWord(word)) {
				Word wordCreating = getWordDAO().getWordByWordNameAndCategoryId(word.getContent(), category.getId());
				for (WordAnswer wordAnswer : listWordAnswers) {
					wordAnswer.setWordId(wordCreating.getId());
					getWordAnswerDAO().createWordAnswer(wordAnswer);
				}
			}
		} catch (Exception e) {
			log.error("get failed ", e);
		}
	}

	@Override
	public void deleteWordByWordId(int wordId) {
		try {
			Word word = getWordDAO().getWordByWordId(wordId);
			getWordDAO().deleteWord(word);
		} catch (Exception e) {
			log.error("get failed ", e);
		}
	}

	public WordDAO getWordDAO() {
		return wordDAO;
	}

	public void setWordDAO(WordDAO wordDAO) {
		this.wordDAO = wordDAO;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public WordAnswerDAO getWordAnswerDAO() {
		return wordAnswerDAO;
	}

	public void setWordAnswerDAO(WordAnswerDAO wordAnswerDAO) {
		this.wordAnswerDAO = wordAnswerDAO;
	}

}
