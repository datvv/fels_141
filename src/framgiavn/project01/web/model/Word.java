/**
 * Jun 5, 2016, Word.java, vuvandat
 */
package framgiavn.project01.web.model;

/**
 * Word model map to table word in database
 * 
 * @author vuvandat
 *
 */

import java.io.Serializable;

public class Word implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String content;
	private int categoryId;

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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int category_id) {
		this.categoryId = category_id;
	}

}
