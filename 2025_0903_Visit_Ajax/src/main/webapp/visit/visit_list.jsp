<%-- <%@page import="jakarta.servlet.jsp.tagext.Tag"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL Core : forEach.if.choose....  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- JSTL Functions : substring,indexOf,length.... -->
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap3.x ver -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



<style type="text/css">
#box {
	width: 600px;
	margin: auto;
	margin-top: 50px;
}

#title {
	text-align: center;
	font-weight: bold;
	font-size: 28px;
	color: rgb(51, 122, 183);
	text-shadow: 1px 1px 1px black;
}

#error_msg {
	text-align: center;
	color: red;
	font-size: 20px;
	font-weight: bold;
}

.common {
	border: 1px solid #dddddd;
	padding: 5px;
	margin-bottom: 5px;
	box-shadow: 1px 1px 1px #aaaaaa;
}

.content {
	min-height: 80px;
}
</style>
<script type="text/javascript">
	function del(f) {

		let idx = f.idx.value; //게시물번호
		let c_pwd = f.c_pwd.value.trim(); //확인비번 

		if (c_pwd == "") {
			alert("삭제할 게시물의 비밀번호를 입력하게요");
			f.c_pwd.value = "";
			f.c_pwd.focus();
			return;
		}
			
		//AJAX를 이용해 비밀번호를 체크하기
		$.ajax({
			
			url		:	"check_pwd.do",				//VisitCheckPwdAction//porm parameter  ->action //요청정보
			data	:	{"idx":idx,"c_pwd":c_pwd},  //data(parameter)//check_pwd.do?idx=5&c_pwd=1234//요청정보
			dataType:	"json",						//수신데이터 Type지정 할 수 있다.//수신정보 (받을때) type
			success	:	function(res_data){
				
				//res_data = {"result":true}or{"result":false}
				if(res_data.result==false){
					alert("삭제 비밀번호가 틀립니다")
					return;
				}
				
				//삭제진행
				//삭제 확인작업
				if (confirm("정말 삭제?할래?") == false) return;
				//삭제처리 요청 (서버에서 처리) 중간에 공백 있으면 안됌. =은 꼭 써야 하고.. 실수가 많음.. 
				location.href = "delete.do?idx=" + idx; //VisitDeleteAction

				
			},		//<success> 수신정보(받을때) type 
			error	: 	function name(err){
				alert(err.responseText); 
			}		//<error>  수신정보(받을때) type
		});
		
		
		
		
		

	}//end:del()
	
	function modify_form(f) {

		let idx = f.idx.value; //게시물번호
		let c_pwd = f.c_pwd.value.trim(); //확인비번 

		if (c_pwd == "") {
			alert("삭제할 게시물의 비밀번호를 입력하게요");
			f.c_pwd.value = "";
			f.c_pwd.focus();
			return;
		}
		
		//Ajax 이용
		$.ajax({
			
			url		:	"check_pwd.do",				//VisitCheckPwdAction//porm parameter  ->action //요청정보
			data	:	{"idx":idx,"c_pwd":c_pwd},  //data(parameter)//check_pwd.do?idx=5&c_pwd=1234//요청정보
			dataType:	"json",						//수신데이터 Type지정 할 수 있다.//수신정보 (받을때) type
			success	:	function(res_data){
				
				//res_data = {"result":true}or{"result":false}
				if(res_data.result==false){
					alert("수정비밀번호가 다륿니다?")
					return;
				}
				
			
				
			
				//수정폼 띄우기
				location.href = "modify_form.do?idx="+idx;
					
				},	
				//<success> 수신정보(받을때) type 
					error	: 	function name(err){
						alert(err.responseText); 
					}		//<error>  수신정보(받을때) type
				});
		
		

	}//end:modify_form()
</script>

</script>



</head>
<body>
	<div id="box">
		<h1 id="title">:::방명록:::</h1>

		<div style="margin-top: 30px; margin-bottom: 5px;">
			<input class="btn btn-primary" type="button" value="글쓰기"
				onclick="location.href='insert_form.do'">

		</div>

		<!-- 데이터 -->

		<!-- 데이터가 없을 경우 -->
		<c:if test="${empty list}">
			<div id="error_msg">등록된 게시물이 없습니다.</div>
		</c:if>

		<!-- for(VisitVo vo : list)동일함. -->
		<c:forEach var="vo" items="${ list }">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>
						<b>${vo.name}</b>님의 글
					</h4>
				</div>

				<!-- 내용 -->

				<div class="panel-body">
					<form class="form-inline">
						<input type="hidden" name="idx" value="${vo.idx}"> 

						<div class="common content">${vo.content }</div>
						<div class="common regdate">
							<%--
								       012345678901234567890
							regdate = "2025-09-01 11:08:15.0"
							 --%>

							<label>등록일자:</label>${ fn:substring(vo.regdate,0,16) } (${vo.ip })
						</div>
						<div class="common pwd">
							<label>비밀번호(${vo.pwd})</label><input class="form-control"
								type="password" name="c_pwd"> <input
								class="btn btn-info" type="button" value="수정"
									onclick = "modify_form(this.form);">
							<input	class="btn btn-danger" type="button" value="삭제"
								onclick="del(this.form);">



						</div>
					</form>

				</div>
			</div>

		</c:forEach>











	</div>
</body>
</html>