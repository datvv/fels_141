/**
 * Jun 4, 2016, CategoryDao.java, vuvandat
 */
package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.Category;

/**
 * Handle data table category in database
 * 
 * @author vuvandat
 *
 */
public interface CategoryDAO {

	/**
	 * List all category in database
	 * 
	 * @return list<Category>: list category
	 */
	public List<Category> listAllCategory();
}
