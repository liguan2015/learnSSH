package cn.fjh.ssh.web.form;

/**
 * 表单的值对象（VO对象）
 * 
 * @author fang jie hui
 * 
 */

@SuppressWarnings("serial")
public class SshUserForm implements java.io.Serializable {
	private String userID;
	private String userName;
	private String userDate;

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

	public String getUserDate() {
		return userDate;
	}

	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}

}
