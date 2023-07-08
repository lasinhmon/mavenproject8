<%-- 
    Document   : veinfo
    Created on : Mar 13, 2023, 3:52:02 PM
    Author     : lasin
--%>

<%@page import="com.mysql.cj.util.StringUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <!-- Customizer -->
    <link rel="stylesheet" href="https://mdbootstrap.com/live/_MDB/css/customizer.min.css">
    <!-- Your custom styles (optional) -->
    <link href="resources/css/style.css" rel="stylesheet">
</head>

<body>
	<% 
		String soghedi="",ngdi="a",giadi="";
		int count2=0,tongtien2=0;
		String gia=(String)request.getAttribute("gia");
		String gadi=(String)request.getAttribute("gadi");
		String gaden=(String)request.getAttribute("gaden");
		String ngaydi=(String)request.getAttribute("ngaydi");
		String soghe=(String)request.getAttribute("soghe");
		String sdt=(String)request.getAttribute("sdt");
		String ten=(String)request.getAttribute("ten");
		String diachi=(String)request.getAttribute("diachi");
		int count = soghe.replaceAll("[^ ]", "").length();
		int tongtien=count*Integer.parseInt(gia);
		if((String)request.getAttribute("soghedi")!=null)
		{
			soghedi=(String)request.getAttribute("soghedi");
			ngdi=(String)request.getAttribute("ngdi");
            giadi=(String)request.getAttribute("giadi");
			count2 = soghedi.replaceAll("[^ ]", "").length();
		    tongtien2=count2*Integer.parseInt(giadi);
		}
		else{
			System.out.println("huhuhu");
		}
	%>
    <div class="header"><!-- Toan bo -->
        <div class="flex" id="head-top">
            <div class="social-icon" width="34px" height="34px">
                <ul class="social">

                    <a class="fb-ic">
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
                    <a href="/Untitled-2.html">TRANG CHỦ</a>
                </div>
                <div id="nav" class="link"><a href="/Untitled-2.html">LỊCH TRÌNH</a></div>
                <div id="nav" class="link"><a href="/hoadon.html">HÓA ĐƠN</a></div>
                <div id="nav" class="link"><a href="/Untitled-2.html">LIÊN HỆ</a></div>
                <div id="nav" class="link"><a href="/Untitled-2.html">TUYỂN DỤNG</a></div>
            </div>
        </div>
    </div>

    <div class="mider">
        <div class="customer-info">
            <label class="text" style="font-size:30px;">THANH TOÁN</label>
        </div>
        <div class="step-line-container">
            <div class="step-line">
                <div class="step">
                    <div id="cirlce" class="current-step">
                        1
                        <div class="actived-step-text">
                            <span id="text-route">CHỌN TUYẾN</span>
                        </div>
                    </div>
                    <div id="cirlce" class="current-step">
                        2
                        <div class="actived-step-text">
                            <span id="text-route">XÁC NHẬN LỘ TRÌNH</span>
                        </div>
                    </div>
                    <div id="cirlce" class="current-step">
                        3
                        <div class="actived-step-text">
                            <span id="text-route">THÔNG TIN HÀNH KHÁCH</span>
                        </div>
                    </div>
                    <div id="cirlce" class="next-step">
                        4
                        <div class="actived-step-text">
                            <span id="text-route">THANH TOÁN</span>
                        </div>
                    </div>
                </div>
                <div class="line">
                    <div class="current-line"></div>
                    <div class="current-line"></div>
                    <div class="current-line"></div>
                    <div></div>
                </div>
            </div>
        </div>
        <div class="child">
            <div class="ticket-info-container">
                <div class="title-bar" style="background-color:#0082F0">
                    <label style="font-size:25px;color:white;font-weight:700">Thông Tin Mua Vé</label>
                </div>
                <div class="ticket-customer-info">
                    <div class="customer-ticket-container">
                        <div class="the-title">
                            <label style=" font-size:27px;">Thông Tin Hành Khách</label>
                        </div>
                        <div class="customer-ticket">
                            <div class="info-container">
                                <div class="info">
                                    <div class="name-title">Hhọ tên:</div>
                                    <div class="name" style=" font-size:27px;"><%=ten%></div>
                                </div>
                                <div class="info">
                                    <div class="name-title">Số điện thoại:</div>
                                    <div class="name" style=" font-size:27px;"><%=sdt%></div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="ticket-customer-info">
                    <div class="customer-ticket-container">
                        <div class="the-title">
                            <label style=" font-size:27px;">Thông tin chuyến: <%=gadi%> => <%=gaden%></label>
                        </div>
                        <div class="customer-ticket">
                            <div class="info-container">
                                <div class="info">
                                    <div class="name-title">Tuyến xe:</div>
                                    <div class="name" style=" font-size:27px;"><%=gadi%> => <%=gaden%></div>
                                </div>
                                <div class="info">
                                    <div class="name-title">Giờ đi:</div>
                                    <div class="name" style=" font-size:27px;"><%=ngaydi%>:00:00</div>
                                </div>
                            </div>
                            <div class="info-container">
                                <div class="info">
                                    <div class="name-title">Số lượng ghế:</div>
                                    <div class="name" style=" font-size:27px;"><%=count%></div>
                                </div>
                                <div class="info">
                                    <div class="name-title">Số ghế:</div>
                                    <div class="name" style=" font-size:27px;"><%=soghe%></div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="total-pay">
                    <div class="total-pay-title">
                        <label style="font-size:22px;font-weight:300">TỔNG TIỀN</label>
                        <label style="font-size:33px;color:#97C14B;font-weight:600"><%=tongtien%></label>
                    </div>
                </div>
            </div>
        </div>
		<%if(!ngdi.equals("a")){%>
		 <div class="child">
            <div class="ticket-info-container">
                <div class="title-bar" style="background-color:#0082F0">
                    <label style="font-size:25px;color:white;font-weight:700">Thông Tin Mua Vé</label>
                </div>
                <div class="ticket-customer-info">
                    <div class="customer-ticket-container">
                        <div class="the-title">
                            <label style=" font-size:27px;">Thông Tin Hành Khách</label>
                        </div>
                        <div class="customer-ticket">
                            <div class="info-container">
                                <div class="info">
                                    <div class="name-title">Họ tên:</div>
                                    <div class="name" style=" font-size:27px;"><%=ten%></div>
                                </div>
                                <div class="info">
                                    <div class="name-title">Số điện thoại:</div>
                                    <div class="name" style=" font-size:27px;"><%=sdt%></div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="ticket-customer-info">
                    <div class="customer-ticket-container">
                        <div class="the-title">
                            <label style=" font-size:27px;">Thông tin chuyến: <%=gaden%> => <%=gadi%></label>
                        </div>
                        <div class="customer-ticket">
                            <div class="info-container">
                                <div class="info">
                                    <div class="name-title">Tuyến xe:</div>
                                    <div class="name" style=" font-size:27px;"><%=gaden%> => <%=gadi%></div>
                                </div>
                                <div class="info">
                                    <div class="name-title">Giờ đi:</div>
                                    <div class="name" style=" font-size:27px;"><%=ngdi%>:00:00</div>
                                </div>
                            </div>
                            <div class="info-container">
                                <div class="info">
                                    <div class="name-title">Số lượng ghế:</div>
                                    <div class="name" style=" font-size:27px;"><%=count2%></div>
                                </div>
                                <div class="info">
                                    <div class="name-title">Số ghế:</div>
                                    <div class="name" style=" font-size:27px;"><%=soghedi%></div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="total-pay">
                    <div class="total-pay-title">
                        <label style="font-size:22px;font-weight:300">TONG TIEN</label>
                        <label style="font-size:33px;color:#97C14B;font-weight:600"><%=tongtien2%></label>
                    </div>
                </div>
            </div>
        </div>
		<%}%>
		<form class="tam" action="LuuControl" method="post">
        <div class="return">	
			<input type="hidden" class="ten" name="ten" id="ten" value='<%=ten%>'></input>				                
            <input type="hidden" class="sdt" name="sdt" id="sdt" value='<%=sdt%>'></input>					
			<input type="hidden" class="gia" name="gia" id="gia" value=<%=gia%>></input>
			<input type="hidden" class="gadi" name="gadi" id="gadi" value=<%=gadi%>></input><!-- comment -->
			<input type="hidden" class="gaden" name="gaden" id="gaden" value=<%=gaden%>></input>
			<input type="hidden" class="ngaydi" name="ngaydi" id="ngaydi" value='<%=ngaydi%>'></input>
			<input type="hidden" class="soghe" name="soghe" id="soghe" value='<%=soghe%>'></input>
			<input type="hidden" class="giadi" name="giadi" id="giadi" value=<%=giadi%>></input>
			<input type="hidden" class="ngdi" name="ngdi" id="ngdi" value='<%=ngdi%>'></input>
			<input type="hidden" class="soghedi" name="soghedi" id="soghedi" value='<%=soghedi%>'></input>
            <button class="button-return">
                <a href="index.jsp">< Quay lai trang chu</a>
			<input type="submit" name="save" class="button-return" style="background-color:rgb(6, 86, 62)" value="Dat Cho >"></input>
			<input type="submit" name="save" class="button-return" style="background-color:rgb(6, 86, 62)" value="Thanh Toan >"></input>
			
        </div>
		</form>
    </div>
    <div><!-- footer -->

    </div>

    <script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap dropdown -->
    <script type="text/javascript" src="resources/js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="resources/js/mdb.min.js"></script>
    <!-- Customizer -->
    <script type="text/javascript" src="https://mdbootstrap.com/live/_MDB/js/customizer.min.js"></script>
    <!-- Custom -->
</body>

</html>
