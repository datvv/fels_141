package framgiavn.project01.web.model;

import java.io.Serializable;

/**
 * @author nguyenanhvan
 *
 */
public class Activity implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int targetId;
	private int userId;
	private String actionType;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
}
