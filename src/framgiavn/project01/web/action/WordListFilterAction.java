/**
 * Jun 4, 2016, WordListFilterAction.java, vuvandat
 */
package framgiavn.project01.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.business.WordCategoryBusiness;
import framgiavn.project01.web.model.*;

/**
 * Show and filter word list by some conditions(elearned, notlearned,category)
 * 
 * @author vuvandat
 *
 */
public class WordListFilterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private CategoryBusiness categoryBusiness = null;
	private List<Category> listCategory = null;
	private static int userid = 0;
	private WordCategoryBusiness wordCategoryBusiness;

	private List<WordCategory> listWordCategory = null;
	private String selectCategory = "";
	private String learnedStatus = "";

	/**
	 * Show category and word list by conditions (learned, notlearned,all)
	 * 
	 * @return success: return sorted list words
	 */

	public String filterWordList() throws Exception {
		listCategory = categoryBusiness.listAllCategory();
		listWordCategory = wordCategoryBusiness.getListWordCategory(selectCategory, learnedStatus, userid);
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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getSelectCategory() {
		return selectCategory;
	}

	public void setSelectCategory(String selectCategory) {
		this.selectCategory = selectCategory;
	}

	public String getLearnedStatus() {
		return learnedStatus;
	}

	public void setLearnedStatus(String learnedStatus) {
		this.learnedStatus = learnedStatus;
	}

}
