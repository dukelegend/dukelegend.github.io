package dbConnect;
/**
 *���ݿ⹤���� 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DbConnection {
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?useUnicode=true&serverTimezone=UTC","root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public void closeAll() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int executeUpdate(String sql,Object...prams) {
		int result=0;
		conn=this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<prams.length;i++) {
				pstmt.setObject(i+1, prams[i]);
			}
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet executeQuery(String sql,Object...prams) {
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<prams.length;i++) {
				pstmt.setObject(i+1, prams[i]);
			}
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}
