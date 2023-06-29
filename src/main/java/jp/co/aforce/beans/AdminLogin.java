package jp.co.aforce.beans;

import java.io.Serializable;

public class AdminLogin implements Serializable{
	private String admin_id;
	private String name;
	private String password;
	
	public String getAdmin_Id() {
		return admin_id;
	}
	public void setAdmin_Id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
