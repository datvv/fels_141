package framgiavn.project01.web.business;

import framgiavn.project01.web.model.Lesson;

public interface LessonBusiness {
	public int getResultById(int lesson_id) throws Exception;

	public void setResultById(int lesson_id, int result) throws Exception;

	public Lesson createLesson(int user_id, int category_id) throws Exception;
}
