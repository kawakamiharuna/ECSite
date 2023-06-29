package jp.co.aforce.bean;

import java.io.Serializable;

public class Cart implements Serializable {
    private Item item;
    private int count;

    public Item getItem() {
    	return item;
    }
    
    public int getCount() {
    	return count;
    }
    
    public void setItem(Item item) {
    	this.item = item;
    }
    
    public void setCount(int count) {
    	this.count = count;
    }
}


