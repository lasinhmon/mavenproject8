<%-- 
    Document   : nhansu
    Created on : Mar 27, 2023, 8:46:57 AM
    Author     : lasin
--%>

<%@page import="entity.Chuyen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.TaiXe"%>
<%@page import="entity.Xe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">

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
		List<Xe>listxe=new ArrayList();
        List<TaiXe>listtaixe=new ArrayList();
		List<Chuyen>listchuyen=new ArrayList();
		listxe=(List<Xe>)session.getAttribute("listxe");
		listtaixe=(List<TaiXe>)session.getAttribute("listtaixe");
		listchuyen=(List<Chuyen>)session.getAttribute("listchuyen");
		int role=(Integer)session.getAttribute("role");
		String acc=(String)session.getAttribute("acc");
	%>
    <div class="container">
		<div class="header">
            <div class="title">
			    <%if(role==1){%>
                <h1 class="text-right">Quản Lý Nhân Sự</h1>
			    <%}else if(role==2){%>
			    <h1 class="text-right">Quản Lý Chuyếṇ</h1>
			    <%}%>
               <hr />
            </div>
			<div class="acc">
				<div class="acc-name">
	     		    <span>Xin chao <%=acc%></span>
				</div>
				<div class="out">
			        <a href="LogoutControl">Thoat</a>
				</div>
		    </div>
			 		
		</div>
        <div class="row">
			
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<%if(role==1){%>
				<div class="row mt-15" style="margin-bottom: 20px;">
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <a href="taixe.jsp"><button class="btn btn-primary " type="button">Thêm Tài Xế</button></a>
						<a href="xe.jsp"><button class="btn btn-primary " type="button">Thêm Xe</button></a>
                        <a href="themnhanvien.jsp"><button class="btn btn-primary " type="button">Thêm Nhân Viên</button></a>
                            
                    </div>
                </div>
				<%}if(role==2||role==1){%>
                <div class="row mt-15">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <table class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th class="text-center">Mã Xe</th>
                                    <th class="text-center">Tên Tài xế</th>
                                    <th class="text-center">Ngày</th>
                                    <th class="text-center">Giờ</th>
                                    <th class="text-center">Hành Động</th>
                                </tr>
                            </thead>
							
                            <tbody>
							<form action="AddChuyenControl" method="post">
                                <tr>
                                    <td>
                                        <select name='xe' class="form-control">
											<%
											for(int i=0;i<listxe.size();i++){
											%>
                                            <option value='<%=listxe.get(i).getMaxe()%>'><%=listxe.get(i).getBiensoxe()%></option>
                                            <%}%>
                                        </select>
                                    </td>
                                    <td>
                                        <select name='ma' class="form-control">
											<%
											for(int i=0;i<listtaixe.size();i++){
											%>
                                            <option value='<%=listtaixe.get(i).getMa()%>'><%=listtaixe.get(i).getTentaixe()+"-"+listtaixe.get(i).getSdt()%></option>
                                            <%}
											%>
                                        </select>
                                    </td>
									<%if(role==2){%>
                                    <td>
                                        <input name="date-chuyen" class="form-control" id="date-chuyen" type="date" required onchange="setDate()"/>
                                    </td>
                                    <td>
                                        <select name="time-chuyen" class="form-control">
                                            <option value="06:00:00">06:00:00</option>
                                            <option value="08:00:00">08:00:00</option>
                                        </select>
                                    </td>
									
                                    <td class="text-center">
                                        <button type="submit" class="btn btn-success">
                                            <span class="fa fa-pencil mr-5"></span>Thêm
                                        </button>
                                    </td>
									<%}%>
                                </tr>
							</form>
						</tbody>
                    </table>
                </div>
				</div>
				<%if(role==2){%>
				<div class="row mt-15">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <table class="table table-bordered table-hover">
                            <thead>			
								<tr>
									<td>Mã Xe</td>
									<td>Mã Tài Xế</td>
									<td>Thời gian</td>
									<td>Mã Chuyến</td>
									<td></td>
								</tr>
							</thead>
							<tbody>
								<%for(int j=0;j<listchuyen.size();j++){ %>
								<form action="UpdateChuyenControl" method="post">
								<tr>
									<td><%=listchuyen.get(j).getMaxe()%></td>
									<td>
										<select name='matx' class="form-control">
											<option value='<%=listchuyen.get(j).getMataixe()%>' selected><%=listchuyen.get(j).getMataixe()%></option>
											<%
											for(int i=0;i<listtaixe.size();i++){
											%>
                                            <option value='<%=listtaixe.get(i).getMa()%>'><%=listtaixe.get(i).getTentaixe()%></option>
                                            <%}										
											%>
                                        </select>
									</td>
									<td><%=listchuyen.get(j).getNgay()%></td>
									<td><%=listchuyen.get(j).getMachuyen()%></td>		
									<td class="text-center">
										<input type="hidden" class="chuyen" name="chuyen" id="chuyen" value=<%=listchuyen.get(j).getMachuyen()%>></input>
										<input type="submit" class="btn btn-danger" name="act" value="Delete"></input>
										<input type="submit" class="btn btn-success" name="act" value="Update"></input>
									</td>
								</tr>
								</form>
								<%}%>
							
                            </tbody>
                        </table>
                    </div>
                </div>
				<%}}%>
            </div>
        </div>
    </div>
	<script type="text/javascript" src="resources/js/nhansu.js"></script>
    <script src="//code.jquery.com/jquery.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
</body>

</html>