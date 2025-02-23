<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
<table class="partInquiryArea">
<tr>
	<td class="partInquiryPhotoArea">
	</td>
	<td class="partInquiryTextArea">
		<p>
		부품문의
		</p>
		<span></span>
		<p>
		드론에 부품에 관련한 문의사항을 입력해주세요
		</p>
	</td>
</tr>
</table>
<form action="custom.partin.submit" method="post" enctype="multipart/form-data">
<table class="partContainer">
    <caption>부품문의 사항</caption>
    <tr class="inputGroup">
	    <td>
	     	<label for="purpose"><i class="fas fa-tools"></i> 용도</label>
	     	<input type="text" id="purpose" name="dp_purpose" placeholder="용도를 입력해 주세요." required>
	    </td>
    </tr>
    <tr class="inputGroup">
   		<td>
   			<label for="model"><i class="fas fa-cogs"></i>부착될 기종</label>
        	<input type="text" id="model" name="dp_model" placeholder="기종을 입력해 주세요." required>
    	</td>
    </tr>
    <tr class="inputGroup">
	    <td>
	    	<label for="color"><i class="fas fa-palette"></i> 색깔</label>
	        <input type="text" id="color" name="dp_color" placeholder="색깔을 입력해 주세요." required>    
	    </td>
    </tr>
    <tr class="inputGroup">
	    <td>
	        <label for="drawing"><i class="fas fa-drafting-compass"></i> 도면 (선택)</label>
	        <input type="file" id="drawing" name="dp_drawing" accept=".png, .jpg, .jpeg, .pdf">
	    </td>
    </tr>
    <tr class="inputGroup">
	    <td>
	        <label for="quantity"><i class="fas fa-layer-group"></i> 갯수</label>
	        <input type="number" id="quantity" name="dp_quantity" placeholder="갯수를 입력해 주세요." required>
	    </td>
    </tr>
    <tr class="inputGroup">
	    <td>
	        <label for="material"><i class="fas fa-box-open"></i> 재질</label>
	        <input type="text" id="material" name="dp_material" placeholder="재질을 입력해 주세요." required>
	    </td>
    </tr>

    <tr class="inputGroup">
	    <td>
	        <label for="details">기타</label>
	        <input id="details" name="dp_details" placeholder="기타 내용을 입력해 주세요." required></input>
	    </td>
    </tr>
    
    <tr class="inputGroup">
        <td><button type="submit" class="submitBtn">작성하기</button></td>
        </form>
    </tr>
    <tr class="inputGroup">
        <td><button class="cancelBtn" onclick="goIndex();">취소하기</button></td>
    </tr>
</table>
</body>
</html>