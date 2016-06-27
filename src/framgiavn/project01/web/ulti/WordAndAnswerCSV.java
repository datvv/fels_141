package framgiavn.project01.web.ulti;

public class WordAndAnswerCSV {

	private String categoryName;
	private String wordContent;
	private String wordAnswerOne;
	private String wordAnswerOneResult;
	private String wordAnswerTwo;
	private String wordAnswerTwoResult;
	private String wordAnswerThree;
	private String wordAnswerThreeResult;
	private String wordAnswerFour;
	private String wordAnswerFourResult;

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

	public String getWordAnswerOne() {
		return wordAnswerOne;
	}

	public void setWordAnswerOne(String wordAnswerOne) {
		this.wordAnswerOne = wordAnswerOne;
	}

	public String getWordAnswerOneResult() {
		return wordAnswerOneResult;
	}

	public void setWordAnswerOneResult(String wordAnswerOneResult) {
		this.wordAnswerOneResult = wordAnswerOneResult;
	}

	public String getWordAnswerTwo() {
		return wordAnswerTwo;
	}

	public void setWordAnswerTwo(String wordAnswerTwo) {
		this.wordAnswerTwo = wordAnswerTwo;
	}

	public String getWordAnswerTwoResult() {
		return wordAnswerTwoResult;
	}

	public void setWordAnswerTwoResult(String wordAnswerTwoResult) {
		this.wordAnswerTwoResult = wordAnswerTwoResult;
	}

	public String getWordAnswerThree() {
		return wordAnswerThree;
	}

	public void setWordAnswerThree(String wordAnswerThree) {
		this.wordAnswerThree = wordAnswerThree;
	}

	public String getWordAnswerThreeResult() {
		return wordAnswerThreeResult;
	}

	public void setWordAnswerThreeResult(String wordAnswerThreeResult) {
		this.wordAnswerThreeResult = wordAnswerThreeResult;
	}

	public String getWordAnswerFour() {
		return wordAnswerFour;
	}

	public void setWordAnswerFour(String wordAnswerFour) {
		this.wordAnswerFour = wordAnswerFour;
	}

	public String getWordAnswerFourResult() {
		return wordAnswerFourResult;
	}

	public void setWordAnswerFourResult(String wordAnswerFourResult) {
		this.wordAnswerFourResult = wordAnswerFourResult;
	}
	
	public String toString(){
		return  categoryName + "," +
		wordContent + "," + 
		wordAnswerOne + "," +
		wordAnswerOneResult + "," +
		wordAnswerTwo + "," +
		wordAnswerTwoResult + "," +
		wordAnswerThree + "," +
		wordAnswerThreeResult + "," +
		wordAnswerFour + "," +
		wordAnswerFourResult;
	}

}