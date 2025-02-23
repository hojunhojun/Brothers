<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DroneToYou</title>
</head>
<body>
	<table id="loginedTb">
        <tbody>
            <tr>
                <td align="center" rowspan="2"><img alt="" src="resources/img/${sessionScope.loginMember.dm_photo }"></td>
                <td>${sessionScope.loginMember.dm_name } 님안녕하세요</td>
            </tr>
            <tr>
                <td>
                    <button onclick="logOut();">로그아웃</button>
                </td>
        		<td>
           			 <button onclick="memberInfoGo();">회원정보</button>
        		</td>
            </tr>
        </tbody>
	</table>
</body>
</html>