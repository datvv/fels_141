/**
 * Jun 28, 2016, WordAnswer.java, vuvandat
 */
package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.WordAnswer;

/**
 * @author vuvandat
 *
 */
public interface WordAnswerDAO {

	public List<WordAnswer> getListWordAnswerByWordId(int wordId) throws Exception;

	public boolean createWordAnswer(WordAnswer wordAnswer) throws Exception;
}
