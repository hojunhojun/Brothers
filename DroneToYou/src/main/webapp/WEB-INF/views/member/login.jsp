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
 <table class="loginTable">
     <form action="login.do" method="post" name="loginForm" onsubmit="">
         <tbody>
             <tr>
                 <td><i class="id_icon"></i><input type="text" placeholder="Username" name="dm_id"></td>
             </tr>

             <tr>
                 <td><i class="pw_icon"> </i> <input type="password" placeholder="Password" name="dm_pw"></td>
             </tr>
         </tbody>
         <tr>
             <td>
                 <button>로그인</button>
             </td>
         </tr>
     </form>
     <tr>
         <td>
             <button type="button" onclick="joinGo();">회원가입</button>
         </td>
     </tr>
 </table>
</body>
</html>