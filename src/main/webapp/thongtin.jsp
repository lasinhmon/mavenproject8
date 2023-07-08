<%-- 
    Document   : thongtin
    Created on : Mar 1, 2023, 9:41:17 PM
    Author     : lasin
--%>

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

    <!-- Your custom styles (optional) -->
    <link href="resources/css/style.css" rel="stylesheet">
    </head>

    <body>
    <%
		String soghedi="a",ngdi="a",giadi="a";
		String gia=(String)request.getAttribute("gia");
		String gadi=(String)request.getAttribute("gadi");
		String gaden=(String)request.getAttribute("gaden");
		String ngaydi=(String)request.getAttribute("ngaydi");
		String soghe=(String)request.getAttribute("soghe");
		if((String)request.getAttribute("soghedi")!=null)
		{
			soghedi=(String)request.getAttribute("soghedi");
			ngdi=(String)request.getAttribute("ngdi");
            giadi=(String)request.getAttribute("giadi");
		}
		else{
			System.out.println("huhuhu");
		}
		//System.out.println(gia);
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
                <button class="dropdown_button">Tài khoảng</button>
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
                    <a href="resources/Untitled-2.html">TRANG CHỦ</a>
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
            <label class="text" style="font-size:30px;">THÔNG TIN HÀNH KHÁCH</label>
        </div>
		
        <div class="step-line-container">
            <div class="step-line">
                <div class="step">
                    <div id="cirlce" class="current-step">
                        1
                        <div class="actived-step-text">
                            <span id="text-route">CHJN TUYẾN</span>
                        </div>
                    </div>
                    <div id="cirlce" class="current-step">
                        2
                        <div class="actived-step-text">
                            <span id="text-route">XÁC NHẬN LỘ TRÌNH</span>
                        </div>
                    </div>
                    <div id="cirlce" class="next-step">
                        3
                        <div class="actived-step-text">
                            <span id="text-route">THÔNG TIN HÀNH KHÁCH</span>
                        </div>
                    </div>
                    <div id="cirlce" class="empty-step">
                        4
                        <div class="next-step-text">
                            <span id="text-route">THANH TOÁN</span>
                        </div>
                    </div>
                </div>
                <div class="line">
                    <div class="current-line"></div>
                    <div class="current-line"></div>
                    <div></div>
                </div>
            </div>
        </div>
		<form name="thongtinform" action="ThongTinControl" method="post" onSubmit="return validateForm(event);">
            <div class="child">
                <div class="customer-container">
                    <div class="info-form">
                        <label style="font-size:25px;color:#C6CC51">Thông tin Hành Khách</label>
						<div class="customer-form">                       
                            <label>Họ tên hành khách</label>
                            <input name="ten" id="ten" type="text">				
                            <label>Số điện thoại</label>
                            <input name="sdt" id="sdt" type="tel" required>					
                            <label>Địa chỉ</label>
                            <input name="diachi" id="diachi" type="text">
							<input type="hidden" class="gia" name="gia" id="gia" value=<%=gia%>></input>
							<input type="hidden" class="gadi" name="gadi" id="gadi" value=<%=gadi%>></input><!-- comment -->
						    <input type="hidden" class="gaden" name="gaden" id="gaden" value=<%=gaden%>></input>
							<input type="hidden" class="ngaydi" name="ngaydi" id="ngaydi" value='<%=ngaydi%>'></input>
							<input type="hidden" class="soghe" name="soghe" id="soghe" value='<%=soghe%>'></input>
							<input type="hidden" class="giadi" name="giadi" id="giadi" value=<%=giadi%>></input>
							<input type="hidden" class="ngdi" name="ngdi" id="ngdi" value='<%=ngdi%>'></input>
							<input type="hidden" class="soghedi" name="soghedi" id="soghedi" value='<%=soghedi%>'></input>
                        </div>
                    </div>
                    <div class="info-form">
                        <label style="font-size:25px;color:#C6CC51">Dieu khoan va Luu y</label>
                        <label style="font-size:20px;">Đừng để sát ngày rồi mới hoàn vé</label>
                        <label style="font-size:20px;">Đừng chơi đá trước khi lên xe làm ơn</label>
                    </div>
                </div>
            </div>
            <div class="return">
                <button class="button-return">
                    <a href="index.jsp">< Quay lại trang chủ</a>
                </button>
                <button class="button-return" style="background-color:#0082F0">
                    Tiếp tục >
                </button>
            </div>
		</form>
    </div>
    <div><!-- footer -->

    </div>

    <script type="text/javascript" src="resources/js/thongtinscript.js"></script>
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
