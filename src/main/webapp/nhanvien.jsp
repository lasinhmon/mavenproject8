<%-- 
    Document   : nhanvien
    Created on : Mar 17, 2023, 10:38:51 PM
    Author     : lasin
--%>

<%@page import="dao.SimpleDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Ghe"%>
<%@page import="java.util.List"%>
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
	<link href="resources/css/adminstyle.css" rel="stylesheet">
</head>

<body>
	<%
		List<Ghe>list=new ArrayList();
		//List<Ghe>list=new ArrayList();
		List<Ghe>result=new ArrayList();
		result=(List<Ghe>)request.getAttribute("result");
		int offs=(Integer)request.getAttribute("offset");
		list=(List<Ghe>)request.getAttribute("list");
		String acc=(String)session.getAttribute("acc");
	    String offset=String.valueOf(offs+1);
		SimpleDAO testsimpledao = new SimpleDAO();;
		List<Ghe>listghe=new ArrayList();
		listghe=testsimpledao.getListGhe();
		int n=(listghe.size()/24);
	%>
    <div class="container">
		<div class="header">
            <div class="title">
			    <h1>Quản Lý Công Việc</h1>
               <hr />
            </div>
			<div class="acc">
				<div class="acc-name">
	     		    <span>Xin chào <%=acc%></span>
				</div>
				<div class="out">
			        <a href="LogoutControl">Thoat</a>
				</div>
		    </div>
			 		
		</div>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<form action="SearchControl" method="get">
                <div class="row mt-15" style="margin-bottom: 20px;">
                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
						
                        <div class="input-group1">
                            <input name="searchVe" type="text" class="form-input" placeholder="Nhập mã vé..." value="" />
							<input type="submit" class="btn btn-primary" name="find" value="Tim"></input>
                            <span class="input-group-btn1">
								<div class="btn-right"><input type="submit" class="btn btn-primary" name="find" value="Thong ke ghe chua thanh toan"></input></div>
                            </span>                         
                        </div>
						
                    </div>
					<span>Chon ngay :</span>
					
					<input class="sd" type="date"  id="todate" name="todate" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>"/>
					<input type="submit" class="btn btn-primary" name="find" value="Thong ke ghe trong"></input>
                </div>
				</form>
                <div class="row mt-15 wrapper">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <table class="table table-bordered table-hover">
							<%
								if(list!=null&&result==null){ %>
                            <thead>
                                <tr>
                                    <th class="text-center">Mã Chuyến </th>
									<th class="text-center">Số ghế</th>
                                    <th class="text-center">Mã Vé</th>
                                    <th class="text-center">Mã Chặng</th>
									<th class="text-center">Trạng thái</th>
                                    <th class="text-center">Hành Động</th>
                                </tr>
                            </thead>
							<%} else if(list==null&&result!=null){%>
							<thead>
                                <tr>
                                    <th class="text-center">Mã Chuyến </th>
									<th class="text-center">Số Ghế</th>
                                    <th class="text-center">Mã Vé</th>
                                    <th class="text-center">Mã Chặng</th>
									<th class="text-center">Trạng Thái</th>
                                    <th class="text-center">Ghi Chú</th>
                                </tr>
                            </thead>
							<%}%>
                            <tbody>
								<%
									if(list!=null&&result==null){
										//System.out.println("ki v");
										//session.setAttribute("list", list);
									    for(int i=0;i<list.size();i++){
								%>
                                <tr>
                                    <td><%=list.get(i).getMachuyen()%></td>
                                    <td><%=list.get(i).getSoghe()%></td>
                                    <td><%=list.get(i).getMave()%></td>
                                    <td><%=list.get(i).getMachang()%></td>
									<td><%=list.get(i).getTrangthai()%></td>
                                    <td class="text-center">
										<form action="ActionControl" method="get">
											<input type="hidden" class="ve" name="ve" id="ve" value=<%=list.get(i).getMave()%>></input>
											<input type="hidden" class="soghe" name="soghe" id="soghe" value=<%=list.get(i).getSoghe()%>></input>
										    <input type="hidden" class="chuyen" name="chuyen" id="chuyen" value=<%=list.get(i).getMachuyen()%>></input>
                                            <input type="submit" class="btn btn-danger" name="act" value="Delete"></input>
										    <input type="submit" class="btn btn-success" name="act" value="Update"></input>
									    </form>
                                    </td>
                                </tr>
							
								<%}}else if(list==null&&result!=null){
								    for(int i=0;i<result.size();i++){
								%>
								<tr>
                                    <td><%=result.get(i).getMachuyen()%></td>
                                    <td><%=result.get(i).getSoghe()%></td>
                                    <td><%=result.get(i).getMave()%></td>
                                    <td><%=result.get(i).getMachang()%></td>
									<td><%=result.get(i).getTrangthai()%></td>
                                    <td class="text-center">
										<form action="ActionControl" method="get">
										    <input type="hidden" class="ve" name="ve" id="ve" value=<%=result.get(i).getMave()%>></input>
											<input type="hidden" class="soghe" name="soghe" id="soghe" value=<%=result.get(i).getSoghe()%>></input>
										    <input type="hidden" class="chuyen" name="chuyen" id="chuyen" value=<%=result.get(i).getMachuyen()%>></input>
                                            
									    </form>
                                    </td>
                                </tr>
								<%}}%>
                            </tbody>
                        </table>
                    </div>
					<% if(list!=null&&result==null){%>
					<form action="PaginationControl" method="post" name="form1">
					<div class="paging">
						<input name="step" class="page" type="submit" value=<%="prev"%> />
						<input name="step" class="page" type="submit" value=<%="next"%> />
						<select id="mySelect" name="step" class="page" onchange="javascript:document.form1.submit();">
							<% for(int i=1;i<=n+1;i++){%>
                                <option value=<%=i%>><%=i%></option>
							<%}%>
                        </select>
						<input name="offset" class="offset" type="hidden" value=<%=offset%> readonly></input>	
						
					</div>
					<%}%>
					</form>		
                </div>
            </div>
        </div>
    </div>
	<script type="text/javascript" src="resources/js/nhanvien.js"></script>
    <script src="//code.jquery.com/jquery.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</body>
</html>
