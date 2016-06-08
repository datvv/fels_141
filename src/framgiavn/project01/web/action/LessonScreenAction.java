package framgiavn.project01.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.business.LessonBusiness;
import framgiavn.project01.web.business.LessonWordBusiness;
import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.model.Lesson;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

public class LessonScreenAction extends ActionSupport {
	public static final int MAX_NUMBER_WORDS = 20;
	private int maxWords = MAX_NUMBER_WORDS;
	private Map<String, Object> session = null;
	private User user = null;
	private UserBusiness userBusiness = null;
	private Category category = null;
	private Lesson lesson = null;
	private LessonBusiness lessonBusiness = null;
	private LessonWordBusiness lessonWordBusiness = null;
	private Map<Word, WordAnswer> mapWordAndUserAnswer = null;
	private Map<Word, List<WordAnswer>> mapWordAndAnswers = null;
	private Word word = null;
	private List<Word> wordList = null;
	private List<WordAnswer> answerList = null;
	private String userAnswerContent = null;
	private int currentWord = 0;
	private int numberOfTrueAnswer = 0;
	private int numberOfQuestion = 0;

	public String solveProblem() {
		session = ActionContext.getContext().getSession();
		try {
			user = (User) session.get("currentUser");
			category = (Category) session.get("currentCategory");
			currentWord = (int) session.get("currentWord");
			if (currentWord == 0) {
				lesson = lessonBusiness.createLesson(user.getId(), category.getId());
				mapWordAndUserAnswer = new HashMap<Word, WordAnswer>();
				mapWordAndAnswers = userBusiness.getAllQuestion(user.getId(), category.getId());
				wordList = new ArrayList<Word>(mapWordAndAnswers.keySet());
				maxWords = Math.min(wordList.size(), MAX_NUMBER_WORDS);

				session.put("lesson", lesson);
				session.put("mapWordAndUserAnswer", mapWordAndUserAnswer);
				session.put("mapWordAndAnswers", mapWordAndAnswers);
				session.put("wordList", wordList);
				session.put("maxWords", maxWords);
				session.put("numberOfTrueAnswer", numberOfTrueAnswer);
				session.put("numberOfQuestion", numberOfQuestion);
			} else {
				lesson = (Lesson) session.get("lesson");
				mapWordAndUserAnswer = (Map<Word, WordAnswer>) session.get("mapWordAndUserAnswer");
				mapWordAndAnswers = (Map<Word, List<WordAnswer>>) session.get("mapWordAndAnswers");
				wordList = (List<Word>) session.get("wordList");
				maxWords = (int) session.get("maxWords");
				numberOfTrueAnswer = (int) session.get("numberOfTrueAnswer");
				numberOfQuestion = (int) session.get("numberOfQuestion");
			}
			word = wordList.get(currentWord);
			answerList = mapWordAndAnswers.get(word);
			if (userAnswerContent != null) {
				Word wordResult = wordList.get(currentWord - 1);
				List<WordAnswer> answerListResult = mapWordAndAnswers.get(wordResult);
				for (WordAnswer wa : answerListResult) {
					if (wa.getContent().equals(userAnswerContent)) {
						mapWordAndUserAnswer.put(wordResult, wa);
						lessonWordBusiness.createLessonWord(lesson.getId(), wordResult, wa);
						lessonBusiness.setResultById(lesson.getId(), lesson.getResult() + 1);
						numberOfQuestion++;
						if (wa.isCorrect())
							numberOfTrueAnswer++;
						break;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (++currentWord <= maxWords) {
			session.put("currentWord", currentWord);
			return SUCCESS;
		} else {
			Word wordResult = wordList.get(currentWord - 2);
			List<WordAnswer> answerListResult = mapWordAndAnswers.get(wordResult);
			for (WordAnswer wa : answerListResult) {
				if (wa.getContent().equals(userAnswerContent)) {
					mapWordAndUserAnswer.put(wordResult, wa);
					try {
						lessonWordBusiness.createLessonWord(lesson.getId(), wordResult, wa);
						lessonBusiness.setResultById(lesson.getId(), lesson.getResult() + 1);
						numberOfQuestion++;
						if (wa.isCorrect())
							numberOfTrueAnswer++;
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}

			session.remove("lesson");
			session.remove("currentWord");
			session.remove("mapWordAndUserAnswer");
			session.remove("mapWordAndAnswers");
			session.remove("wordList");
			session.remove("maxWords");
			return ERROR;
		}
	}

	public int getNumberOfTrueAnswer() {
		return numberOfTrueAnswer;
	}

	public void setNumberOfTrueAnswer(int numberOfTrueAnswer) {
		this.numberOfTrueAnswer = numberOfTrueAnswer;
	}

	public int getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(int numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public int getMaxWords() {
		return maxWords;
	}

	public void setMaxWords(int max_words) {
		this.maxWords = max_words;
	}

	public int getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(int currentWord) {
		this.currentWord = currentWord;
	}

	public LessonBusiness getLessonBusiness() {
		return lessonBusiness;
	}

	public void setLessonBusiness(LessonBusiness lessonBusiness) {
		this.lessonBusiness = lessonBusiness;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public List<WordAnswer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<WordAnswer> answerList) {
		this.answerList = answerList;
	}

	public List<Word> getWordList() {
		return wordList;
	}

	public void setWordList(List<Word> wordList) {
		this.wordList = wordList;
	}

	public String getUserAnswerContent() {
		return userAnswerContent;
	}

	public void setUserAnswerContent(String userAnswerContent) {
		this.userAnswerContent = userAnswerContent;
	}

	public LessonWordBusiness getLessonWordBusiness() {
		return lessonWordBusiness;
	}

	public void setLessonWordBusiness(LessonWordBusiness lessonWordBusiness) {
		this.lessonWordBusiness = lessonWordBusiness;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Map<Word, WordAnswer> getMapWordAndUserAnswer() {
		return mapWordAndUserAnswer;
	}

	public void setMapWordAndUserAnswer(Map<Word, WordAnswer> mapWordAndUserAnswer) {
		this.mapWordAndUserAnswer = mapWordAndUserAnswer;
	}

}