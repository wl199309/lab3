package lwc;
import java.sql.*;

public class DBConnection {
	Connection con = null;
	Statement sta = null;
	ResultSet rs = null;
	//�������ݿ�
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
	//sql��� ��ѯ
	public ResultSet executeQuery(String sql){
		try {
			rs = sta.executeQuery(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rs = null;
		}
		return rs;
	}
	//sql�������޸�ɾ��
	public int executeUpdate(String sql){
		 try {
			return sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

}
