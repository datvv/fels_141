/**
 * Jun 28, 2016, WordAnswer.java, vuvandat
 */
package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.WordAnswer;

/**
 * @author vuvandat
 *
 */
public interface WordAnswerBusiness {

	public List<WordAnswer> getListWordAnswerByWordId(int wordId);
}
