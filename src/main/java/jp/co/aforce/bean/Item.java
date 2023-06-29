package jp.co.aforce.bean;

import java.io.Serializable;

public class Item implements Serializable {
	String ITEM_NAME;
	String ENGLISH;
	String DERIVATION;
	int PRICE;
	String DATASHEET;
	String CATEGORY;
	int NO;
	String IMG;
	int Quantity;
	
	public String getITEM_NAME() {
		return ITEM_NAME;
	}
	public String getENGLISH() {
		return ENGLISH;
	}
	public String getDERIVATION() {
		return DERIVATION;
	}
	public int getPRICE() {
		return PRICE;
	}
	public String getDATASHEET() {
		return DATASHEET;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public int getNO() {
		return NO;
	}
	public String getIMG() {
		return IMG;
	}
	public int getQuantity() {
		return Quantity;
	}
	
	//set
	public void setITEM_NAME(String ITEM_NAME) {
		this.ITEM_NAME = ITEM_NAME;
	}
	public void setENGLISH(String ENGLISH) {
		this.ENGLISH = ENGLISH;
	}
	public void setDERIVATION(String DERIVATION) {
		this.DERIVATION = DERIVATION;
	}
	public void setPRICE(int PRICE) {
		this.PRICE = PRICE;
	}
	public void setDATASHEET(String DATASHEET) {
		this.DATASHEET = DATASHEET;
	}
	public void setCATEGORY(String CATEGORY) {
		this.CATEGORY = CATEGORY;
	}
	public void setNO(int NO) {
		this.NO = NO;
	}
	public void setIMG(String IMG) {
		this.IMG = IMG;
	}
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}


}
