/**
 * Jun 4, 2016, Category.java, vuvandat
 */
package framgiavn.project01.web.model;

/**
 * Category model map to table category in database
 * 
 * @author vuvandat
 *
 */
public class Category {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
