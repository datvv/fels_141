/**
 * Jun 4, 2016, CategoryDAOImpl.java, vuvandat
 */
package framgiavn.project01.web.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project01.web.dao.CategoryDAO;
import framgiavn.project01.web.model.Category;

/**
 * @author vuvandat
 *
 */
public class CategoryDAOImpl extends HibernateDaoSupport implements CategoryDAO {

	@Override
	public List<Category> listAllCategory() throws Exception {
		Query query = getSession().getNamedQuery("Category.listAll");
		if (query.list() != null) {
			return (List<Category>) query.list();
		} else {
			return null;
		}
	}

}
