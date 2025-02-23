<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="resources/css/info.css">
	<title>Drone To You</title>
</head>
<body>
	<table id="infoUpdateTable">
	<form action="member.info.update.do" onsubmit="return memberUpdateCheck();" method="post" enctype="multipart/form-data" id="infoUpdateArea">
		<h1>마이페이지</h1>
			<tr class="profileUpdate">
				<th>프로필 사진 </th>
				<td class="td1">
					<img src="resources/img/${sessionScope.loginMember.dm_photo}" class="photoArea"><br>
					<label for="textType">사진 선택</label>
					<input name="dm_photo" type="file" class="textType" id="textType">
				</td>
			</tr>
			<tbody class="infoUpdate_left">
				<tr>
		
				</tr>
				<tr>
					<th><img src="resources/img/id.png" alt=""></th>
					<td>ID : ${sessionScope.loginMember.dm_id}</td>
				</tr>
				<tr>
					<th><img src="resources/img/password.png" alt="pw"></th>
					<td class="td1">
						<input value="${sessionScope.loginMember.dm_pw}" type="password" placeholder="Password" name="dm_pw" maxlength="10">
					</td>
				</tr>
				<tr>
					<th><img src="resources/img/check.png" alt="check"></th>
					<td class="td1">
						<input type="password" placeholder="Password Check" name="dm_pw_c" maxlength="10">
					</td>
				</tr>
			</tbody>

			<tbody class="infoUpdate_right">
				<tr>
					<th><img src="resources/img/name.png" alt="name"></th>
					<td class="td1">
						<input value="${sessionScope.loginMember.dm_name}" type="text" placeholder="Name" name="dm_name"> 
					</td>
				</tr>
				<tr>
					<th><img src="resources/img/birth.png" alt="bith"></th>
					<td class="td1">
						<fmt:formatDate value="${sessionScope.loginMember.dm_birthday}" pattern="yyyy년 MM월 dd일(E)"/> 
					</td>
				</tr>
				<tr>
					<th><img src="resources/img/phone.png" alt="phone"></th>
					<td class="td1 phoneNum">
						<input value="${phone1}" type="tel" placeholder="***" name="phone1" pattern="\d*">
						-
						<input value="${phone2}" type="tel" placeholder="****" name="phone2" pattern="\d*">
						-
						<input value="${phone3}" type="tel" placeholder="****" name="phone3" pattern="\d*">
					</td>
				</tr>
				<tr>
					<th><img src="resources/img/email.png" alt="email"></th>
					<td class="td1">
						<input value="${sessionScope.loginMember.dm_email}" type="email" placeholder="Email" name="dm_email" pattern="^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}">
					</td>
				</tr>
			</tbody>
			<tr>
				<td colspan="2">
					<button>저장</button>
					</td>
	</form>
				<tr>
				<td>
					<button onclick="bye();">탈퇴</button>
				</td>
			</tr>
		</table>
</body>


</html>