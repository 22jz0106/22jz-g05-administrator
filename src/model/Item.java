package model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Item  implements Serializable {
	
	
	private int ItemID;
	private String ItemName;
	private int ItemPrice;
	private int ItemStock;
	private String ItemDESCRIPTION;
	private String Itemimage_url;
	private int PRODUCT_TYPE;
	private int new_item;
	private int FEATURED_PRODUCTS;
	private LocalDateTime cdate;
	private LocalDateTime  udate;
	public LocalDateTime getCdate() {
		return cdate;
	}
	public LocalDateTime getUdate() {
		return udate;
	}
	public int getItemID() {
		return ItemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public int getItemPrice() {
		return ItemPrice;
	}
	public int getItemStock() {
		return ItemStock;
	}
	public String getItemDESCRIPTION() {
		return ItemDESCRIPTION;
	}
	public String getItemimage_url() {
		return Itemimage_url;
	}
	public int getPRODUCT_TYPE() {
		return PRODUCT_TYPE;
	}
	public int getNew_item() {
		return new_item;
	}
	public int getFEATURED_PRODUCTS() {
		return FEATURED_PRODUCTS;
	}
	public Item() {}
	public Item(int itemID, String itemName, int itemPrice, int itemStock, String itemDESCRIPTION, String itemimage_url,
			int pRODUCT_TYPE, int new_item, int fEATURED_PRODUCTS, LocalDateTime cdate, LocalDateTime udate) {
		super();
		ItemID = itemID;
		ItemName = itemName;
		ItemPrice = itemPrice;
		ItemStock = itemStock;
		ItemDESCRIPTION = itemDESCRIPTION;
		Itemimage_url = itemimage_url;
		PRODUCT_TYPE = pRODUCT_TYPE;
		this.new_item = new_item;
		FEATURED_PRODUCTS = fEATURED_PRODUCTS;
		this.cdate = cdate;
		this.udate = udate;
	}

}
