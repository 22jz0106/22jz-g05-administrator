package model;

public class item {
	int ItemID;
	String ItemName;
	double ItemPrice;
	
	public int getItemID() {
		return ItemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public double getItemPrice() {
		return ItemPrice;
	}
	
	public item(int ItemID,String ItemName, double ItemPrice) {
		this.ItemID = ItemID;
		this.ItemName = ItemName;
		this.ItemPrice = ItemPrice;
	}

}
