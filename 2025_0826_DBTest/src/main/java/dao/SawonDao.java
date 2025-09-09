package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.vo.SawonViewVo;
import service.DBService;

public class SawonDao {

	//single-ton
	static SawonDao single = null;

	public static SawonDao getInstance() {
		if (single == null)
			single = new SawonDao();

		return single;
	}

	public SawonDao() {
	}
	
	public List<SawonViewVo> selectList(){
			
			List<SawonViewVo> list = new ArrayList<SawonViewVo>();
			
			Connection 		  conn 	= null;
			PreparedStatement pstmt = null;
			ResultSet         rs 	= null;
			
			String 			  sql 	= "select * from sawon_view";
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
					
					SawonViewVo vo = new SawonViewVo();
					//rs가 가르키는 레코드값을 vo에 넣습니다. 
					vo.setSabun(rs.getInt("sabun"));
					vo.setSaname(rs.getString("saname"));
					vo.setSasex(rs.getString("sasex"));
					vo.setDeptno(rs.getInt("saDeptno"));
					vo.setSajob(rs.getString("sajob"));
					vo.setSahire(rs.getString("sahire"));
					vo.setSamgr(rs.getInt("samgr"));
					vo.setSapay(rs.getInt("sapay"));
					vo.setHire_year(rs.getInt("hire_year"));
					vo.setHire_month(rs.getInt("hire_month"));
					vo.setHire_season(rs.getString("hire_season"));
					
					
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
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return list;
		}
}
