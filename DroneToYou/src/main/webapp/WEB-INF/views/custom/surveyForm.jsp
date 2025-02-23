<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/surveyForm.css">
</head>
<body>
<table class="surveyArea">
<tr>
	<td class="surveyPhotoArea">
	</td>
	<td class="surveyTextArea">
		<p>
		맞춤제작
		</p>
		<span></span>
		<p>
		나만의 드론이 만들어지는 과정
		</p>
	</td>
</tr>
</table>
<form action="custom.survey.submit" method="post" enctype="multipart/form-data">
	<table class="surveyContainer">
		<caption>맞춤제작 요청사항</caption>
	        <tr class="form-group">
	        	<td>
		            <label for="wingSpecification">1. 날개 규격:</label>
		            <input type="text" id="wingSpecification" name="ds_wingsize" required>
	            </td>
	        </tr>
	        <tr class="form-group">
	        	<td>
		            <label for="wingCount">2. 날개 개수:</label>
		            <input type="number"  name="ds_wingcount" required>
	           	</td>
	        </tr>
	        <tr class="form-group">
	        	<td>        
		            <label for="purpose">3. 사용 목적:</label>
		            <input name="ds_purpose" required></input>
	            </td>
	        </tr>
	        <tr class="form-group">
	        	<td>
		            <label for="requiredFeatures">4. 필요한 기능:</label>
		            <input  name="ds_required" required></input>
	            </td>
	        </tr>
	        <tr class="form-group">
	        	<td>        
		            <label for="batteryCapacity">5. 배터리 용량:</label>
		            <input type="text" name="ds_battery" required>
	            </td>
	        </tr>
	        <tr class="form-group">
	        	<td>        
		            <label for="bodySize">6. 바디 크기:</label>
		            <input type="text" name="ds_bodysize" required>
	            </td>
	        </tr>
	        <tr class="form-group">
	        	<td>        
		            <label for="blueprint">7. 설계 도면(선택):</label>
		            <input type="file" name="ds_blueprint">
	            </td>
	        </tr>
	        <tr class="form-group">
	        	<td>
		            <label for="painting">8. 도색:</label>
		            <input type="text" name="ds_painting" required>
	            </td>
	        </tr>
	        <tr>
		        <td>
		        	<button type="submit">제출</button>
					</form>
		        </td>
	        </tr>
	       	<tr>
		        <td>
		        	<button onclick="goIndex();">취소</button>
		        </td>
	        </tr>
	</table>
</body>
</html>