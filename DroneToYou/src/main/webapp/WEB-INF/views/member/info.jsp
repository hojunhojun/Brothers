<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drone To You</title>
</head>
<body>
	<table id="infoArea">
		<form action="member.info.update.go" onsubmit="return memberInfoCheck();" method="post" > 
			<h1>마이페이지</h1>
			<tr class="profile">
				<th>프로필 사진 :</th>
				<td class="td1">
					<img src="resources/img/${sessionScope.loginMember.dm_photo}"><br>
				</td>
			</tr>
			<tbody class="info_left">
				<tr>
					<th>${sessionScope.loginMember.dm_name }님 안녕하세요</th>
				</tr>
				<tr>
					<th><img src="resources/img/id.png" alt=""></th>
					<td>${sessionScope.loginMember.dm_id}</td>
				</tr>
				<tr>
					<th><img src="resources/img/password.png" alt=""></th>
					<td class="td1">
						******
					</td>
				</tr>
			</tbody>

			<tbody class="info_right">
				<tr>
					<th><img src="resources/img/birth.png" alt=""></th>
					<td class="td1">
						<fmt:formatDate value="${sessionScope.loginMember.dm_birthday}" pattern="yyyy년 MM월 dd일(E)" />
					</td>
				</tr>
				<tr>
					<th><img src="resources/img/phone.png" alt=""></th>
					<td class="td1">
						${sessionScope.loginMember.dm_phone}
					</td>
				</tr>
				<tr>
					<th><img src="resources/img/email.png" alt=""></th>
					<td class="td1">
						${sessionScope.loginMember.dm_email}
					</td>
				</tr>
			</tbody>
			<tr>
				<td colspan="2">
					<button>수정</button>
				</td>
		</form>
			</tr>
	</table>
</html>