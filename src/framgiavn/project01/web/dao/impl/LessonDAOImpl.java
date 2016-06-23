package framgiavn.project01.web.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.LessonDAO;
import framgiavn.project01.web.model.Lesson;

public class LessonDAOImpl extends HibernateDaoSupport implements LessonDAO {

	protected void initDAO() {

	}

	@Override
	public int getResultById(int lesson_id) throws Exception {
		try {
			Query query = this.getSession().getNamedQuery("Lesson.getResultById");
			query.setParameter("id", lesson_id);
			return (Integer) query.uniqueResult();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public void setResultById(int lesson_id, int result) throws Exception {
		try {
			Query query = this.getSession().getNamedQuery("Lesson.setResultById");
			query.setParameter("lesson_id", lesson_id);
			query.setParameter("newResult", result);
			query.executeUpdate();

		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public Lesson createLesson(int user_id, int category_id) throws Exception {
		try {
			Session session = getSession();
			Lesson lesson = new Lesson();
			lesson.setUserId(user_id);
			lesson.setCategoryId(category_id);
			lesson.setResult(0);
			session.save(lesson);
			return lesson;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
