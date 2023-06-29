package jp.co.aforce.bean;

import java.io.Serializable;

public class Member implements Serializable {
	private String USER_NAME;
	private String PASSWORD;
	private String NAME;
	private String BIRTHDAY;
	private String MAIL;
	private String TEL;
	private String POSTAL_CODE;
	private String ADDRESS1;
	private String ADDRESS2;
	private String ADDRESS3;
	private int ID;
	
	//get
	public String getUSER_NAME() {
		return USER_NAME;
	}
	
	public String getPASSWORD() {
		return PASSWORD;
	}
	
	public String getNAME() {
		return NAME;
	}
	public String getBIRTHDAY() {
		return BIRTHDAY;
	}
	public String getMAIL() {
		return MAIL;
	}
	public String getTEL() {
		return TEL;
	}
	public String getPOSTAL_CODE() {
		return POSTAL_CODE;
	}
	public String getADDRESS1() {
		return ADDRESS1;
	}
	public String getADDRESS2() {
		return ADDRESS2;
	}
	public String getADDRESS3() {
		return ADDRESS3;
	}
	public int getID() {
		return ID;
	}
	
	//set
	public void setUSER_NAME(String USER_NAME) {
		this.USER_NAME = USER_NAME;
	}
	
	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;
	}
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	public void setBIRTHDAY(String BIRTHDAY) {
		this.BIRTHDAY = BIRTHDAY;
	}
	public void setMAIL(String MAIL) {
		this.MAIL = MAIL;
	}
	public void setTEL(String TEL) {
		this.TEL = TEL;
	}
	public void setPOSTAL_CODE(String POSTAL_CODE) {
		this.POSTAL_CODE = POSTAL_CODE;
	}
	public void setADDRESS1(String ADDRESS1) {
		this.ADDRESS1 = ADDRESS1;
	}
	public void setADDRESS2(String ADDRESS2) {
		this.ADDRESS2= ADDRESS2;
	}
	public void setADDRESS3(String ADDRESS3) {
		this.ADDRESS3 = ADDRESS3;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	
	

}
