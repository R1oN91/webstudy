package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import db.vo.MemberVo;
import service.MyBatisConnector;

public class MemberDao {

	
	SqlSessionFactory factory;
	
	//single-ton
	static MemberDao single = null;

	public static MemberDao getInstance() {

		if (single == null)
			single = new MemberDao();

		return single;
	}

	private MemberDao() {

		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	// 조회
	public List<MemberVo> selectList() {

		List<MemberVo> list = null;

		//1.작업객체 얻어온다
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행                 "namespace.mapper_id"
		list = sqlSession.selectList("member.member_list");
		
		//3.닫기
		sqlSession.close();

		return list;
	}
	
	// mem_idx -> selectOne
	public MemberVo selectOne(int mem_idx) {

		MemberVo vo = null;
		//1.작업객체 얻어온다
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행                 "namespace.mapper_id"
		vo = sqlSession.selectOne("member.member_one_idx", mem_idx);
		
		//3.닫기
		sqlSession.close();
		

		return vo;
	}
	
	// mem_id -> selectOne
	public MemberVo selectOne(String mem_id) {

		MemberVo vo = null;
		//1.작업객체 얻어온다
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행                 "namespace.mapper_id"
		vo = sqlSession.selectOne("member.member_one_id", mem_id);
		
		//3.닫기
		sqlSession.close();
		

		return vo;
	}

	// 추가
	public int insert(MemberVo vo) {

		int res = 0;
		
		//1.작업객체 얻어온다
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행                 "namespace.mapper_id"
		res = sqlSession.insert("member.member_insert", vo);
		
		//3.닫기
		sqlSession.close();
		

		return res;
	}

	//삭제
	public int delete(int mem_idx) {

		int res = 0;

		//1.작업객체 얻어온다
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행                 "namespace.mapper_id"
		res = sqlSession.delete("member.member_delete", mem_idx);
		
		//3.닫기
		sqlSession.close();

		return res;
	}

	public int update(MemberVo vo) {

		int res = 0;

		//1.작업객체 얻어온다
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행                 "namespace.mapper_id"
		res = sqlSession.update("member.member_update", vo);
		
		//3.닫기
		sqlSession.close();

		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
