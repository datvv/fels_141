/**
 * Jun 5, 2016, WordAnswer.java, vuvandat
 */
package framgiavn.project01.web.model;

/**
 * WordAnswer model map to table WordAnswer in database
 * 
 * @author vuvandat
 *
 */
public class WordAnswer {
	private int id;
	private String content;
	private int wordId;
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

	public int getWordId() {
		return wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}
