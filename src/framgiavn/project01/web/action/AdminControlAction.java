package framgiavn.project01.web.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.ReadingCSV;

public class AdminControlAction extends ActionSupport {

	private User user = null;
	private UserBusiness userBusiness = null;
	private File file;
	private String contentType;
	private String fileName;

	public String importCSV() {
		ReadingCSV readingCSV = new ReadingCSV(fileName);
		try {
			userBusiness.createWordAnswerByCSV(readingCSV.getCategoryWordAndAnswerList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
