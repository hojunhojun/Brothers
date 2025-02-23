<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ko">
<head>
    <title>DroneToYou</title>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/mainPage.css">
    <link rel="stylesheet" href="resources/css/login.css">
    <link rel="stylesheet" href="resources/css/logined.css">
    <link rel="stylesheet" href="resources/css/animationKey.css">
    <link rel="stylesheet" href="resources/css/nav.css">
    <link rel="stylesheet" href="resources/css/join.css">
    <link rel="stylesheet" href="resources/css/info.css">
    <link rel="stylesheet" href="resources/css/infoUpdate.css">
    <link rel="stylesheet" href="resources/css/productDetail.css">
    <link rel="stylesheet" href="resources/css/products.css">
    <link rel="stylesheet" href="resources/css/c2c.css">
    <link rel="stylesheet" href="resources/css/inquiry.css">
    <link rel="stylesheet" href="resources/css/surveyForm.css">
    <link rel="stylesheet" href="resources/css/partInquiry.css">
    <link rel="stylesheet" href="resources/css/cart.css">
    <script src="resources/js/cart.js"></script>
    <script src="resources/js/products.js"></script>
    <script src="resources/js/move.js"></script>
    <script src="resources/js/mainPage.js"></script>
    <script src="resources/js/infoUpdate.js"></script>
    <script src="resources/js/join.js"></script>
    <script src="resources/js/productDetail.js"></script>
    <script src="resources/js/review.js"></script>
    <script src="resources/js/c2c.js"></script>
    <script src="resources/js/inquiry.js"></script>
</head>

<body>
    <section id="dtyMenu">
        <div class="menu">
            <menu class="mBottom">
                <div class="conWrap">
                    <div class="logo">
                        <a href="index.go"><img src="resources/img/droneLogo.png" alt=""></a>
                    </div>

                    <div class="navWrap">
                        <div class="innerNav">
                            <nav>
                                <ul>
                                    <li class="menuDetail">
                                        	상품
                                        <ul class="hiddenMenu">
                                            <li><a href="product.sale.go">구매</a></li>
                                            <li><a href="product.rental.go">대여</a></li>
                                        </ul>
                                    </li>

                                    <li class="menuDetail">
                                        	맞춤제작
                                        <ul class="hiddenMenu">
                                            <li><a href="custom.survey.go">맞춤제작</a></li>
                                            <li><a href="custom.partin.go">부품문의</a></li>
                                        </ul>
                                    </li>

                                    <li class="menuDetail">
                                        	C2C
                                        <ul class="hiddenMenu">
                                            <li><a href="c2c.go">대여</a></li>
                                            <li><a href="c2c.go">구매&판매</a></li>
                                        </ul>
                                    </li>

                                    <li class="menuDetail">
                                        	고객센터
                                        <ul class="hiddenMenu">
                                            <li><a href="inquiry.go">문의하기</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>

                    <div class="right">
                        <div class="cart">
                            <a href="cart.go"><img src="resources/img/shoppingCart.png" alt=""></a>
                        </div>
                              <jsp:include page="${loginPage}"></jsp:include>
   
                    </div>

                </div>
            </menu>
        </div>
    </section>

        <jsp:include page="${contentPage}"></jsp:include>
  
    <footer align="center">
        <p>만든이:이호준/조현수/김윤희/조상훈/이상민/소현수/정의천</p>
        <p>Tel : 010-4104-9936</p>
        <p>Phone : 010-8651-9936</p>
    </footer>


</body>
</html>
