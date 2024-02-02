package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.item;

/**
 * ビデオ用DAO
 * @author Isobe daishi*/

public class ItemDAO {

	/**
	 * ビデオテーブルのデータをすべて取得するメソッド
	 * @return ビデオデータ
	 */
	public List<item> get() {
		List<item> Itemlist = new ArrayList<>();

		DBManager manager = DBManager.getInstance();
		try (Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM merchandise";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			// データをリストに格納
			while (rs.next()) {
				item video = rs2model(rs);
				Itemlist.add(video);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Itemlist;
	}

	/**
	 * ビデオテーブル内から、主キーがidのレコードを返すメソッド
	 * @param id 主キーの値
	 * @return 発見したビデオデータ、見つからなければnull
	 */

	public item find(int id) {
		item video = null;
		DBManager manager = DBManager.getInstance();
		try (Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM merchandise WHERE id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			// データをリストに格納
			if (rs.next()) {
				video = rs2model(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return video;
	}

	/**
	 * ResultSetの行データをモデルの形に変換するメソッド
	 * @param rs 変換前のデータ
	 * @return 変換後のデータ
	 */
	private item rs2model(ResultSet rs) throws SQLException {
		int ItemID = rs.getInt("id");
		String ItemName = rs.getString("PRODUCT_NAME");
		int ItemPrice = rs.getInt("Price");

		return new item(ItemID, ItemName, ItemPrice);
	}

	public void set(String productName, String productCode, String price,String stock,String FEATURED_PRODUCTS,
			String description, String size, String color, String image_url,String PRODUCT_TYPE,String new_item) {
		System.out.println("do");
		//int pc = Integer.parseInt(productCode);
		int pr = Integer.parseInt(price);
		int st = Integer.parseInt(stock);
		int ptype = Integer.parseInt(PRODUCT_TYPE);
		int ni = Integer.parseInt(new_item);
		int fp = Integer.parseInt(FEATURED_PRODUCTS);
		
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "INSERT INTO merchandise (PRODUCT_NAME,PRICE,STOCK,DESCRIPTION_OF_ITEM,image_url,PRODUCT_TYPE,new_item,FEATURED_PRODUCTS) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = cn.prepareStatement(sql);
			
			stmt.setString(1,productName);
//			stmt.setInt(2, pc);
			stmt.setInt(2, pr);
			stmt.setInt(3, st);
			stmt.setString(4, description);
			//stmt.setString(5, image_url);
			stmt.setString(5, image_url);
			stmt.setInt(6,ptype);
			stmt.setInt(7,ni);
			stmt.setInt(8, fp);
			System.out.println("succses");
//			int Size = Integer.parseInt(size);
//			int Color = Integer.parseInt(color);
//			int Stock = Integer.parseInt(stock);
//			setsize(Size);
//			setcolor(Color);
			
			stmt.executeQuery();
			
			// データをリストに格納
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

//	public void setsize(int size) {
//		DBManager manager = DBManager.getInstance();
//		try (Connection cn = manager.getConnection()) {
//			String sql = "INSERT INTO item_size(size) VALUES(?)";
//			PreparedStatement stmt = cn.prepareStatement(sql);
//
//			stmt.setInt(1, size);
//
//			stmt.executeQuery();
//
//			// データをリストに格納
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

//	public void setcolor(int color) {
//		DBManager manager = DBManager.getInstance();
//		try (Connection cn = manager.getConnection()) {
//			String sql = "INSERT INTO item_color(color) VALUES(?)";
//			PreparedStatement stmt = cn.prepareStatement(sql);
//
//			stmt.setInt(1, color);
//
//			stmt.executeQuery();
//
//			// データをリストに格納
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
