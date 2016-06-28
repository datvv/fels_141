/**
 * Jun 28, 2016, WordAnswerDAOImpl.java, vuvandat
 */
package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.WordAnswerDAO;
import framgiavn.project01.web.model.WordAnswer;

/**
 * @author vuvandat
 *
 */
public class WordAnswerDAOImpl extends HibernateDaoSupport implements WordAnswerDAO {

	@Override
	public List<WordAnswer> getListWordAnswerByWordId(int wordId) throws Exception {
		Query query = getSession().getNamedQuery("WordAnswer.SelectWordAnswerByWordId");
		query.setParameter("wordId", wordId);
		return query.list();
	}

	@Override
	public boolean createWordAnswer(WordAnswer wordAnswer) throws Exception {
		try {
			Session session = getSession();
			session.saveOrUpdate(wordAnswer);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

}
