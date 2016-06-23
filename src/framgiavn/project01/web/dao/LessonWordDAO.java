package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.LessonWord;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

public interface LessonWordDAO {
	public List<LessonWord> findLessonWordByLessonId(int lesson_id) throws Exception;

	public void createLessonWord(int lesson_id, Word word, WordAnswer wordAnswer) throws Exception;

}
