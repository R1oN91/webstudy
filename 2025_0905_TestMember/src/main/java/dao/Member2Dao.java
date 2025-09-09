package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.MemberVo2;
import service.DBService;

public class Member2Dao {

	
	//single-ton
	static Member2Dao single = null;

	public static Member2Dao getInstance() {

		if (single == null)
			single = new Member2Dao();

		return single;
	}

	private Member2Dao() {

	}//end:single;
	
	//조회
	
	public List<MemberVo2> selectList() {

		List<MemberVo2> list = new ArrayList<MemberVo2>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from [테이블명]";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet 얻어오기
			rs = pstmt.executeQuery();

			//레코드값을 VO포장후 list넣는다
			while (rs.next()) {

				MemberVo2 vo = new MemberVo2();
				//rs가 가리키는 레코드값을 vo에 넣는다
				
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_email(rs.getString("mem_email"));
				vo.setMem_zipcode(rs.getString("mem_zipcode"));
				vo.setMem_addr(rs.getString("mem_addr"));
				vo.setMem_ip(rs.getString("mem_ip"));
				vo.setMem_regdate(rs.getString("mem_regdate"));
				vo.setMem_grade(rs.getString("mem_grade"));
				

				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}//end:list
	
	public MemberVo2 selectOne(int mem_idx) {

		MemberVo2 vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from Member2 where idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정
			pstmt.setInt(1, mem_idx);

			//3.ResultSet 얻어오기
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo = new MemberVo2();
				//rs가 가리키는 레코드값을 vo에 넣는다

				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_email(rs.getString("mem_email"));
				vo.setMem_zipcode(rs.getString("mem_zipcode"));
				vo.setMem_addr(rs.getString("mem_addr"));
				vo.setMem_ip(rs.getString("mem_ip"));
				vo.setMem_regdate(rs.getString("mem_regdate"));
				vo.setMem_grade(rs.getString("mem_grade"));
				


			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}
}
