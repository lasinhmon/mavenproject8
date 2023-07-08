<%-- 
    Document   : taixe
    Created on : Mar 28, 2023, 4:20:31 PM
    Author     : lasin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login Form</title>
    <link href="resources/css/style2.css" rel="stylesheet">
</head>

<body>
	<%
		if((String)session.getAttribute("acc")==null)
		    response.sendRedirect("index.jsp");
	%>
<form id="login" method="get" action="NhanVienControl">
   <div class="wrapper">
    <div class="title">
        <span> THEM MOI NHAN VIEN</span>
    </div>
    <div class="info-staff">
        <div class="title-info">
            <span>Thong tin ca nhan</span>
        </div>
        <div class="all-input-container">
            <div class="input-container">
                <div class="inpt">
                    <span>Ho ten</span>
                    <input class="txt" name="Uname" id="Uname"  type="text" required/>
                </div>
                <div class="inpt">
                    <span>Gioi tinh</span>
                    <select class="selector">
                        <option value="asc">Nam</option>
                        <option value="desc">Nu</option>
                    </select>
                </div>
            </div>
            <div class="input-container">
                <div class="inpt">
                    <span>Dia chi</span>
                    <input class="txt" type="text" name="Addre" id="Addre" required/>
                </div>
                <div class="inpt">
                    <span>Dien thoai</span>
                    <input class="txt" type="text" name="Sdt" id="Sdt" required/>
                </div>
            </div>
			<div class="input-container">
                <div class="inpt">
                    <span>CMND/CCCD</span>
                    <input class="txt" type="text" name="Addre" id="Addre" required/>
                </div>
             
            </div>
        </div>
    </div>
    <div class="info-staff">
        <div class="title-info">
            <span>Thong tin gia dinh</span>
        </div>
        <div class="all-input-container">
            <div class="input-container">
                <div class="inpt">
                    <span>Ho ten cha</span>
                    <input class="txt" type="text"/>
                </div>
                <div class="inpt">
                    <span>Nghe nghiep</span>
                    <input class="txt" type="text"/>
                </div>
            </div>
            <div class="input-container">
                <div class="inpt">
                    <span>Ho ten me</span>
                    <input class="txt" type="text"/>
                </div>
                <div class="inpt">
                    <span>Nghe nghiep</span>
                    <input class="txt" type="text"/>
                </div>
            </div>
        </div>
    </div>
    <div class="info-staff">
        <div class="title-info">
            <span>Chuc vu</span>
        </div>
        <div class="roll">
            <input class="roll-choice" type="checkbox" name="NvChuyen" id="NvChuyen" onclick='handleClick();' checked="checked" value="chuyen" >
            <span>Nhan vien chuyen</span>
        </div>
    </div>
	<div class="info-staff" style="float: right;">
        <input type="submit" name="log" id="log" value="ADD">
    </div>
   </div>
   
</form>
    <script type="text/javascript" src="resources/js/nhansu.js"></script>
</body>

</html>