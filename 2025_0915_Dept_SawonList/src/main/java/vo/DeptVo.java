package vo;

import java.util.List;

public class DeptVo {
	
	//property or attribute memberfield라고도 부름.. 속성명. 
	int deptno;
	String dname;
	String loc;

	List<SawonVo> sa_list;

	
	//부서별 사원목록
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<SawonVo> getSa_list() {
		return sa_list;
	}

	public void setSa_list(List<SawonVo> sa_list) {
		this.sa_list = sa_list;
	}
	
}
