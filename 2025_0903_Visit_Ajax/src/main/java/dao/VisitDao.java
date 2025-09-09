package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.VisitVo;
import service.DBService;

//DAO(Data Access Object)
//:CRUD처리하는 객체 (생성 수정 삭제 )
public class VisitDao {

	// single-ton
	static VisitDao single = null;

	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();

		return single;
	}

	public VisitDao() {

	}

	// 조회
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit order by idx desc";
		// String sql = "select * from dept where id=? and pwd=?"; <- 보안성이 좋음.
		try {

			// 1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			// 3. ResultSet 얻어오기
			rs = pstmt.executeQuery();

			// 4. 레코드값을 VO포장후 list넣는다
			while (rs.next()) {

				VisitVo vo = new VisitVo();
				// rs가 가르키는 레코드값을 vo에 넣습니다.
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

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
	}

	public int insert(VisitVo vo) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		// 1 2 3 4 <-pstmt parameter index
		String sql = "insert into visit values( seq_visit_idx.nextVal , ? , ?, ? , ? ,sysdate )";

		try {
			// 1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			// 3.PrepareStatement Parameter설정
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());

			// 4.DB Insert
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res; // 처리된 행수를 리턴 받음.
	}

	// 삭제
	public int delete(int idx) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		// 1<-pstmt parameter index
		String sql = "delete from visit  where idx=?";

		try {
			// 1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			// 3.PrepareStatement Parameter설정
			pstmt.setInt(1, idx);

			// 4.DB delete
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}

	// idx에 해당하는 1건 데이터 조회
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 1<-pstmt parameter index
		String sql = "select * from visit where idx=?";

		try {
			// 1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			// 3.PrepareStatement Parameter설정
			pstmt.setInt(1, idx);

			// 3.ResultSet 얻어오기
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo = new VisitVo();
				// rs가 가리키는 레코드값을 vo에 넣는다
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

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

	// 수정
	public int update(VisitVo vo) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		//									1		  2   	3	4			 5<=pstmt parameter index
		String sql = "update visit set name=?,content=?,pwd=?,ip=?  where idx=?";

		try {
			// 1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			// 3.PrepareStatement Parameter설정
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			
			pstmt.setInt(5, vo.getIdx());
			

			// 4.DB update
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}
}
