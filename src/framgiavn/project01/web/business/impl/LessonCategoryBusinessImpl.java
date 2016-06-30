/**
 * Jun 17, 2016, LessonCategoryBusinessImpl.java, datvv
 */
package framgiavn.project01.web.business.impl;

import java.util.List;
import framgiavn.project01.web.business.LessonCategoryBusiness;
import framgiavn.project01.web.dao.LessonCategoryDAO;
import framgiavn.project01.web.ulti.Logit2;

/**
 * @author datvv
 *
 */
public class LessonCategoryBusinessImpl implements LessonCategoryBusiness {

	private LessonCategoryDAO lessonCategoryDAO;
//	private static final Logit2 log = Logit2.getInstance(WordCategoryBusinessImpl.class);

	@Override
	public int getLearnedNumberUser(int userId, String category, String learnedStatus) {
		try {
			return getLessonCategoryDAO().getLearnedNumberUser(userId, category, learnedStatus);
		} catch (Exception e) {
//			log.error("get failed ",e);
			return 0;
		}
	}

	@Override
	public List<String> getListCategory() {
		try {
			return getLessonCategoryDAO().getListCategory();
		} catch (Exception e) {
//			log.error("get failed ",e);
			return null;
		}
	}

	@Override
	public String getContentCategory(int userId, String category) {
		try {
			return getLessonCategoryDAO().getContentCategory(userId, category);
		} catch (Exception e) {
//			log.error("get failed ",e);
			return null;
		}
	}

	public LessonCategoryDAO getLessonCategoryDAO() {
		return lessonCategoryDAO;
	}

	public void setLessonCategoryDAO(LessonCategoryDAO lessonCategoryDAO) {
		this.lessonCategoryDAO = lessonCategoryDAO;
	}

}
