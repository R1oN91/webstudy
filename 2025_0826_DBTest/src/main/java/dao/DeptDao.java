package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import db.vo.DeptVo;
import service.DBService;

//DAO(Data Access Object) 데이터 처리하는 객체. 
//CRUD처리
//Create : insert
//Read	 : select
//Update : update
//Delete : delete

public class DeptDao {

	//single-ton
	static DeptDao single = null;

	public static DeptDao getInstance() {
		if (single == null)
			single = new DeptDao();

		return single;
	}

	private DeptDao() {
	}
	
	//조회
	public List<DeptVo> selectList(){
		
		List<DeptVo> list = new ArrayList<DeptVo>();
		
			Connection 		  conn 	= null;
			PreparedStatement pstmt = null;
			ResultSet         rs 	= null;
		
			String 			  sql 	= "select * from dept";
			//String 	sql = "select * from dept where id=? and pwd=?"; <- 보안성이 좋음. 
			try {
				
				//1.Connection 얻어오기
				conn = DBService.getInstance().getConnection();
				
				//2.PreparedStatement얻기
				pstmt = conn.prepareStatement(sql);
				
				//3. ResultSet 얻어오기
				rs = pstmt.executeQuery();
				
				//4. 레코드값을 VO포장후 list넣는다
				while(rs.next()) {
					
					DeptVo vo = new DeptVo();
					//rs가 가르키는 레코드값을 vo에 넣습니다. 
					vo.setDeptno(rs.getInt("deptno"));
					vo.setDname(rs.getString("dname"));
					vo.setLoc(rs.getString("loc"));
					
					list.add(vo);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				
				try {
					
					if(rs!=null) rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		return list;
	}
}
