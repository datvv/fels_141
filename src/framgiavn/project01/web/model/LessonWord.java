/**
 * Jun 6, 2016, LessonWord.java, vuvandat
 */
package framgiavn.project01.web.model;

/**
 * Model mapping table LessonWord in database
 * 
 * @author vuvandat
 *
 */
public class LessonWord {
	private int id;
	private int lesson_id;
	private int word_id;
	private int word_answer_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLesson_id() {
		return lesson_id;
	}

	public void setLesson_id(int lesson_id) {
		this.lesson_id = lesson_id;
	}

	public int getWord_id() {
		return word_id;
	}

	public void setWord_id(int word_id) {
		this.word_id = word_id;
	}

	public int getWord_answer_id() {
		return word_answer_id;
	}

	public void setWord_answer_id(int word_answer_id) {
		this.word_answer_id = word_answer_id;
	}

}
