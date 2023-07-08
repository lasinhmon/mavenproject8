/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DAO;
import dao.SimpleDAO;
import entity.TaiXe;
import entity.Xe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet("/NhanVienControl")
public class NhanVienControl extends HttpServlet {
    private DAO testdao;
    private SimpleDAO testsimpledao;
    public void init(){
        testdao=new DAO();
        testsimpledao=new SimpleDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
       // String ch=req.getParameter("NvChuyen"); 
        String tennv=req.getParameter("Uname"); 
        String sdtnv=req.getParameter("Sdt"); 
        String diachinv=req.getParameter("Addre"); 
        int rows=-1;
        if(req.getParameter("NvChuyen")==null){
            rows=testsimpledao.themNhanvien(tennv, sdtnv, diachinv);
        }
        else {
            rows=testsimpledao.themNhanVienChuyen(tennv, sdtnv, diachinv);
        }
       // System.out.println(rows);
        HttpSession session=req.getSession();
        List<Xe>listxe=new ArrayList<>();
        List<TaiXe>listtaixe=new ArrayList<>();
        session.removeAttribute("listxe");
        session.removeAttribute("listtaixe");     
        try{
            listxe=testsimpledao.getListXe();
            listtaixe=testsimpledao.getListTaiXe();           
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            session.setAttribute("listxe", listxe);
            session.setAttribute("listtaixe", listtaixe);
            res.sendRedirect(req.getContextPath() + "/nhansu.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
