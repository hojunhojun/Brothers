<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<div class="logined">
	<form action="logout.do">
		<table id="loginedTb">
			<tbody>
				<tr>
					<td align="center" rowspan="2"><img alt=""
						src="resources/img/${sessionScope.loginMember.dm_photo }"></td>
					<td>${sessionScope.loginMember.dm_id } 님안녕하세요</td>
				</tr>
				<tr>
					<td>
						<button>로그아웃</button>
						<button onclick="memberInfoGo();">회원정보</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</html>