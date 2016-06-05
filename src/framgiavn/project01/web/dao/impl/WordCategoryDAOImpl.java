/**
 * Jun 5, 2016, WordCategoryDAOImpl.java, vuvandat
 */
package framgiavn.project01.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.WordCategoryDAO;
import framgiavn.project01.web.model.WordCategory;

/**
 * @author vuvandat
 *
 */
public class WordCategoryDAOImpl extends HibernateDaoSupport implements WordCategoryDAO {

	@Override
	public List<WordCategory> getListWordCategory() {
		List<WordCategory> listWordCategory = new ArrayList<WordCategory>();

		String hql = "Select word.id,word.content,wordAnswer.content, category.name "
				+ "From Word word,WordAnswer wordAnswer,Category category where wordAnswer.word_id = word.id "
				+ "and word.category_id = category.id and wordAnswer.correct = 1";
		Query query = getSession().createQuery(hql);

		List<Object[]> listResult = query.list();

		for (Object[] aRow : listResult) {
			int id = (Integer) aRow[0];
			String contentWord = (String) aRow[1];
			String contentResult = (String) aRow[2];
			String category = (String) aRow[3];

			System.out.println(id + " - " + contentWord + " " + contentResult + " " + category);
			WordCategory wordCategory = new WordCategory(id, contentWord, contentResult, category);
			listWordCategory.add(wordCategory);
		}

		return listWordCategory;
	}

}
