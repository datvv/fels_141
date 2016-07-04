package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.LessonWordDAO;
import framgiavn.project01.web.model.LessonWord;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;
import framgiavn.project01.web.ulti.Logit2;

public class LessonWordDAOImpl extends HibernateDaoSupport implements LessonWordDAO {
//	private static final Logit2 log = Logit2.getInstance(UserDAOImpl.class);
	protected void initDAO() {

	}

	@Override
	public List<LessonWord> findLessonWordByLessonId(int lesson_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("LessonWord.SelectByLessonId");
			query.setParameter("lesson_id", lesson_id);
			return query.list();
		} catch (Exception re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void createLessonWord(int lesson_id, Word word, WordAnswer wordAnswer) throws Exception {
		try {
			Session session = getSession();
			LessonWord lw = new LessonWord();
			lw.setLessonId(lesson_id);
			lw.setWordId(word.getId());
			lw.setWordAnswerId(wordAnswer.getId());
			session.save(lw);
		} catch (Exception re) {
			// log.error("get failed", re);
			throw re;
		}
	}

}
