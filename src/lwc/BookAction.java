package lwc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class BookAction extends ActionSupport{
	private DBConnection DBC =new DBConnection();
	private Book book;
	private List<Book> list = new ArrayList<Book>();
	public Book getBook(){
		return book;
	}
	public void setBook(Book book){
		this.book = book;
	}
	public List<Book> getList()
	{
		return list;
	}
	public void setList(List<Book> list)
	{
		this.list=list;
	}

//	action
	public String Add(){
		String sql = "INSERT INTO[Book](ISBN,Title,AuthorID,Publisher,PublishDate,Price) VALUES('"+book.getISBN()+"','"+book.getTitle()+"','"
	+book.getAuthorID()+"','"+book.getPublisher()+"','"+book.getPublishDate()+"','"+book.getPrice()+"')";
		//PreparedStatement sta =null;
		//sta =DBC.con.prepareStatement(sql);
		if(DBC.executeUpdate(sql) == -1)
			return "ERROR";
		else
			return "ADD";
	}
	
	public String Show() throws SQLException{
		String sql = "SELECT*FROM[Book]";
		ResultSet rs;
		if((rs = DBC.executeQuery(sql)) == null)
			return "ERROR";
		
			while(rs.next()){
					Book t = new Book();
					t.setISBN(rs.getString("ISBN"));
					t.setAuthorID(rs.getInt("AuthorID"));
					t.setPrice(rs.getFloat("Price"));
					t.setPublishDate(rs.getString("PublishDate"));
					t.setPublisher(rs.getString("Publisher"));
					t.setTitle(rs.getString("Title"));
					list.add(t);
					}
		
			return "SHOW";
	}
//É¾³ý
	public String Del(){
		String sql ="DELETE FROM [BOOK] WHERE [ISBN] ='"+book.getISBN()+"'";
		if((DBC.executeUpdate(sql)) == -1)
			return "ERROR";
		else
			return "DELETE";
		
	}
	
	public String Update(){
		String sql="update BookDB.dbo.Book set AuthorID=\'"+book.getAuthorID()+"\',Publisher=\'"
	+book.getPublisher()+"\',PublishDate=\'"+book.getPublishDate()+"\',Price=\'"+book.getPrice()+"\' where ISBN=\'"+book.getISBN()+"\'";
		if(DBC.executeUpdate(sql) == -1)
			return "ERROR";
		else
			return "UPDATE";
	}
}