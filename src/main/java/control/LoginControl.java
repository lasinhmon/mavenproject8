/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DAO;
import dao.SimpleDAO;
import entity.Chuyen;
import entity.Ghe;
import entity.NhanSu;
import entity.NhanVien;
import entity.TaiXe;
import entity.Xe;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lasin
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet{
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
        String sdt=req.getParameter("num");
        List<Ghe>list=new ArrayList<>();
        NhanSu ns=new NhanSu();  
        NhanVien nv=new NhanVien();  
        nv=testsimpledao.checkNv(sdt);
        HttpSession session=req.getSession();
        //System.out.println(nv.getTen());
        if(nv.getSdt()!=null){
            list=testsimpledao.getListGheByOffset(0);
            req.setAttribute("offset", 0);
            req.setAttribute("list", list);
            session.setAttribute("acc", nv.getTen());
            RequestDispatcher dispatch = req.getRequestDispatcher("/nhanvien.jsp");
            dispatch.forward(req, res);
        }
        else {
            ns=testsimpledao.checkNs(sdt);
            if(testsimpledao.checkNs(sdt)!=null){
                if(ns.getRole()>0){
                    
                    List<Xe>listxe=new ArrayList<>();
                    List<TaiXe>listtaixe=new ArrayList<>();
                    List<Chuyen>listchuyen=new ArrayList<>();
                    try{
                    listxe=testsimpledao.getListXe();
                    listtaixe=testsimpledao.getListTaiXe();
                    listchuyen=testsimpledao.getListChuyen();
                    session.setAttribute("listxe", listxe);
                    session.setAttribute("listtaixe", listtaixe);
                    session.setAttribute("listchuyen", listchuyen);
                    session.setAttribute("role", ns.getRole());
                    session.setAttribute("acc", ns.getTen());
                    RequestDispatcher dispatch1 = req.getRequestDispatcher("/nhansu.jsp");
                    dispatch1.forward(req, res);
                    }
                    catch(Exception e){
                        res.sendRedirect("index.jsp");
                    }
                }
            }
            else{
                res.sendRedirect("index.jsp");
            }
        }    
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
    }
}
