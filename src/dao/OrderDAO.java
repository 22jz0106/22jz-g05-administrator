package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Orderadmin;

public class OrderDAO {
    // データベースへの接続やクエリの実行はこのクラスで行う

    public List<Orderadmin> getAllOrders() {
        List<Orderadmin> userList = new ArrayList<>();
        DBManager manager = DBManager.getInstance();
        try (Connection cn = manager.getConnection()){
        		String sql = "SELECT * FROM 購入履歴の表";//これとってくれば、注文もユーザーも合計金額も全部とってこれるくね？;
        		PreparedStatement stmt = cn.prepareStatement(sql);
        		ResultSet rs = stmt.executeQuery();
        		
            while (rs.next()) {
            	Orderadmin ua = rs2model(rs);
                userList.add(ua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    public Orderadmin rs2model(ResultSet rs) throws SQLException{
    	String UserName = rs.getString("UserName");
        int ItemSUM = rs.getInt("ItemSUM");
        int PriceSUM = rs.getInt("PriceSUM");
        String PaymentStatus = rs.getNString("PaymentStatus");
        
		
		return new Orderadmin(UserName, ItemSUM , PriceSUM, PaymentStatus);
    }
	
}
