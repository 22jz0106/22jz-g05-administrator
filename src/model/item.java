package model;

import java.io.Serializable;

public class item  implements Serializable {
	private int ItemID;
	private String ItemName;
	private int ItemPrice;
	
	public int getItemID() {
		return ItemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public int getItemPrice() {
		return ItemPrice;
	}
	
	public item(int ItemID, String ItemName, int ItemPrice) {
		this.ItemID = ItemID;
		this.ItemName = ItemName;
		this.ItemPrice = ItemPrice;
	}

}
