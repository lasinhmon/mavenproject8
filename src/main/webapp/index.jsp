<%-- 
    Document   : tam
    Created on : Feb 27, 2023, 7:39:43 PM
    Author     : lasin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Charonbus</title>
    <!-- Font Awesome -->

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <!-- Customizer -->

    <!-- Your custom styles (optional) -->
    <link href="resources/css/style.css" rel="stylesheet">
    </head>

    <body>
	<%
	
        session.invalidate();
	%>
    <div class="al">
        <div class="header"><!-- Toan bo -->
            <div class="flex" id="head-top">
                <div class="social-icon" width="34px" height="34px">
                    <ul class="social">

                        <a class="fb-ic" href="https://www.facebook.com/truong.vu13/">
                            <i class="fa fa-facebook"> </i>
                        </a>
                        <a class="gplus-ic">
                            <i class="fa fa-google-plus"> </i>
                        </a>
                        <a class="tw-ic">
                            <i class="fa fa-twitter"> </i>
                        </a>
                    </ul>
                </div>
                <div class="account" width="34px" height="34px">
                    <button class="dropdown_button">Tài khoản</button>
                    <div class="dropdown_menu hide">
                        <a class="btn_dangnhap">Đăng nhập</a>
                        <a>Thoát</a>
                    </div>
                </div>
            </div>
            <div id="head-bot wall-paper" width="34px" height="34px">
                <div class="nav-container ">
                    <div id="nav" class="link"><img class="icon" src="resources/img/icon/icon3.png"></div>
                    <div id="nav" class="link">
                        <a href="index.jsp">TRANG CHU</a>
                    </div>
                    <div id="nav" class="link"><a href="index.jsp">LỊCH TRÌNH</a></div>
                    <div id="nav" class="link"><a href="index.jsp">HÓA ĐƠN</a></div>
                    <div id="nav" class="link"><a href="index.jsp">LIÊN HỆ</a></div>
                    <div id="nav" class="link"><a href="index.jsp">TUYỂN DỤNG</a></div>
                </div>
            </div>
        </div>
        <div class="mider"><!-- mid -->
            <div class="top-ticket">
                <img src="resources/img/wall/ho-tuyen-lam.jpg" height="400" width="1517px">
            </div>
            <form name="homeform" action="HomeControl" method="post" onSubmit="return validateForm(event);">
            <div class="book-ticket">
                <div class="roundtrip">
                    <input type="radio" id='radio1' name="gendar-trip" checked="checked" value="1">
                    <label style="font-size:20px;">1 chiều</label>
                    <input type="radio" id='radio2' name="gendar-trip" value="2">
                    <label style="font-size:20px;">2 chiều</label>
                    
                </div>
                <div class="booking-box">
                    <div class="place-select">
                        <div class="place-select-from">
                            <label class="title-from">Điểm đi</label>
                            <input class="place-to" type="text" id="placeto" name="placeto" value="" required></input>
                            <div class="data-list-to hide">
                                <ul class="place-list">
                                    <li class="place-list-item">
                                        <button class="place-item" id="to" onclick="ChoosePlaceTo(this)">TPHCM</button>
                                    </li>
                                    <li class="place-list-item">
                                        <button class="place-item" id="to" onclick="ChoosePlaceTo(this)">BaoLoc</button>
                                    </li>
                                    <li class="place-list-item">
                                        <button class="place-item" id="to" onclick="ChoosePlaceTo(this)">DaLat</button>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <img class="exchange-arrow" src="resources/img/icon/transfer.png">
                        <div class="place-select-from">
                            <label class="title-from">Điểm đến</label>
                            <input class="place-from" type="text" id="placefrom" name="placefrom" value="" required></input>
                            <div class="data-list-from hide">
                                <ul class="place-list">
                                    <li class="place-list-item">
                                        <button class="place-item" id="from" 
                                            onclick="ChoosePlaceFrom(this)">TPHCM</button>
                                    </li>
                                    <li class="place-list-item">
                                        <button class="place-item" id="from" 
                                            onclick="ChoosePlaceFrom(this)">BaoLoc</button>
                                    </li>
                                    <li class="place-list-item">
                                        <button class="place-item" id="from" 
                                            onclick="ChoosePlaceFrom(this)">DaLat</button>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
					
                    <div class="date-select">
                        <div class="place-select-from">
                            <label class="title-from">Ngày đi</label>
                            
                                <div class="sd-container">
                                    <input class="sd" type="date"  id="todate" name="todate" onchange="TDate()"
                                        required />
                                    <span class="open-button">
                                        <button type="button">📅</button>
                                    </span>
                                </div>                           
                        </div>
                        <div class="place-select-from">
                            <label class="title-from">Ngày về</label>
                            
                                <div class="sd-container1 hide">
                                    <input class="sd" type="date" id="fromdate" name="fromdate" onchange="FDate()" />
                                    <span class="open-button">
                                        <button type="button">📅</button>
                                    </span>
                                </div>
                        </div>
                    </div>
                    <button class="find-ticket" type="submit">
                        <em class="fa fa-search"></em>
                        Tim chuyen xe
                    </button>
                </div>

            </div>
            </form>
        </div>
        <div><!-- footer -->
        </div>
        <div class="tft96 hide">
            <div class="popup-container">
                <div class="popup-form">
                    <div class="popup-content">
                        <div class="popup-header">
                            <img class="popup-img" src="resources/img/icon/icon3.png" width="190px" height="50px">
                            <button class="close-button">x</button>
                        </div>
                        <div class="popup-body">
                            <div class="login-phone">
								<form action="LoginControl" method="get">
                                <div class="phone-login">
                                    <label style="font-weight: 700px;">Đăng nhập bằng số điện thoại</label>
                                    <div class="phone-number-input">
                                        <div class="select-country">
                                            <div style="font-size: 12px;">Mã quốc gia</div>
                                            <div>+84</div>
                                        </div>
                                        <div class="input-number">
                                            <input name="num" class="num" type="text">
                                        </div>
                                    </div>
                                    <button class="btn_ok" type="submit">Đăng nhập</button>
                                </div>
							    </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <script type="text/javascript" src="resources/js/script.js"></script>
    <script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap dropdown -->
    <script type="text/javascript" src="resources/js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->

    </body>
</html>
