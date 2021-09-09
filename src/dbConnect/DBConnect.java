package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBConnect {
	String driver="com.mysql.cj.jdbc.Driver";
	String connection="jdbc:mysql://localhost/bookstore?serverTimezone=UTC";
	String username="root";
	String password="root";
	Connection conn;
	Statement stmt;
	PreparedStatement pre;
	public DBConnect(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		try {
			conn=DriverManager.getConnection(connection,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public Statement getStatement(){
		try {
			conn=this.getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	public PreparedStatement getPreparedStatement(String sql) throws SQLException{
		conn=this.getConnection();
		pre=conn.prepareStatement(sql);
		return pre;
	}
	public int update(String sql) throws SQLException{
		stmt=this.getStatement();
		int n=stmt.executeUpdate(sql);
		conn.close();
		return n;
	}
	public ResultSet query(String sql) throws SQLException{
		System.out.println(sql);
		stmt=this.getStatement();
		ResultSet rs=stmt.executeQuery(sql);
		return rs;
	}
	public void closeConnection() throws SQLException{
		if(conn!=null)
			conn.close();
	}
}

