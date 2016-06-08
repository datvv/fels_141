package framgiavn.project01.web.model;

import java.io.Serializable;

public class LessonWord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int lessonId;
	private int wordId;
	private int wordAnswerId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public int getWordId() {
		return wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
	}

	public int getWordAnswerId() {
		return wordAnswerId;
	}

	public void setWordAnswerId(int wordAnswerId) {
		this.wordAnswerId = wordAnswerId;
	}

}
