package org.tukorea.project.domain;

import java.util.Date;

public class UserVO {
	private String id;
	private String name;
	private String passwd;
	private String residence;
	private Date regDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	
	public String toString() {
		return "MemberVO [userId=" + id + ", userPass=" + passwd + ", residence=" + residence + ", regDate="
				+ regDate + "]";
	}
	
}
