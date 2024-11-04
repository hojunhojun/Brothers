<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DroneToYou</title>
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/mainPage.css">
<link rel="stylesheet" href="resources/css/login.css">
<link rel="stylesheet" href="resources/css/logined.css">
<link rel="stylesheet" href="resources/css/animationKey.css">
<link rel="stylesheet" href="resources/css/nav.css">
<script type="text/javascript" src="resources/js/move.js"></script>
</head>
<body>
	<section id="dtyMenu">
		<div class="menu">
			<menu class="mBottom">
				<div class="conWrap">
					<div class="logo">
						<a href=""><img src="resources/img/droneLogo.png" alt=""></a>
					</div>

					<div class="navWrap">
						<div class="innerNav">
							<nav>
								<ul>
									<li class="menuDetail"><a href="#">상품</a>
										<ul class="hiddenMenu">
											<li><a href="">판매</a></li>
											<li><a href="">대여</a></li>
										</ul></li>

									<li class="menuDetail"><a href="#">커스텀드론</a>
										<ul class="hiddenMenu">
											<li><a href="#">커스텀제작</a></li>
										</ul></li>

									<li class="menuDetail"><a href="#">C2C</a>
										<ul class="hiddenMenu">
											<li><a href="#">게시판</a></li>
										</ul></li>

									<li class="menuDetail"><a href="#">고객센터</a>
										<ul class="hiddenMenu">
											<li><a href="#">부품문의</a></li>
											<li><a href="#">기타문의</a></li>
										</ul></li>
								</ul>
							</nav>
						</div>
					</div>

					<div class="right">
						<div class="cart">
							<a href="#"><img src="resources/img/shoppingCart.png" alt=""></a>
						</div>

						<jsp:include page="${loginPage}"></jsp:include>

					</div>

				</div>
			</menu>
		</div>
	</section>

	<div>
		<jsp:include page="${contentPage}"></jsp:include>
	</div>

	<footer>
		<p>만든이:이호준/조현수/김윤희/조상훈/이상민/소현수/정의천</p>
	</footer>

	<script src="resources/js/mainpage.js">
		
	</script>
</body>
</html>