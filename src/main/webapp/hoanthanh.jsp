<%-- 
    Document   : hoanthanh
    Created on : Mar 20, 2023, 9:22:06 PM
    Author     : lasin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
        integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    </head>
    <body>
		<% String res=(String)request.getAttribute("res");
		String vnp_OrderInfo=(String)request.getAttribute("vnp_OrderInfo");
		%>
        <div class="container">
        <div class="text-center">
			<%if(res.equals("ok")){%>
            <h1>ĐẶT VÉ THÀNH CÔNG SỐ VÉ CỦA QUÝ KHÁCH LÀ <%=vnp_OrderInfo%></h1>
			<%}else{%>
			<h1>ĐẶT VÉ THẤT BẠI VUI LÒNG QUAY LẠI TRANG CHỦ SAU VÀI PHÚT HOẶC LIÊN HỆ VỚI BỘ PHẬN CHĂM SÓC KHÁCH HÀNG</h1>
			<%}%>
            <hr />
        </div>
		</div>
    </body>
</html>
