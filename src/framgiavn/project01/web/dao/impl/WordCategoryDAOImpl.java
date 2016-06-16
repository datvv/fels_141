/**
 * Jun 5, 2016, WordCategoryDAOImpl.java, vuvandat
 */
package framgiavn.project01.web.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project01.web.dao.WordCategoryDAO;
import framgiavn.project01.web.model.ElearningConstants;
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

	@Override
	public List<WordCategory> getListWordByCategory(String category, String learnedStatus, int userId) {

		List<WordCategory> listWordCategory = new ArrayList<WordCategory>();
		Query query;
		String hql = "select distinct word.id as wordCategoryId, word.content as contentWord, category.name as category, wordAnswer.content as contentResult from Word word, Category category, WordAnswer wordAnswer "
				+ "where category.id in ( select word.categoryId from Word where word.id in ( select wordAnswer.wordId from WordAnswer "
				+ "where wordAnswer.correct = :correctAnswer and word.id in ( select lessonWord.wordId from LessonWord lessonWord "
				+ "where lessonWord.lessonId in ( select lesson.id from Lesson lesson where lesson.userId = :userId ))))";
		if (learnedStatus.equalsIgnoreCase(ElearningConstants.LEARNED)) {	
			 hql = "select distinct word.id as wordCategoryId, word.content as contentWord, category.name as category, wordAnswer.content as contentResult from Word word, Category category, WordAnswer wordAnswer "
					+ "where category.id in ( select word.categoryId from Word where word.id in ( select wordAnswer.wordId from WordAnswer "
					+ "where wordAnswer.correct = :correctAnswer and word.id in ( select lessonWord.wordId from LessonWord lessonWord "
					+ "where (lessonWord.wordAnswerId is not null and lessonWord.wordAnswerId != 0 ) and lessonWord.lessonId in ( select lesson.id from Lesson lesson where lesson.userId = :userId ))))";	
		}
		if (learnedStatus.equalsIgnoreCase(ElearningConstants.NOT_LEARNED)) {
			hql = "select distinct word.id as wordCategoryId, word.content as contentWord, category.name as category, wordAnswer.content as contentResult from Word word, Category category, WordAnswer wordAnswer "
					+ "where category.id in ( select word.categoryId from Word where word.id in ( select wordAnswer.wordId from WordAnswer "
					+ "where wordAnswer.correct = :correctAnswer and word.id in ( select lessonWord.wordId from LessonWord lessonWord "
					+ "where (lessonWord.wordAnswerId is null or lessonWord.wordAnswerId = 0 ) and lessonWord.lessonId in ( select lesson.id from Lesson lesson where lesson.userId = :userId ))))";
		}
		if (!category.isEmpty() && category != null) {
			hql += " and category.name = :category ";
			query = getSession().createQuery(hql).setParameter("correctAnswer", CORRECT_ANSWER)
					.setParameter("category", category).setParameter("category", category)
					.setParameter("userId", userId);
		} else {
			query = getSession().createQuery(hql).setParameter("correctAnswer", CORRECT_ANSWER).setParameter("userId",
					userId);
		}
		query.setResultTransformer(Transformers.aliasToBean(WordCategory.class));
		listWordCategory = query.list();
		if (listWordCategory != null) {
			return listWordCategory;
		} else {
			return null;
		}
	}

}
