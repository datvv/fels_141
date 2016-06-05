/**
 * Jun 5, 2016, Word.java, vuvandat
 */
package framgiavn.project01.web.model;

/**
 * Word model
 * @author vuvandat
 *
 */
public class Word {
	private int id;
	private String content;
	private int category_id;

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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

}
