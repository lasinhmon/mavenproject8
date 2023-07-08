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
    <div class="login">
        <form id="login" method="get" action="XeControl">
             <div class="wrapper">
    <div class="title">
        <span> THEM MOI XE</span>
    </div>
    <div class="info-staff">
        <div class="title-info">
            <span>Thong so xe</span>
        </div>
        <div class="all-input-container">
            <div class="input-container">
                <div class="inpt">
                    <span>Bien so</span>
                    <input class="txt" type="text" name="bsx" id="bsx" />
                </div>
                <div class="inpt">
                    <span>Ngay mua</span>
                    <input class="txt" type="date"/>
                </div>
            </div>
            <div class="input-container">
                <div class="inpt">
                    <span>Dong xe</span>
                    <input class="txt" type="text"/>
                </div>
                <div class="inpt">
                    <span>Gia tien</span>
                    <input class="txt" type="text"/>
                </div>
            </div>

        </div>
    </div>
		<div class="info-staff" style="float: right;">
    <input type="submit" name="log" id="log" value="ADD">
   </div>		 
   </div>
   
           
        </form>
    </div>

</body>

</html> 
