/**
 * Jun 6, 2016, LessonWord.java, vuvandat
 */
package framgiavn.project01.web.model;

/**
 * Model mapping to table Lessong in database
 * 
 * @author vuvandat
 *
 */
public class Lesson {
	private int id;
	private int user_id;
	private int category_id;
	private boolean result;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
