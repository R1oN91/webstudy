package db.vo;

	//VO(Value Object) : 1개의 레코드를 담는 객체
	//3위일체
	//VO property명 == DB Column명 == 입력창의 폼의 parameter명
public class DeptVo {
	
	//property, membmer field, 변수
	int 	deptno;
	String 	dname;
	String 	loc;
	
	
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
	
	 
	
}
