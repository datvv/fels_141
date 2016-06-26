/**
 * Jun 4, 2016, CategoryDAOImpl.java, vuvandat
 */
package framgiavn.project01.web.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project01.web.dao.CategoryDAO;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.ulti.Logit2;

/**
 * @author vuvandat
 *
 */

public class CategoryDAOImpl extends HibernateDaoSupport implements CategoryDAO {

	// private static final Logit2 log = Logit2.getInstance(UserDAOImpl.class);
	protected void initDAO() {

	}

	@Override
	public Category findByCategoryId(int category_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Category.SelectCategoryById");
			query.setParameter("category_id", category_id);
			Category category = (Category) query.uniqueResult();
			return category;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Category> listAllCategory() throws Exception {
		Query query = getSession().getNamedQuery("Category.listAll");
		if (query.list() != null) {
			return (List<Category>) query.list();
		} else {
			return null;
		}
	}

	@Override
	public void updateAndSaveCategory(Category category) {
		Session session = getSession();
		session.saveOrUpdate(category);
	}

	@Override
	public void deleteCategory(Category category) throws Exception {
		Session session = getSession();
		session.delete(category);
		session.flush();
	}

}
