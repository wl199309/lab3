package lwc;
import java.sql.*;

public class DBConnection {
	Connection con = null;
	Statement sta = null;
	ResultSet rs = null;
	//连接数据库
	public DBConnection(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=BookDB","sa","123456");
			sta = con.createStatement();
		}
		catch(Exception e){
			con = null;
			e.printStackTrace();
		}
	}
	//sql语句 查询
	public ResultSet executeQuery(String sql){
		try {
			rs = sta.executeQuery(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rs = null;
		}
		return rs;
	}
	//sql语句插入修改删除
	public int executeUpdate(String sql){
		 try {
			return sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

}
