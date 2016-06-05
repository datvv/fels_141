/**
 * Jun 5, 2016, WordCategory.java, vuvandat
 */
package framgiavn.project01.web.model;

/**
 * @author vuvandat
 *
 */
public class WordCategory {
	private int wordCategoryId;
	private String contentWord;
	private String contentResult;
	private String statusLearn;
	private String category;


	public WordCategory(int wordCategoryId, String contentWord, String contentResult, String category) {
		super();
		this.wordCategoryId = wordCategoryId;
		this.contentWord = contentWord;
		this.contentResult = contentResult;
		this.category = category;
	}

	public int getWordCategoryId() {
		return wordCategoryId;
	}

	public void setWordCategoryId(int wordCategoryId) {
		this.wordCategoryId = wordCategoryId;
	}

	public String getContentWord() {
		return contentWord;
	}

	public void setContentWord(String contentWord) {
		this.contentWord = contentWord;
	}

	public String getContentResult() {
		return contentResult;
	}

	public void setContentResult(String contentResult) {
		this.contentResult = contentResult;
	}

	public String getStatusLearn() {
		return statusLearn;
	}

	public void setStatusLearn(String statusLearn) {
		this.statusLearn = statusLearn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
