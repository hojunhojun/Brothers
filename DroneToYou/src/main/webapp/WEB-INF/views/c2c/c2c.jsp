<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="dark"></div>
		<table id="topArea">
			<tr>
				<td class="c2cPhotoArea"></td>
				<td class="c2cTextArea">
					<p>Customer to Customer</p> <span></span>
					<p>회원끼리 드론을 공유하며 스마트한 연결을 만들어갑니다.</p>
				</td>
			</tr>
		</table>

		<table class="c2cBoxTbl">
			<tr>
				<td class="leftBox">
					<form action="c2c.search">
						<c:if test="${sessionScope.loginMember != null}">
							<table class="searchTbl">
								<tr>
									<td>
										<button>
											<img src="resources/img/search.png">
										</button> 
										<input name="search" placeholder="검색어를 입력해주세요">
									</td>
								</tr>
							</table>
						</c:if>
					</form>
				</td>

				<td class="middleBox">
					<button onclick="c2cSaleChange();">판매/구매</button>
					<button onclick="c2cRentalChange();">대여</button>
				</td>

				<td class="rightBox">
					<button onclick="c2cWrite();">글쓰기</button>
				</td>
			</tr>
		</table>

		<c:if test="${sessionScope.loginMember != null}">
			<form action="c2c.reg.do" method="post" enctype="multipart/form-data">
				<table class="writeBox">
					<tr>
						<th>게시글 작성</th>
						<td>
							<input name="token" value="${token}" type="hidden">
							<input type="radio" name="dc_cate" value="s">구매/판매 
							<input type="radio" name="dc_cate" value="l">대여
						</td>
						<td>
							제목 : 
							<input name="dc_title" type="text" placeholder="제목을 입력해주세요" required>
						</td>
						<td>내용 
							<textarea name="dc_txt" placeholder="내용을 입력해주세요" required></textarea>
						</td>
						<td>기간 
							<select name="y1">
								<c:forEach var="y" begin="${curYear}" end="${curYear+3}">
									<option>${y}</option>
								</c:forEach>
							</select>년 &nbsp;&nbsp;&nbsp;&nbsp; 
							<select name="m1">
								<c:forEach var="m" begin="1" end="12">
									<option>${m}</option>
								</c:forEach>
							</select>월 &nbsp;&nbsp;&nbsp;&nbsp; 
							<select name="d1">
								<c:forEach var="d" begin="1" end="31">
									<option>${d}</option>
								</c:forEach>
							</select>일
							<p style="display: inline-block; font-size: 28px;">&nbsp;&nbsp;~</p>
							<select name="y2">
								<c:forEach var="y" begin="${curYear}" end="${curYear+3}">
									<option>${y}</option>
								</c:forEach>
							</select>년 &nbsp;&nbsp;&nbsp;&nbsp; 
							<select name="m2">
								<c:forEach var="m" begin="1" end="12">
									<option>${m}</option>
								</c:forEach>
							</select>월 &nbsp;&nbsp;&nbsp;&nbsp; 
							<select name="d2">
								<c:forEach var="d" begin="1" end="31">
									<option>${d}</option>
								</c:forEach>
							</select>일
						</td>
						<td class="c2cPhotos"></td>
						<td>
							<label for="c2cImg">사진 등록</label>
						</td>
						<td>
							<input type="file" name="dc_photo1" id="c2cImg">
						</td>
						<td>
							<button type="submit">완료</button>
						</td>
						<td>
							<button onclick="cancleTbl();">취소</button>
						</td>
					</tr>
				</table>
			</form>
		</c:if>



		<c:forEach var="ccs" items="${c2cs}">
			<c:if test="${sessionScope.loginMember != null}">
				<form action="c2c.update.do" method="post" enctype="multipart/form-data">
					<table class="editBox">
						<tr>
							<th style="margin-left: 5px;">게시글 수정</th>
							<td>
								<input name="token" value="${token}" type="hidden">
								<input name="dc_no" value="${ccs.dc_no}" type="hidden"> 
								<input name="oldPhoto" value="${ccs.dc_photo1}" type="hidden">
							</td>
							<td>
								제목
								<input name="dc_title" type="text" placeholder="${ccs.dc_title}" required>
							</td>
							<td>
								내용 
								<textarea name="dc_txt" required></textarea>
							</td>
							<td>
								기간 
								<select name="y1">
									<c:forEach var="y" begin="${curYear}" end="${curYear+3}">
										<option>${y}</option>
									</c:forEach>
								</select>년 &nbsp;&nbsp;&nbsp;&nbsp; 
								<select name="m1">
									<c:forEach var="m" begin="1" end="12">
										<option>${m}</option>
									</c:forEach>
								</select>월 &nbsp;&nbsp;&nbsp;&nbsp;
								<select name="d1">
									<c:forEach var="d" begin="1" end="31">
										<option>${d}</option>
									</c:forEach>
								</select>일
								<p style="display: inline-block; font-size: 28px;">&nbsp;&nbsp;~</p>
								<select name="y2">
									<c:forEach var="y" begin="${curYear}" end="${curYear+3}">
										<option>${y}</option>
									</c:forEach>
								</select>년 &nbsp;&nbsp;&nbsp;&nbsp; 
								<select name="m2">
									<c:forEach var="m" begin="1" end="12">
										<option>${m}</option>
									</c:forEach>
								</select>월 &nbsp;&nbsp;&nbsp;&nbsp; 
								<select name="d2">
									<c:forEach var="d" begin="1" end="31">
										<option>${d}</option>
									</c:forEach>
								</select>일
							</td>
							<td class="c2cEditPhotos"></td>
							<td>
								<label for="c2cEditImg">사진 등록</label>
							</td>
							<td>
								<input type="file" name="dc_photo1" class="c2cEditImg">
							</td>
							<td>
								<button type="submit">수정</button>
							</td>
							<td>
								<button onclick="cancleEditTbl();">취소</button>
							</td>
						</tr>
					</table>
				</form>
			</c:if>
			<table class="c2cTable">
				<tr>
					<td>
						<table class="tableTopArea">
							<tr>
								<td>작성자 : ${ccs.dc_writer}</td>
								<td>
									<c:if test="${sessionScope.loginMember.dm_id == ccs.dc_writer}">
										<button onclick="c2cUpdateGo();">수정</button>
										<button onclick="c2cDeleteDo(${ccs.dc_no}, ${page});">삭제</button>&nbsp;&nbsp;&nbsp;&nbsp;
                     				</c:if>
                     				<c:if test="${ccs.dc_cate == \"s\"}">판매</c:if> 
                     				<c:if test="${ccs.dc_cate == \"l\"}">대여</c:if>
                     			</td>
							</tr>
							<tr>
								<td>
									<fmt:formatDate value="${ccs.dc_date}" pattern="yyyy년 MM월 dd일(E)" /> 등록
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr class="tableBottomArea">
					<td onclick="openClick(this);">
						<img src="resources/img/${ccs.dc_photo1}" alt="게시물 이미지">
					</td>
					<td onclick="openClick(this);">${ccs.dc_txt}</td>
					<td>
						<c:if test="${sessionScope.loginMember.dm_id != ccs.dc_writer}">
							<button class="reqBtn">요청보내기</button>
						</c:if>
					</td>
					<td class="reqBox">
						<c:if test="${sessionScope.loginMember.dm_id != ccs.dc_writer}">
							<table class="reqTbl">
								<tr>
									<td>요청 보내기
										<form action="c2c.submit.request.do">
										<textarea name="dcr_txt" placeholder="내용을 입력해주세요" required></textarea>
									</td>
									<td>
										<input name="token" value="${token}" type="hidden">
										<input name="dcr_no" value="${ccs.dc_no}" type="hidden">
										<input name="dcr_writer" value="${ccs.dc_writer}" type="hidden">
										<button type="submit">완료</button>
										</form>
									</td>
									<td>
										<button onclick="cancleReq()" class="reqCancleBtn">취소</button>
									</td>
								</tr>
							</table>
						</c:if>
					</td>
				</tr>
				<tr>
					<td>
						<table class="c2cInfo">
		        			<caption>상세보기</caption>
            				<tr>
                  				<td>제목:</td>
                  				<td>${ccs.dc_title }</td>
           					</tr>
            				<tr>
               					<td>작성자:</td>
               					<td>${ccs.dc_writer}</td>
            				</tr>
            				<tr>
              					<td>기간:</td>
              					<td>${ccs.dc_interval }</td>
            				</tr>
           		 			<tr>
              					<td>내용</td>
              					<td>${ccs.dc_txt }</td>
            				</tr>
            				<tr>
              					<td>사진</td>
              					<td>
                 					<img src="resources/img/${ccs.dc_photo1 }">
              					</td>
            				</tr> 
            				<tr>
               					<td>
               						<button onclick="cancleInfo(this)">닫기</button>
               					</td>
            				</tr>    
      					</table>
					</td>
				</tr>
			</table>
		</c:forEach>

		<table class="pageNum">
			<tr>
				<td align="center" colspan="2" style="padding: 5px;">
					<c:forEach var="p" begin="1" end="${pageCount}"> &nbsp;
						<a href="c2c.page.change?page=${p}">${p}</a>
            		</c:forEach>
            	</td>
			</tr>
		</table>
</body>
</html>