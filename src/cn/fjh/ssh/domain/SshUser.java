package cn.fjh.ssh.domain;

import java.util.Date;

/**
 * 持久层对象（PO对象）
 * 
 * @author fang jie hui
 * 
 */
@SuppressWarnings("serial")
public class SshUser implements java.io.Serializable {
	private String userID;
	private String userName;
	private Date userDate;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserDate() {
		return userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

}
