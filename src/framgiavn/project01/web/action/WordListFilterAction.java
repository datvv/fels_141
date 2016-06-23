/**
 * Jun 4, 2016, WordListFilterAction.java, vuvandat
 */
package framgiavn.project01.web.action;

import java.util.ArrayList;
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

	private CategoryBusiness categoryBusiness = null;
	private WordCategoryBusiness wordCategoryBusiness;
	private List<Category> listCategory = null;
	private List<WordCategory> listWordCategory = null;
	private String learnedStatus = "";
	private String selectedCategory = "";
	private List<String> listLearnedStatus;

	/**
	 * Show category and word list by conditions (learned, notlearned,all)
	 * 
	 * @return success: return sorted list words
	 */
	public String filterWordList() throws Exception {

		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("currentUser");
		listLearnedStatus = new ArrayList<String>();
		listLearnedStatus.add(ElearningConstants.LEARNED);
		listLearnedStatus.add(ElearningConstants.NOT_LEARNED);
		listLearnedStatus.add(ElearningConstants.ALL);
		listCategory = categoryBusiness.listAllCategory();
		listWordCategory = wordCategoryBusiness.getListWordByCategory(selectedCategory, learnedStatus, user.getId());
		return SUCCESS;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public void setCategoryBusiness(CategoryBusiness categoryBusiness) {
		this.categoryBusiness = categoryBusiness;
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

	public String getLearnedStatus() {
		return learnedStatus;
	}

	public void setLearnedStatus(String learnedStatus) {
		this.learnedStatus = learnedStatus;
	}

	public String getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public List<String> getListLearnedStatus() {
		return listLearnedStatus;
	}

	public void setListLearnedStatus(List<String> listLearnedStatus) {
		this.listLearnedStatus = listLearnedStatus;
	}

}
