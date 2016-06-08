package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.LessonWordBusiness;
import framgiavn.project01.web.dao.LessonWordDAO;
import framgiavn.project01.web.model.LessonWord;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

public class LessonWordBusinessImpl implements LessonWordBusiness {

	private LessonWordDAO lessonWordDAO;

	public LessonWordDAO getLessonWordDAO() {
		return lessonWordDAO;
	}

	public void setLessonWordDAO(LessonWordDAO lessonWordDAO) {
		this.lessonWordDAO = lessonWordDAO;
	}

	@Override
	public List<LessonWord> findLessonWordByLessonId(int lesson_id) throws Exception {
		try {
			return lessonWordDAO.findLessonWordByLessonId(lesson_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createLessonWord(int lesson_id, Word word, WordAnswer wordAnswer) throws Exception {
		try {
			lessonWordDAO.createLessonWord(lesson_id, word, wordAnswer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
