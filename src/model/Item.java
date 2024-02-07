package model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Item  implements Serializable {
	
	
	private int itemID;
	private String itemName;
	private int itemPrice;
	private int itemStock;
	private String itemDESCRIPTION;
	private String itemimage_url;
	private int pRODUCT_TYPE;
	private int new_item;
	private int fEATURED_PRODUCTS;
	private LocalDateTime cdate;
	private LocalDateTime  udate;
	public LocalDateTime getCdate() {
		return cdate;
	}
	public LocalDateTime getUdate() {
		return udate;
	}
	public int getItemID() {
		return itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public int getItemStock() {
		return itemStock;
	}
	public String getItemDESCRIPTION() {
		return itemDESCRIPTION;
	}
	public String getItemimage_url() {
		return itemimage_url;
	}
	public int getPRODUCT_TYPE() {
		return pRODUCT_TYPE;
	}
	public int getNew_item() {
		return new_item;
	}
	public int getFEATURED_PRODUCTS() {
		return fEATURED_PRODUCTS;
	}
	public Item() {}
	public Item(int itemID, String itemName, int itemPrice, int itemStock, String itemDESCRIPTION, String itemimage_url,
			int pRODUCT_TYPE, int new_item, int fEATURED_PRODUCTS, LocalDateTime cdate, LocalDateTime udate) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemStock = itemStock;
		this.itemDESCRIPTION = itemDESCRIPTION;
		this.itemimage_url = itemimage_url;
		this.pRODUCT_TYPE = pRODUCT_TYPE;
		this.new_item = new_item;
		this.fEATURED_PRODUCTS = fEATURED_PRODUCTS;
		this.cdate = cdate;
		this.udate = udate;
	}

}
