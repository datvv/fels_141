/**
 * Jun 4, 2016, CategogyBusinessImpl.java, vuvandat
 */
package framgiavn.project01.web.business.impl;

import java.util.List;
import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.dao.CategoryDAO;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.ulti.Logit2;

/**
 * @author vuvandat
 *
 */
public class CategoryBusinessImpl implements CategoryBusiness {

	private CategoryDAO categoryDAO;
	private static final Logit2 log = Logit2.getInstance(CategoryBusinessImpl.class);

	@Override
	public List<Category> listAllCategory() {
		try {
			return getCategoryDAO().listAllCategory();
		} catch (Exception e) {
			log.error("get failed ", e);
		}
		return null;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

}
