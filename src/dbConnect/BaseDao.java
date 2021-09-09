package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操�?
 * @author 
 */
public class BaseDao {
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	/**
	 * 获取数据库连接对�?
	 */
	public Connection getConnection() {
		//String driverClass="oracle.jdbc.driver.OracleDriver";
		//String url="jdbc:oracle:thin:@localhost:1521:orcl";
		
		String driverClass="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost/bookstore?serverTimezone=UTC";
		//Context ctx;
		try {
			//ctx=new InitialContext();
			//DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/news");
		//	conn=ds.getConnection();	
			
			
			Class.forName(driverClass);
			conn=DriverManager.getConnection(url,"root","root");
		}/* catch (NamingException e) {
			e.printStackTrace();
		} */catch (SQLException e) {
			e.printStackTrace();
		}  catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭数据库连�?
	 * @param conn 数据库连�?
	 * @param stmt Statement对象
	 * @param rs 结果
	 */
	public void closeAll() {
		// 若结果集对象不为空，则关�??
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若Statement对象不为空，则关�??
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若数据库连接对象不为空，则关�??
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 增删改操�?
	 * @param sql语句
	 * @param prams 参数数组
	 * @return 执行结果
	 */
	public int exceuteUpdate(String sql,Object...prams){
		int result=0;
		conn=this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<prams.length;i++){
				pstmt.setObject(i+1, prams[i]);	
			}
			//System.out.println(sql);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}

		return result;
	}
	
	
	public int exceuteUpdate1(String sql,Object...prams){
		int result=0;
		conn=this.getConnection();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for(int i=0;i<prams.length;i++){
				pstmt.setObject(i+1, prams[i]);	
			}
			result=pstmt.executeUpdate();
			  ResultSet rst = pstmt.getGeneratedKeys();
		        if(rst.next()) {
		        	result = rst.getInt(1);
		            System.out.print("��ȡ�Զ����ӵ�id��=="+result+"\n");
		        }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return result;
	}
	/**
	 * 查询
	 */
	
	public ResultSet exceuteQuery(String sql,Object...params){
		
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pstmt.setObject(i+1, params[i]);
			}
			
			rs=pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}
