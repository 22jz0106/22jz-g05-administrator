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
		List<item> list = new ArrayList<>();
		
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM Items";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			while(rs.next()) {
				item video = rs2model(rs);
				list.add(video);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

	
	/**
	 * ビデオテーブル内から、主キーがidのレコードを返すメソッド
	 * @param id 主キーの値
	 * @return 発見したビデオデータ、見つからなければnull
	 */
	
	public item find(int id) {
		item video = null;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM Items WHERE id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			if (rs.next()) {
				video = rs2model(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  video;
	}
	
	/**
	 * ResultSetの行データをモデルの形に変換するメソッド
	 * @param rs 変換前のデータ
	 * @return 変換後のデータ
	 */
	private item rs2model(ResultSet rs) throws SQLException {
		int ItemId = rs.getInt("id");
		String ItemName = rs.getString("ItemName");
		double ItemPrice= rs.getDouble("ItemPrice");

		return new item(ItemId,ItemName, ItemPrice);
	}
}



