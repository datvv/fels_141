package framgiavn.project01.web.model;

import java.io.Serializable;

/**
 * @author nguyenanhvan
 *
 */
public class Relationship implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int followingId;
	private int followerId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getFollowingId() {
		return followingId;
	}

	public void setFollowingId(int followingId) {
		this.followingId = followingId;
	}

	public int getFollowerId() {
		return followerId;
	}

	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}
	
}
