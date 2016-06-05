/**
 * Jun 4, 2016, CategogyBusinessImpl.java, vuvandat
 */
package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.dao.CategoryDAO;
import framgiavn.project01.web.model.Category;

/**
 * @author vuvandat
 *
 */
public class CategoryBusinessImpl implements CategoryBusiness {

	private CategoryDAO categoryDAO;

	@Override
	public List<Category> listAllCategory() throws Exception {
		try {
			return getCategoryDAO().listAllCategory();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

}
