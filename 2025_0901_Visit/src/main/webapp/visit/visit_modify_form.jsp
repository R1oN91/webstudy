<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap3.x ver -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
#box {
	width: 600px;
	margin: auto;
	margin-top: 100px;
}

textarea {
	resize: none;
}

th {
	vertical-align: middle ! important;
}
</style>

<script type="text/javascript">
	function send(f) {
		let name = f.name.value.trim();
		let content = f.content.value.trim();
		let pwd = f.pwd.value.trim();

		if (name == "") {

			alter("이름을 입력하세요!")
			t.name.value = "";
			t.name.focus();

			return;
		}

		f.action = "modify.do"; //VisitModifyAction

		if (content == "") {

			aleert("내용을 입력하세요!")
			t.content.value = "";
			t.content.focus();

			return;
		}

		if (pwd == "") {

			aleert("비밀번호를 입력하세요")
			t.pwd.value = "";
			t.pwd.focus();

			return;
		}

		//수정확인
		if (confirm("정말 수정하시겠슴?") == false) {

			//자신의 페이지를 다시 호출 한다. 
			location.href = "";//이동페이지 정보를 생략하면 자신의 페이지를 다시 호출함. (refresh효과가 있다.)

			return;
		}
		//전송대상
		f.action = "insert.do"//VisitINSERTAction

		//전송
		f.submit();

	}//end:send()
</script>
</head>
<body>
	<form>
		<input type="hidden" name="idx" value="${vo.idx}">

		<div id="box">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>:::수정폼:::</h4>
				</div>
				<div class="panel-body">

					<table class="table">
						<tr>
							<th>작성자</th>
							<td><input class="form-control" name="name"
								value="${vo.name}"></td>
						</tr>

						<tr>
							<th>내용</th>
							<td>
								<!-- <textarea>는 무조건 한줄로 작성해야 함. 엔터 치면 안돼고 중간에 공백 있으면 안됌.  --> <textarea
									rows="5" cols="" class="form-control" name="content">${vo.content}</textarea>
							</td>
						</tr>

						<tr>
							<th>비밀번호</th>
							<td><input class="form-control" type="password" name="pwd"
								value="${vo.pwd}"></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input class="btn btn-info"
								type="button" value="목록보기" onclick="location.href='list.do'">
								<input class="btn btn-info" type="button" value="수정하기"
								onclick="send(this.form);"></td>

						</tr>

					</table>

				</div>
			</div>

		</div>
	</form>

</body>
</html>