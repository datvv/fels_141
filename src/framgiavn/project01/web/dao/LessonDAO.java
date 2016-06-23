package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.Lesson;

public interface LessonDAO {
	public int getResultById(int lesson_id) throws Exception;

	public void setResultById(int lesson_id, int result) throws Exception;

	public Lesson createLesson(int user_id, int category_id) throws Exception;

}
