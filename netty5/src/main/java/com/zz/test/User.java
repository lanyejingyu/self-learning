package com.zz.test;

import java.io.Serializable;

public class User implements Serializable {

	private String userName;
	private String pass;

	public String toString(){
		return "[userName="+this.userName+",pass="+this.pass+"]";
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
