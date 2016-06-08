/**
 * Jun 8, 2016, CategoriesAction.java, datvv
 */
package framgiavn.project01.web.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.UserCategoryBusiness;
import framgiavn.project01.web.model.UserCategory;

/**
 * Handle data to Categories screen
 * 
 * @author datvv
 *
 */
public class CategoriesAction extends ActionSupport {

	private UserCategoryBusiness userCategoryBusiness;
	private List<String> listCategory;
	private static int userid = 0;

	private List<UserCategory> listUserCategory = new ArrayList<UserCategory>();

	/**
	 * Filter and show data to Categories screen.
	 * 
	 * @return success: return filtered data
	 * 
	 */
	public String showCategories() throws Exception {
		UserCategory userCategory = null;
		listCategory = userCategoryBusiness.getListCategory();
		for (String category : listCategory) {
			String content = userCategoryBusiness.getContentCategory(userid, category);
			int learnedNumber = userCategoryBusiness.getLearnedNumberUser(userid, category, 1);
			int totalWords = userCategoryBusiness.getLearnedNumberUser(userid, category, 0);
			userCategory = new UserCategory(userid, category, learnedNumber, totalWords, content);

			listUserCategory.add(userCategory);
			System.out.println("cat :" + category);
			System.out.println("conten :" + content);
			System.out.println("learned nb :" + learnedNumber);
			System.out.println("total :" + totalWords);
		}

		return SUCCESS;
	}

	public UserCategoryBusiness getUserCategoryBusiness() {
		return userCategoryBusiness;
	}

	public void setUserCategoryBusiness(UserCategoryBusiness userCategoryBusiness) {
		this.userCategoryBusiness = userCategoryBusiness;
	}

	public static int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public List<UserCategory> getListUserCategory() {
		return listUserCategory;
	}

	public void setListUserCategory(List<UserCategory> listUserCategory) {
		this.listUserCategory = listUserCategory;
	}

}
