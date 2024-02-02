package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Useradmin;

public class UseradminDAO {
    // データベースへの接続やクエリの実行はこのクラスで行う

    public List<Useradmin> getAllUsers() {
        List<Useradmin> userList = new ArrayList<>();
        DBManager manager = DBManager.getInstance();
        try (Connection cn = manager.getConnection()){
        		String sql = "SELECT * FROM users WHERE username != '小島隆幹' & '磯邊大志'";
        		PreparedStatement stmt = cn.prepareStatement(sql);
        		ResultSet rs = stmt.executeQuery();
        		
            while (rs.next()) {
            	Useradmin ua = rs2model(rs);
                userList.add(ua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    public Useradmin rs2model(ResultSet rs) throws SQLException{
    	String username = rs.getString("name");
        String furigana = rs.getString("name_furigana");
        String adress = rs.getString("user_adress");
        int phonnumber = rs.getInt("phonnumber");
        String password = rs.getString("password");
        
		
		return new Useradmin(username, furigana,adress , phonnumber, password);
    }
}
