<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join.do" method="post" enctype="multipart/form-data">
		id : <input name="dm_id"> <p>
		pw : <input name="dm_pw"> <p>
		pw확인 : <input name="dm_pwc"> <p>
		이름 : <input name="dm_name"> <p>
		phone : 010-<input name="phone1">-<input name="phone2"> <p>
		주민번호 : <input name="dm_jumin1" class="i2" placeholder="XXXXXX" maxlength="6">
		&nbsp;-&nbsp;<input name="dm_jumin2" class="i3" placeholder="X" maxlength="1">XXXXXX <p>
		이메일 : <input name="dm_email"> <p>
		Photo : <input name="dm_photo" type="file"> <p>
		<button>가입</button>
	</form>
</body>
</html>