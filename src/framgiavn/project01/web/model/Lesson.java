package framgiavn.project01.web.model;

import java.io.Serializable;

public class Lesson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int userId;
	private int categoryId;
	private int result;

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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
