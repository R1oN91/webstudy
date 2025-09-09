package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {
	
	

	static {
		
		//웹프로그램에서는 안해도 된다.
		//ojdbc60.jar later에서도 안해도 된다. 
		//메모리에 Load해 놓는다. 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1.Connection을 얻어오기 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "test";
		String password = "test";
		Connection conn = DriverManager.getConnection(url,username,password);
		
		
		
		System.out.println("---success connection---");
		//Statement : SQL명령 처리 객체 ( DDL / DML / DCL...)
		Statement stmt = conn.createStatement();
		//executeUpdate(sql)	: select명령외의 모든명령 때 사용.
		//executeQuery(sql)		: select 명령 때 사용. 
		
		//DDL
		//String sql = "create table t100(no int)";
		//String sql = "drop table t100";
		
		//DML(insert/update/delete)
		//String sql = "insert into dept values(60,'기획실','606')";
		//String sql = "update dept set loc = '600' where deptno=60";
		//String sql = "delete from dept where deptno=60";		
		//int res = stmt.executeUpdate(sql);
		//System.out.println("---success statement---");
		
		//3.ResultSet : 결과행 처리객체 (조회 : select)
		//String sql = "select * from dept";
		String sql = "select deptno as no, loc,dname from dept";
		
				
		ResultSet rs = stmt.executeQuery(sql);
		
		//전체조회 while(몇번 반복할지 모를 때 사용하는 반복)
		while(rs.next()) { //rs.next()한 위치가 데이터 영역이냐?
			
			//1번째 방법
			
			//현재 rs위치의(레코드) 필드값 읽어오기 . //날짜정보도 getString으로 불러와야 함. 
			int deptno 		= rs.getInt("no");
			String dname	= rs.getString("dname");
			String loc		= rs.getString("loc");
			
			//2번째 방법 (편하지만 많이 위험함)
			
//			int deptno 		= rs.getInt(1);
//			String dname	= rs.getString(2);
//			String loc		= rs.getString(3);
			
			//읽어온값 출력
			System.out.printf("[%d-%s-%s]\n",deptno,dname,loc);
			
		} 
		 
		//닫기(열린역순)
		rs.close();
		stmt.close();//2
		conn.close();//1

	}

}
