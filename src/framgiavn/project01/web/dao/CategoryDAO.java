/**
 * Jun 4, 2016, CategoryDao.java, vuvandat
 */
package framgiavn.project01.web.dao;

import java.util.List;
import framgiavn.project01.web.model.Category;

/**
 * Handle table category in database
 * 
 * @author vuvandat
 *
 */
public interface CategoryDAO {

	/**
	 * List all category in database
	 * 
	 * @return list category
	 */
	public List<Category> listAllCategory() throws Exception;

	public Category findByCategoryId(int category_id) throws Exception; 
	
	public void saveOrUpdateCategory(Category category);
	
	public void deleteCategory(Category category) throws Exception;
}
