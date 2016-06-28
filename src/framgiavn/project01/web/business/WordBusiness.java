/**
 * Jun 28, 2016, WordBusiness.java, vuvandat
 */
package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

/**
 * @author vuvandat
 *
 */
public interface WordBusiness {

	public Word getWordByWordId(int wordId);

	public void saveWordAndWordAnswer(Word word, List<WordAnswer> listWordAnswer);
	
	public void saveCreatedWords(String category, Word word, List<WordAnswer> listWordAnswers);
	
	public void deleteWordByWordId(int wordId);
}
