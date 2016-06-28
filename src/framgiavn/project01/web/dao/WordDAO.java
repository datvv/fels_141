/**
 * Jun 28, 2016, WordDAO.java, vuvandat
 */
package framgiavn.project01.web.dao;

import java.util.List;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

/**
 * @author vuvandat
 *
 */
public interface WordDAO {

	public Word getWordByWordId(int wordId) throws Exception;

	public void saveWordAndWordAnswer(Word word, List<WordAnswer> listWordAnswer) throws Exception;
	
	public boolean createWord(Word word) throws Exception;
	
	public Word getWordByWordNameAndCategoryId(String wordName, int CategoryId) throws Exception;
	
	public void deleteWord(Word word) throws Exception;
}
