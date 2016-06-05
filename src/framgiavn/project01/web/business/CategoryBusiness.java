/**
 * Jun 4, 2016, CategoryBusiness.java, vuvandat
 */
package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.Category;

/**
 * Process logic for getting data category
 * @author vuvandat
 *
 */
public interface CategoryBusiness {
	/**
	 * List all category in database
	 * 
	 * @return list<category>: list all category
	 * @throws Exception
	 */
	public List<Category> listAllCategory() throws Exception;
}
