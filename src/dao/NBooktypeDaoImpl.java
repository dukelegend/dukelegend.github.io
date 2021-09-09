package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.BookType;

public class NBooktypeDaoImpl extends BaseDao implements NBooktypeDao {

	@Override
	public List<BookType> getBooktTypes() {
		String sql = "select * from booktype";
		ResultSet rs=exceuteQuery(sql);
		List<BookType> lstBooktTypes=new ArrayList<BookType>();
		try {
			while(rs.next()){
				BookType bookType=new BookType();
				bookType.setTypeid(rs.getString("TYPEID"));
				bookType.setName(rs.getString("NAME"));
				bookType.setDescription(rs.getString("DESCRIPTION"));
				lstBooktTypes.add(bookType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return lstBooktTypes;
	}

}
