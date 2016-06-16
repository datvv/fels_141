/**
 * Jun 5, 2016, WordCategoryDAOImpl.java, vuvandat
 */
package framgiavn.project01.web.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project01.web.dao.WordCategoryDAO;
import framgiavn.project01.web.model.WordCategory;

/**
 * @author vuvandat
 *
 */
public class WordCategoryDAOImpl extends HibernateDaoSupport implements WordCategoryDAO {

	final boolean CORRECT_ANSWER = true;

	@Override
	public List<WordCategory> getListWordCategory() throws Exception {

		List<WordCategory> listWordCategory = new ArrayList<WordCategory>();
		String hql = "Select word.id as wordCategoryId, word.content as contentWord, wordAnswer.content as contentResult, category.name as category "
				+ "From Word word, WordAnswer wordAnswer, Category category where wordAnswer.wordId = word.id "
				+ "and word.categoryId = category.id and wordAnswer.correct = :correctAnswer ";
		Query query = getSession().createQuery(hql).setParameter("correctAnswer", CORRECT_ANSWER);
		query.setResultTransformer(Transformers.aliasToBean(WordCategory.class));
		listWordCategory = query.list();
		if (listWordCategory != null) {
			return listWordCategory;
		} else {
			return null;
		}
	}

}
