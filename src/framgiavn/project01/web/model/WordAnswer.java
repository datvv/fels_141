/**
 * Jun 5, 2016, WordAnswer.java, vuvandat
 */
package framgiavn.project01.web.model;

/**
 * WordAnswer model
 * @author vuvandat
 *
 */
public class WordAnswer {
	private int id;
	private String content;
	private int word_id;
	private boolean correct;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getWord_id() {
		return word_id;
	}

	public void setWord_id(int word_id) {
		this.word_id = word_id;
	}

	public boolean getCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}
