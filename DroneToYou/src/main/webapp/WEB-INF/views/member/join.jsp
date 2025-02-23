<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Drone To You</title>
</head>

<body>
    <form action="join.do" method="post" enctype="multipart/form-data" name="loginForm" onsubmit="" class="joinTable">
        <h3 class="joinTit">회원가입</h3>
        <table>
            <tbody>
                <tr>
                    <th class="icon"><img src="resources/img/id.png" alt="id"></th>
                    <td><input type="text" placeholder="ID" name="dm_id" maxlength="10" required><br></td>
                </tr>
                <tr>
                    <th class="icon"><img src="resources/img/password.png" alt="pw"></th>
                    <td><input type="password" placeholder="Password" name="dm_pw" maxlength="10" required></td>
                </tr>
                <tr>
                    <th class="icon"><img src="resources/img/check.png" alt="check"></th>
                    <td><input type="password" placeholder="Password Check" name="dm_pw_c" maxlength="10" required></td>
                </tr>

                <tr>
                    <th class="icon"><img src="resources/img/name.png" alt="name"></th>
                    <td><input type="text" placeholder="Name" name="dm_name" required><br></td>
                </tr>

                <tr>
                    <th class="icon"><img src="resources/img/phone.png" alt="phone"></th>
                    <td class="phoneJoin">
                    <input type="text" placeholder="***" name="phone1"  maxlength="3" required>
                    <span></span>
                    <input type="text" placeholder="****" name="phone2" maxlength="4" required>
                    <span></span>
                    <input type="text" placeholder="****" name="phone3" maxlength="4" required>
                    </td>
                </tr>

                <tr class="birth">
                    <th class="icon"><img src="resources/img/birth.png" alt="bith"></th>
                   <td>
                    <select name="y">
                        <c:forEach var="y" begin="${curYear-100}" end="${curYear}">
                           <option>${y}</option>
                        </c:forEach>
                     </select>년  &nbsp;&nbsp;&nbsp;&nbsp;
                     <select name="m2">
                        <c:forEach var="m" begin="1" end="12">
                           <option>${m}</option>
                        </c:forEach>
                     </select>월  &nbsp;&nbsp;&nbsp;&nbsp;
                     <select name="d">
                        <c:forEach var="d" begin="1" end="31">
                           <option>${d}</option>
                        </c:forEach>
                     </select>일
                   </td>
                  
                </tr>
                <tr>
                    <th class="icon"><img src="resources/img/email.png" alt="email"></th>
                    <td><input type="email" placeholder="Email" name="dm_email" required></td>
                </tr>
                <tr>
                    <th>프로필<img src="" alt="" class="photoArea"></th>
                    <td>
                    <label for="fileChoose">사진 선택하기</label>
                    <input type="file" name="dm_photo" style="border: none;" id="fileChoose" required><br>
                    </td>
                </tr>
        <tr>
        <td>        
            <button onclick="join()" class="joinBtn">회원가입</button>
        </td>
        </tr>
            </tbody>
        </table>
    </form>
</body>
</html>