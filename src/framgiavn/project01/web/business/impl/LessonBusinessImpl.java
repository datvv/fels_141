package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.LessonBusiness;
import framgiavn.project01.web.dao.LessonDAO;
import framgiavn.project01.web.model.Lesson;

public class LessonBusinessImpl implements LessonBusiness {
	private LessonDAO lessonDAO;

	public LessonDAO getLessonDAO() {
		return lessonDAO;
	}

	public void setLessonDAO(LessonDAO lessonDAO) {
		this.lessonDAO = lessonDAO;
	}

	@Override
	public int getResultById(int lesson_id) throws Exception {
		try {
			return (int) this.getLessonDAO().getResultById(lesson_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void setResultById(int lesson_id, int result) throws Exception {
		try {
			this.getLessonDAO().setResultById(lesson_id, result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Lesson createLesson(int user_id, int category_id) throws Exception {
		try {
			return this.getLessonDAO().createLesson(user_id, category_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
