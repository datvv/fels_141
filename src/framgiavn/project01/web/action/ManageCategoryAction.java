/**
 * Jun 13, 2016, ManageCategoryAction.java, vuvandat
 */
package framgiavn.project01.web.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.model.Category;

/**
 * @author vuvandat
 *
 */
public class ManageCategoryAction extends ActionSupport {

	private CategoryBusiness categoryBusiness;
	private List<Category> listCategory;
	private Category category;
	private int categoryId;

	public String listCategory() {
		try {
			listCategory = categoryBusiness.listAllCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String updateCategory() {
		try {
			category = categoryBusiness.findByCategoryId(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String updateAndSaveCategory() {
		try {
			Category categoryUpdate = categoryBusiness.findByCategoryId(category.getId());
			if (categoryUpdate != null && category != null) {
				categoryUpdate.setName(category.getName());
				categoryUpdate.setDescription(category.getDescription());
				categoryBusiness.saveOrUpdateCategory(categoryUpdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String addCategory() {
		category = new Category();
		return SUCCESS;
	}

	public String addAndSaveCategory() throws Exception {
		if (category != null && !category.getName().isEmpty()) {
			categoryBusiness.saveOrUpdateCategory(category);
		}
		return SUCCESS;
	}

	public String deleteCategory() throws Exception {
		Category categoryDeleting = categoryBusiness.findByCategoryId(categoryId);
		categoryBusiness.deleteCategory(categoryDeleting);
		return SUCCESS;
	}

	public CategoryBusiness getCategoryBusiness() {
		return categoryBusiness;
	}

	public void setCategoryBusiness(CategoryBusiness categoryBusiness) {
		this.categoryBusiness = categoryBusiness;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
