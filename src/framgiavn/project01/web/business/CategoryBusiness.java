/**
 * Jun 4, 2016, CategoryBusiness.java, vuvandat
 */
package framgiavn.project01.web.business;

import java.util.List;
import framgiavn.project01.web.model.Category;

/**
 * Process logic for getting data categories
 * 
 * @author vuvandat
 *
 */
public interface CategoryBusiness {
	/**
	 * List all categories in database
	 * 
	 * @return list all category
	 * @throws Exception
	 */
	public List<Category> listAllCategory();

	public Category findByCategoryId(int category_id);

	public void saveOrUpdateCategory(Category category);

	public void deleteCategory(Category category);
}
