/**
 * Jun 14, 2016, ManageWordsAction.java, vuvandat
 */
package framgiavn.project01.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.business.WordAnswerBusiness;
import framgiavn.project01.web.business.WordBusiness;
import framgiavn.project01.web.business.WordCategoryBusiness;
import framgiavn.project01.web.model.*;

/**
 * @author vuvandat
 *
 */
public class ManageWordsAction extends ActionSupport {

	private CategoryBusiness categoryBusiness = null;
	private WordCategoryBusiness wordCategoryBusiness;
	private List<Category> listCategory = null;
	private List<WordCategory> listWordCategory = null;
	private String selectedCategory = "";
	private int wordId;
	private Word wordNeedEdit;
	private WordBusiness wordBusiness;
	private WordAnswerBusiness wordAnswerBusiness;
	private List<WordAnswer> listWordAnswers;

	public String showListWords() {
		listCategory = categoryBusiness.listAllCategory();
		listWordCategory = wordCategoryBusiness.getListWordByCategory(selectedCategory);
		return SUCCESS;
	}

	public String editWords() {
		setWordNeedEdit(wordBusiness.getWordByWordId(wordId));
		setListWordAnswers(wordAnswerBusiness.getListWordAnswerByWordId(wordId));
		return SUCCESS;
	}

	public String editAndSaveWords() {
		wordBusiness.saveWordAndWordAnswer(wordNeedEdit, listWordAnswers);
		return SUCCESS;
	}

	public String addWordAndWordAnswer() {
		listCategory = categoryBusiness.listAllCategory();
		wordNeedEdit = new Word();
		listWordAnswers = new ArrayList<WordAnswer>();
		for (int i = 0; i < ElearningConstants.NUMBER_WORD_ANSWERS; i++) {
			WordAnswer wordAnswer = new WordAnswer();
			listWordAnswers.add(wordAnswer);
		}
		return SUCCESS;
	}

	public String addAndSaveCreatedWords() {
		wordBusiness.saveCreatedWords(selectedCategory, wordNeedEdit, listWordAnswers);
		return SUCCESS;
	}
	
	public String deleteWordAndAnswer(){
		wordBusiness.deleteWordByWordId(wordId);
		return SUCCESS;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public void setCategoryBusiness(CategoryBusiness categoryBusiness) {
		this.categoryBusiness = categoryBusiness;
	}

	public void setWordCategoryBusiness(WordCategoryBusiness wordCategoryBusiness) {
		this.wordCategoryBusiness = wordCategoryBusiness;
	}

	public List<WordCategory> getListWordCategory() {
		return listWordCategory;
	}

	public void setListWordCategory(List<WordCategory> listWordCategory) {
		this.listWordCategory = listWordCategory;
	}

	public String getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public int getWordId() {
		return wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
	}

	public Word getWordNeedEdit() {
		return wordNeedEdit;
	}

	public void setWordNeedEdit(Word wordNeedEdit) {
		this.wordNeedEdit = wordNeedEdit;
	}

	public WordBusiness getWordBusiness() {
		return wordBusiness;
	}

	public void setWordBusiness(WordBusiness wordBusiness) {
		this.wordBusiness = wordBusiness;
	}

	public WordAnswerBusiness getWordAnswerBusiness() {
		return wordAnswerBusiness;
	}

	public void setWordAnswerBusiness(WordAnswerBusiness wordAnswerBusiness) {
		this.wordAnswerBusiness = wordAnswerBusiness;
	}

	public List<WordAnswer> getListWordAnswers() {
		return listWordAnswers;
	}

	public void setListWordAnswers(List<WordAnswer> listWordAnswers) {
		this.listWordAnswers = listWordAnswers;
	}
}
