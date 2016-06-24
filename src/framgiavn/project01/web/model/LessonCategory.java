/**
 * Jun 17, 2016, LessonCategory.java, datvv
 */
package framgiavn.project01.web.model;

/**
 * @author datvv
 *
 */
public class LessonCategory {
	private int userId;
	private String category;
	private int learnedCount;
	private int learnedTotal;
	private String content;

	public LessonCategory() {
		super();
	}

	public LessonCategory(int userId, String category, int learnedCount, int learnedTotal, String content) {
		this.userId = userId;
		this.category = category;
		this.learnedCount = learnedCount;
		this.learnedTotal = learnedTotal;
		this.content = content;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLearnedCount() {
		return learnedCount;
	}

	public void setLearnedCount(int learnedCount) {
		this.learnedCount = learnedCount;
	}

	public int getLearnedTotal() {
		return learnedTotal;
	}

	public void setLearnedTotal(int learnedTotal) {
		this.learnedTotal = learnedTotal;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
