/**
 * Jun 8, 2016, UserCategoryDAOImpl.java, datvv
 */
package framgiavn.project01.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.UserCategoryDAO;
import framgiavn.project01.web.model.UserCategory;
import framgiavn.project01.web.model.WordCategory;

/**
 * @author datvv
 *
 */
public class UserCategoryDAOImpl extends HibernateDaoSupport implements UserCategoryDAO {

	@Override
	public int getLearnedNumberUser(int userId, String category, int learnedStatus) {
		int number = 0;
		String hql = "select count(word.id) from User user, Lesson lesson,LessonWord lessonWord,Word word, Category category where user.user_id = lesson.user_id "
				+ "and lesson.id = lessonWord.lesson_id and lessonWord.word_id = word.id and word.category_id = category.id and user.user_id = '"
				+ userId + "' and category.name = '" + category + "' ";

		if (learnedStatus == 1) {
			hql += " and lesson.result = '" + learnedStatus + "' ";
		}
		hql += "group by(category.name)";

		Query query = getSession().createQuery(hql);
		if (query.uniqueResult() != null) {
			number = (int) (long) query.uniqueResult();
		}

		return number;
	}

	@Override
	public List<String> getListCategory() {
		String hql = "Select category.name from Category category ";
		Query query = getSession().createQuery(hql);
		List<String> listCategory = (List<String>) query.list();
		return listCategory;
	}

	@Override
	public String getContentCategory(int userId, String category) {
		String contentCategory = "";

		String hql = "Select word.content From User user, Word word,Lesson lesson, LessonWord lessonWord,Category category where user.user_id = lesson.user_id and lessonWord.lesson_id = lesson.id and lessonWord.word_id = word.id and word.category_id = category.id and user.user_id = '"
				+ userId + "' and category.name = '" + category + "' ";
		Query query = getSession().createQuery(hql);
		List<String> listResult = query.list();

		for (String aRow : listResult) {
			contentCategory += (String) aRow + " ";
		}

		return contentCategory;
	}

}
