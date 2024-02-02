package model;

public class Orderadmin {
	String UserName;
	int ItemSUM;
	int PriceSUM;
	String PaymentStatus;

	public String getUserName() {
		return UserName;
	}
	public int getItemSUM() {
		return ItemSUM;
	}
	public int getPriceSUM() {
		return PriceSUM;
	}
	public String getPaymentStatus() {
		return PaymentStatus;
	}
	
	public Orderadmin(String UserName, int ItemSUM, int PriceSUM,String PaymentStatus) {
		this.UserName = UserName;
		this.ItemSUM = ItemSUM;
		this.PriceSUM = PriceSUM;
		this.PaymentStatus = PaymentStatus;
	}
}
