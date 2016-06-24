/**
 * Jun 17, 2016, LessonCategoryDAOImpl.java, datvv
 */
package framgiavn.project01.web.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project01.web.dao.LessonCategoryDAO;
import framgiavn.project01.web.model.ElearningConstants;

/**
 * @author datvv
 *
 */
public class LessonCategoryDAOImpl extends HibernateDaoSupport implements LessonCategoryDAO {

	@Override
	public int getLearnedNumberUser(int userId, String category, String learnedStatus) {

		int number = 0;
		String hql = "Select Count(lessonWord.id) From LessonWord lessonWord Where lessonWord.lessonId in "
				+ "(Select lesson.id From Lesson lesson Where lesson.userId = :userId And lesson.categoryId in "
				+ "(Select category.id From Category category Where category.name = :category ))";
		if (learnedStatus.equals(ElearningConstants.LEARNED)) {
			hql += "and (lessonWord.wordAnswerId IS NOT NULL AND lessonWord.wordAnswerId != 0) ";
		}
		Query query = getSession().createQuery(hql).setParameter("userId", userId).setParameter("category", category);
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
		String hql = "Select word.content From Word word Where word.id in "
				+ "(Select lessonWord.wordId From LessonWord lessonWord Where lessonWord.lessonId in "
				+ "(Select lesson.id From Lesson lesson Where lesson.userId = :userId and lesson.categoryId in "
				+ "(Select category.id From Category category Where category.name = :category ) ))";
		Query query = getSession().createQuery(hql).setParameter("userId", userId).setParameter("category", category)
				.setMaxResults(20);
		List<String> listResult = query.list();
		for (String word : listResult) {
			contentCategory += (String) word + ", ";
		}
		if (!contentCategory.isEmpty()) {
			contentCategory = contentCategory.substring(0, contentCategory.length() - 2);
		}
		return contentCategory;
	}

}
