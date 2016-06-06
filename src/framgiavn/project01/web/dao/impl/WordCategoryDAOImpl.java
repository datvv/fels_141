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
 * 
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

	@Override
	public List<WordCategory> getListWordCategory(String category, String learnedStatus, int userId) {
		List<WordCategory> listWordCategory = new ArrayList<WordCategory>();
		Query query;

		String hql2 = "Select word.id,word.content,wordAnswer.content,category.name From User user,Word word,WordAnswer wordAnswer,"
				+ "Category category,LessonWord lessonWord,Lesson lesson where user.user_id = lesson.user_id and lesson.id = lessonWord.lesson_id "
				+ "and lessonWord.word_id = word.id and word.id = wordAnswer.word_id and wordAnswer.correct = 1 and word.category_id = category.id and user.user_id = '"
				+ userId + "' ";

		if (!category.isEmpty() && category != null) {
			hql2 += " and category.name = '" + category + "' ";
		}

		if (learnedStatus.equalsIgnoreCase("learned")) {
			hql2 += " and lesson.result = 1 ";
		}
		if (learnedStatus.equalsIgnoreCase("notlearned")) {
			hql2 += " and lesson.result = 0 ";
		}

		query = getSession().createQuery(hql2);

		List<Object[]> listResult = query.list();

		for (Object[] aRow : listResult) {
			int id = (Integer) aRow[0];
			String contentWord = (String) aRow[1];
			String contentResult = (String) aRow[2];
			String strcategory = (String) aRow[3];

			System.out.println(id + " - " + contentWord + " " + contentResult + " " + category);
			WordCategory wordCategory = new WordCategory(id, contentWord, contentResult, strcategory);
			listWordCategory.add(wordCategory);
		}

		return listWordCategory;
	}

}
