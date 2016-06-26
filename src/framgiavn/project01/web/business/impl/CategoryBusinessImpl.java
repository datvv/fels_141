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

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public List<Category> listAllCategory() {
		try {
			return getCategoryDAO().listAllCategory();
		} catch (Exception e) {
			log.error("get failed ", e);
		}
		return null;
	}

	@Override
	public Category findByCategoryId(int category_id) {
		try {
			return getCategoryDAO().findByCategoryId(category_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateAndSaveCategory(Category category) {
		try {
			if (category != null && !category.getName().isEmpty()) {
				this.getCategoryDAO().updateAndSaveCategory(category);
			}
		} catch (Exception e) {
			log.error("get failed ", e);
		}

	}

	@Override
	public void deleteCategory(int categoryId) {
		try {
			Category category = getCategoryDAO().findByCategoryId(categoryId);
			if (category != null) {
				this.getCategoryDAO().deleteCategory(category);
			}
		} catch (Exception e) {
			log.error("get failed ", e);
		}

	}

}
