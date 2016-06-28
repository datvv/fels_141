/**
 * Jun 28, 2016, WordDAOImpl.java, vuvandat
 */
package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project01.web.dao.WordDAO;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

/**
 * @author vuvandat
 *
 */
public class WordDAOImpl extends HibernateDaoSupport implements WordDAO {

	@Override
	public Word getWordByWordId(int wordId) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Word.SelectWordByWordId");
			query.setParameter("wordId", wordId);
			return (Word) query.uniqueResult();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public void saveWordAndWordAnswer(Word word, List<WordAnswer> listWordAnswer) throws Exception {
		try {
			Session session = getSession();
			session.saveOrUpdate(word);
			for (WordAnswer wordAnswer : listWordAnswer) {
				session.saveOrUpdate(wordAnswer);
			}
		} catch (RuntimeException e) {
			throw e;
		}

	}

	@Override
	public boolean createWord(Word word) throws Exception {
		try {
			Session session = getSession();
			session.saveOrUpdate(word);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	@Override
	public Word getWordByWordNameAndCategoryId(String wordName, int CategoryId) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Word.findWordIdByWordContentAndCategoryId");
			query.setParameter("wordContent", wordName);
			query.setParameter("categoryId", CategoryId);
			return (Word) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public void deleteWord(Word word) throws Exception {
		Session session = getSession();
		session.delete(word);
	}

}
