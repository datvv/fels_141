package framgiavn.project01.web.ulti;

import java.util.Map;

public class WordAnswerObjectCSV {

	private String categoryName;
	private String wordContent;

	private Map<String, Boolean> wordAnswerMap;

	public WordAnswerObjectCSV(String categoryName, String wordContent, Map<String, Boolean> wordAnswerMap) {
		this.setCategoryName(categoryName);
		this.setWordContent(wordContent);
		this.setWordAnswerMap(wordAnswerMap);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getWordContent() {
		return wordContent;
	}

	public void setWordContent(String wordContent) {
		this.wordContent = wordContent;
	}

	public Map<String, Boolean> getWordAnswerMap() {
		return wordAnswerMap;
	}

	public void setWordAnswerMap(Map<String, Boolean> wordAnswerMap) {
		this.wordAnswerMap = wordAnswerMap;
	}

}