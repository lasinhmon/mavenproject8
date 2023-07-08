<%-- 
    Document   : lotrinh
    Created on : Feb 28, 2023, 9:28:59 AM
    Author     : lasin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>

<%@page import="dao.DAO.*"%>
<%@page import="entity.*"%>
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
        if(session.getAttribute("chang")==null||session.getAttribute("chuyen")==null){
			response.sendRedirect("index.jsp");
		}
		Chang c=(Chang)session.getAttribute("chang");
		//System.out.println(c.getMachang());
		List<Chuyen>lst=(List<Chuyen>)session.getAttribute("chuyen");
		
		String ngay="";
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy");
		if(lst.size()!=0)
		    ngay =sdf3.format(lst.get(0).getNgay());
		List<Ghe>list=(List<Ghe>)session.getAttribute("ghe");
		String tam="";
		if(session.getAttribute("fromdate")==null)
		    tam="1";
		else
		    tam=(String)session.getAttribute("fromdate");
		
		//System.out.println(tam);
		session.setAttribute("ancom", tam);
		//System.out.println("ready?");
		String gia="",ngaydi="",soghe="";
		if((String)session.getAttribute("ngaydi")!=null){
			gia=(String)session.getAttribute("gia");
		    ngaydi=(String)session.getAttribute("ngaydi");
		    soghe=(String)session.getAttribute("soghe");
			session.setAttribute("ngdi", ngaydi);
			session.setAttribute("giadi", gia);
			session.setAttribute("soghedi", soghe);
		}else{
			System.out.println((String)request.getAttribute("ngaydi"));
			//System.out.println("huhuh");
		}
		//System.out.println("hehelt"+lst.size());
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
                    <a href="index.jsp">TRANG CHỦ</a>
                </div>
                <div id="nav" class="link"><a href="index.jsp">LỊCH TRÌNH</a></div>
                <div id="nav" class="link"><a href="index.jsp">HÓA ĐƠN</a></div>
                <div id="nav" class="link"><a href="index.jsp">LIÊN HỆ</a></div>
                <div id="nav" class="link"><a href="index.jsp">TUYỂN DỤNG</a></div>
            </div>
        </div>
    </div>

    <div class="mider">
        <div class="route-info">
            <label class="text" style="font-size:30px;"><%=c.getGadi()%> - <%=c.getGaden()%></label>
            <label class="text" style="font-size:20px;"><%=ngay%></label>
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
                    <div id="cirlce" class="next-step">
                        2
                        <div class="actived-step-text">
                            <span id="text-route">XÁC NHẬN LỘ TRÌNH</span>
                        </div>
                    </div>
                    <div id="cirlce" class="empty-step">
                        3
                        <div class="next-step-text">
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
                    <div></div>
                    <div></div>
                </div>
            </div>
        </div>
        <div class="child">
            <div class="data-container">
              
                <h2>Chon gio len xe phu hop</h2>
				<%
				
				for(int i=0;i<lst.size();i++){
				Timestamp timestamp=lst.get(i).getNgay();
				//session.setAttribute("antrua", timestamp);
                Long val=timestamp.getTime();
				//System.out.println(val);
				Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(timestamp.getTime());
				if(c.getGadi().equals("BaoLoc")&&c.getGaden().equals("DaLat"))
				    cal.add(Calendar.HOUR, 5);
				else if(c.getGadi().equals("BaoLoc")&&c.getGaden().equals("TPHCM"))
					cal.add(Calendar.HOUR, 3);
				timestamp = new Timestamp(cal.getTime().getTime());
				System.out.println(timestamp);
                List<Ghe> ghetemp=new ArrayList();
				for(Ghe item : list){
					if(lst.get(i).getMachuyen()==item.getMachuyen()){
						ghetemp.add(item);
					}
				}
				

                Timestamp timestamp1 = timestamp;
                Date date = new Date(timestamp1.getTime());
                Calendar cale = Calendar.getInstance();
                cale.setTime(date);
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                System.out.println("Time in milliseconds: " + hour);
				%>
				 <div class="route-option">
                    <div class="option-header">
                        <%=hour%>:00 <img src="resources/img/icon/fromto.png" width="34px" height="34px"> 
						<%
							if(c.getGadi().equals("BaoLoc")&&c.getGaden().equals("DaLat")){%>
								<%=hour+3%>:00
							<%}
                            else if(c.getGadi().equals("TPHCM")&&c.getGaden().equals("BaoLoc")){%>
							    <%=hour+5%>:00
							<%}
                            else if(c.getGadi().equals("BaoLoc")&&c.getGaden().equals("TPHCM")){%>
							    <%=hour+5%>:00
							<%}
                            else if(c.getGadi().equals("DaLat")&&c.getGaden().equals("BaoLoc")){%>
							    <%=hour+5%>:00
							<%}
                            else {%>
                                <%=hour+8%>:00
							<%}%>
                    </div>
                    <div class="option-label" id="option">
						<div class="option-label1" id="option2"> <%=c.getGia()%></div>
                        <div class="dot"></div>
                        <div class="option-label1" ><%=timestamp%></div>
                        <div class="dot"></div>
                        <div class="option-label1" >còn <%=24-ghetemp.size()%> ghế</div>
                    </div>
                    <div class="route-container">
                        <div class="route-line">
                            <div style="font-size:30px;">Ben xe <%=c.getGadi()%></div>
                            <div style="font-size:20px;">
							<%
							if(c.getGadi().equals("BaoLoc")&&c.getGaden().equals("DaLat")){%>
								<%=3%> tiếng
							<%}
                            else if(c.getGadi().equals("TPHCM")&&c.getGaden().equals("BaoLoc")){%>
							    <%=5%> tiếng
							<%}
                            else if(c.getGadi().equals("BaoLoc")&&c.getGaden().equals("TPHCM")){%>
							    <%=5%> tiếng
							<%}
                            else if(c.getGadi().equals("DaLat")&&c.getGaden().equals("BaoLoc")){%>
							    <%=5%> tiếng
							<%}
                            else {%>
                                <%=8%> tiếng
							<%}%></div>
                            <div style="font-size:30px;">Ben xe <%=c.getGaden()%></div>
                        </div>
                        <button class="route-choose" style="cursor: pointer;">
                            <img src="resources/img/icon/pokeball.png" width="34px" height="34px">
                        </button>
                    </div>
                    <div class="tft97 hide">
                        <div class="seat-container ">

                            <div class="seat-map">
                                <div class="floor-title">
                                    <div class="floor-name">Bên trái</div>
                                    <div class="floor-name">Bên phải</div>
                                </div>
                                <div class="seat-table">
                                    <div class="seat-table-container">
                                        <table class="table">
											<%for(int j=1;j<=23;j=j+3){%>
                                            <tr>
												<%  boolean flag=false;
													for(Ghe item : ghetemp){
													if(item.getSoghe()==j){
														flag=true;
														break;
													}
												}
													if(!flag){%>
                                                <td>
                                                    <div class="seat-num" id="seat-nu" name="seat${j}" style="cursor: pointer;" >
                                                        <img src="resources/img/icon/armchair.png">
                                                        <h4 class="seat-number"><%=j%></h4>
                                                    </div>
                                                </td><%}else{%>
												<td>
                                                    <div class="seat-num disabled" id="seat-nu" name="seat${j}" style="background-color:rgb(155, 150, 150); "readonly>
                                                        <img src="resources/img/icon/armchair.png">
                                                        <h4 class="seat-number"><%=j%></h4>
                                                    </div>
                                                </td>
												<%}
                                                    boolean flag2=false;
													for(Ghe item : ghetemp){
													if(item.getSoghe()==j+1){
														flag2=true;
														break;
													}
												}
													if(!flag2){%>
                                                <td>
                                                    <div class="seat-num" id="seat-nu" name="seat${j+1}" style="cursor: pointer;">
                                                        <img src="resources/img/icon/armchair.png">
                                                        <h4 class="seat-number"><%=j+1%></h4>
                                                    </div>
                                                </td><%}else{%>
												<td>
                                                    <div class="seat-num disabled" id="seat-nu" name="seat${j+1}" style="background-color:rgb(155, 150, 150); " readonly>
                                                        <img src="resources/img/icon/armchair.png">
                                                        <h4 class="seat-number"><%=j+1%></h4>
                                                    </div>
                                                </td>
												<%}%>
                                            </tr>
                                            <%}%>
                                        </table>
                                    </div>
                                    <div class="seat-table-container">
                                        <table class="table">
											<%for(int j=3;j<=24;j=j+3){%>
                                            <tr>
                                                <%  boolean flag=false;
													for(Ghe item : ghetemp){
													if(item.getSoghe()==j){
														flag=true;
														break;
													}
												}
													if(!flag){%>
                                                <td>
                                                    <div class="seat-num" id="seat-nu" name="seat${j}" style="cursor: pointer;">
                                                        <img src="resources/img/icon/armchair.png">
                                                        <h4 class="seat-number"><%=j%></h4>
                                                    </div>
                                                </td><%}else{%>
												<td>
                                                    <div class="seat-num disabled" id="seat-nu" name="seat${j}" style="background-color:rgb(155, 150, 150); "readonly>
                                                        <img src="resources/img/icon/armchair.png">
                                                        <h4 class="seat-number"><%=j%></h4>
                                                    </div>
                                                </td>
												<%}%>
                                            </tr>
											<%}%>
                                        </table>
                                    </div>
                                </div>
                                <div class="seat-status">
                                    <div class="status-item">
                                        <div class="rec"></div>
                                        <div class="status-text">Trống</div>
                                    </div>
                                    <div class="status-item">
                                        <div class="rec" style="background-color: yellowgreen"></div>
                                        <div class="status-text">Đang chọn</div>
                                    </div>
                                    <div class="status-item">
                                        <div class="rec" style="background-color:rgb(155, 150, 150)"></div>
                                        <div class="status-text">Đã đặt</div>
                                    </div>

                                </div>
                            </div>
							<form class="tam" action="GheControl" method="post">
                            <div class="seat-footer">
                                <div class="bill-info">
									
									<div>
                                    Ghế:
									<input type="hidden" class="gia" name="gia" id="gia" value=<%=c.getGia()%>></input><!-- comment -->
									<input type="hidden" class="gaden" name="gaden" id="gaden" value=<%=c.getGaden()%>></input>
									<input type="hidden" class="gadi" name="gadi" id="gadi" value=<%=c.getGadi()%>></input>
									<input type="hidden" class="ngaydi" name="ngaydi" id="ngaydi" value=<%=val%>></input>
                                    <input name="total-ghe" class="total-ghe" id="total-ghe" value="" readonly></input>
									</div>
									<div>
                                    Tổng tiền:
                                    <span class="total" id="total" >0</span>
									</div>
                                </div>							
                                    <button class="btn-check" type="submit">
                                        Tiếp tục
                                    </button>
							    
                            </div>
							</form>
                        </div>
                    </div>
                </div>
				 <%}%>
            </div>
        </div>
        <div class="return">
            <button class="button-return">
				<a href="index.jsp">< Quay lại trang chủ</a>
                </button>
        </div>
    </div>
    <div><!-- footer -->

    </div>


    <script type="text/javascript" src="resources/js/lotrinhscript.js"></script>
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
