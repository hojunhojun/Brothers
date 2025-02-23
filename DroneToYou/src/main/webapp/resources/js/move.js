function joinGo() {
	location.href="join.go";
}

function logOut() {
	var really = confirm("로그아웃하시겠습니까?");
	if (really) {
		location.href = "logout.do";		
	}
}

function memberInfoGo() {
	location.href="member.info.go";
}

function bye() {
	var really = confirm("탈퇴하시겠습니까?");
	if (really) {
		location.href = "member.bye.do";	
	}
}

function c2cSaleChange() {
	alert("zz");
}

function c2cRentalChange() {
	alert("체인지2");
}

function c2cUpdateGo() {
	alert("업데이트버튼");
}

function c2cDeleteDo(no, page) {
	if (confirm("삭제하시겠습니까?")) {
		location.href="c2c.delete.do?dc_no=" + no + "&page=" + page;
	}
}

function goIndex() {
	location.href="index.go";
}

function tableClickTest(no) {
	alert(no);
}