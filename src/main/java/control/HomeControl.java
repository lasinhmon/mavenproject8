/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DAO;
import dao.SimpleDAO;
import entity.Chang;
import entity.Chuyen;
import entity.Ghe;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author lasin
 */
@WebServlet("/HomeControl")
public class HomeControl extends HttpServlet{
    private static Connection connection;
    /*String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    String JDBC_URL="jdbc:mysql://localhost:3306/bai5_db";
    String JDBC_USER="root";
    String JDBC_PASS="1234";*/
    private DAO testdao;
    private SimpleDAO testsimpledao;
    public void init(){
        testdao=new DAO();
        testsimpledao=new SimpleDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Chang chang=new Chang();
        List<Chuyen> chuyen=new ArrayList<>();
        List<Ghe>ghe=new ArrayList<>();
        try{
            String b=req.getParameter("placeto");
            String c=req.getParameter("placefrom");
            String date=req.getParameter("todate");
            String fdate=req.getParameter("fromdate");
            //System.out.println(date);
            //System.out.println(fdate);
         
            chang=testsimpledao.getChang(b,c);
            if((chang.getGadi().equals("TPHCM") && chang.getGaden().equals("DaLat"))||(chang.getGadi().equals("DaLat") && chang.getGaden().equals("TPHCM"))){
                chuyen=testdao.getListChuyen(chang.getGadi(), chang.getGaden(), date);               
                ghe=testdao.getListGhe2(chang.getGadi(), chang.getGaden(),date);  
            }
            else{
                if((chang.getGadi().equals("TPHCM") && chang.getGaden().equals("BaoLoc"))||(chang.getGadi().equals("BaoLoc") && chang.getGaden().equals("DaLat"))){
                    chuyen=testdao.getListChuyen("TPHCM", "DaLat", date);               
                    ghe=testdao.getListGhe("TPHCM", "DaLat",chang.getGadi() , chang.getGaden(),date);  
                }
                else if((chang.getGadi().equals("DaLat") && chang.getGaden().equals("BaoLoc"))||(chang.getGadi().equals("BaoLoc") && chang.getGaden().equals("TPHCM"))){
                    chuyen=testdao.getListChuyen("DaLat", "TPHCM", date);               
                    ghe=testdao.getListGhe("DaLat", "TPHCM",chang.getGadi() , chang.getGaden(),date);  
                }
            }
          
            // tim ghe theo chuyen va chang
            
            if(chang!=null&&chuyen!=null){
                System.out.println("hehelst"+chuyen.size());
                HttpSession session=req.getSession();
                session.setAttribute("chang", chang);
                session.setAttribute("chuyen", chuyen);
                session.setAttribute("ghe", ghe);
                if(!fdate.equals("")){
                    session.setAttribute("fromdate", fdate);
                }
                res.sendRedirect("lotrinh.jsp");
            }
            else{
                res.sendRedirect("index.jsp");
            }
        }catch(Exception e){
             res.sendRedirect("index.jsp");
        }      
   
    }

    
}
