/**
 * Jun 4, 2016, WordListFilterAction.java, vuvandat
 */
package framgiavn.project01.web.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.business.WordCategoryBusiness;
import framgiavn.project01.web.model.*;

/**
 * Show and filter list words by some conditions(elearned, unlearned,category)
 * 
 * @author vuvandat
 *
 */
public class WordListFilterAction extends ActionSupport {

	private static int userId = 0;
	private CategoryBusiness categoryBusiness = null;
	private WordCategoryBusiness wordCategoryBusiness;
	private List<Category> listCategory = null;
	private List<WordCategory> listWordCategory = null;

	/**
	 * Show list all words and categories
	 * 
	 * @return success: return word_list page
	 */
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("currentUser");
		listCategory = categoryBusiness.listAllCategory();
		listWordCategory = wordCategoryBusiness.getListWordCategory();
		return SUCCESS;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public CategoryBusiness getCategoryBusiness() {
		return categoryBusiness;
	}

	public void setCategoryBusiness(CategoryBusiness categoryBusiness) {
		this.categoryBusiness = categoryBusiness;
	}

	public static int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public WordCategoryBusiness getWordCategoryBusiness() {
		return wordCategoryBusiness;
	}

	public void setWordCategoryBusiness(WordCategoryBusiness wordCategoryBusiness) {
		this.wordCategoryBusiness = wordCategoryBusiness;
	}

	public List<WordCategory> getListWordCategory() {
		return listWordCategory;
	}

	public void setListWordCategory(List<WordCategory> listWordCategory) {
		this.listWordCategory = listWordCategory;
	}

}
