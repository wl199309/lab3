package lwc;

import java.sql.*;


import com.opensymphony.xwork2.ActionSupport;
public class AuthorAction extends ActionSupport{

	private DBConnection DBC =new DBConnection();
	private Author author;
	
	
	public String Add(){
		String sql = "INSERT INTO[Author](Name,Age,Country) VALUES('"+author.getName()+"','"+author.getAge()+"','"+author.getCountry()+"')";
		if(DBC.executeUpdate(sql) == -1)
			return "ERROR";
		else
			return "ADD";
	}
	public String execute(){
		return "SUCCESS";
	}
}
