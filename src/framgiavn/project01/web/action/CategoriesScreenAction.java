/**
 * Jun 17, 2016, CategoriesScreenAction.java, datvv
 */
package framgiavn.project01.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.LessonCategoryBusiness;
import framgiavn.project01.web.model.ElearningConstants;
import framgiavn.project01.web.model.LessonCategory;
import framgiavn.project01.web.model.User;

/**
 * @author datvv
 *
 */
public class CategoriesScreenAction extends ActionSupport {

	private LessonCategoryBusiness lessonCategoryBusiness = null;
	private List<String> listCategory = null;
	private List<LessonCategory> listLessonCategory = null;

	/**
	 * Show data into Categories Screen.
	 * 
	 * @return success: return data into Categories Screen
	 * 
	 */
	public String showCategories() throws Exception {

		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("currentUser");
		int userId = user.getId();
		LessonCategory lessonCategory = null;
		listLessonCategory = new ArrayList<LessonCategory>();
		listCategory = lessonCategoryBusiness.getListCategory();
		for (String category : listCategory) {
			String content = lessonCategoryBusiness.getContentCategory(userId, category);
			int learnedNumber = lessonCategoryBusiness.getLearnedNumberUser(userId, category, ElearningConstants.LEARNED);
			int totalWords = lessonCategoryBusiness.getLearnedNumberUser(userId, category, ElearningConstants.ALL);
			lessonCategory = new LessonCategory(userId, category, learnedNumber, totalWords, content);
			if (totalWords > 0) {
				listLessonCategory.add(lessonCategory);
			}
		}
		return SUCCESS;
	}

	public LessonCategoryBusiness getLessonCategoryBusiness() {
		return lessonCategoryBusiness;
	}

	public void setLessonCategoryBusiness(LessonCategoryBusiness lessonCategoryBusiness) {
		this.lessonCategoryBusiness = lessonCategoryBusiness;
	}

	public List<LessonCategory> getListLessonCategory() {
		return listLessonCategory;
	}

	public void setListLessonCategory(List<LessonCategory> listLessonCategory) {
		this.listLessonCategory = listLessonCategory;
	}

}
