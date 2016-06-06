/**
 * Jun 6, 2016, UserWord.java, vuvandat
 */
package framgiavn.project01.web.model;

/**
 * 
 * @author vuvandat
 *
 */
public class UserWord {
	private int id;
	private int userId;
	private String contentWord;
	private String contentResult;
	private String statusLearn;
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
