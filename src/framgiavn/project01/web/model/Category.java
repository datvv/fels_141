/**
 * Jun 4, 2016, Category.java, vuvandat
 */
package framgiavn.project01.web.model;

import java.io.Serializable;

/**
 * Category model mapping to table Category in database
 * @author vuvandat
 *
 */
public class Category implements Serializable {
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
