/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DAO;
import dao.SimpleDAO;
import entity.Chuyen;
import entity.TaiXe;
import entity.Xe;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import sun.java2d.pipe.SpanShapeRenderer;
/**
 *
 * @author lasin
 */
@WebServlet("/AddChuyenControl")
public class AddChuyenControl extends HttpServlet{
    private DAO testdao;
    private SimpleDAO testsimpledao;
    public void init(){
        testdao=new DAO();
        testsimpledao=new SimpleDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        //req.setCharacterEncoding("UTF-8");
        //res.setCharacterEncoding("UTF-8");
      
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session=req.getSession();
        List<Xe>listxe=new ArrayList<>();
        List<TaiXe>listtaixe=new ArrayList<>();
        List<Chuyen>listchuyen=new ArrayList<>();
        session.removeAttribute("listxe");
        session.removeAttribute("listtaixe");
        session.removeAttribute("listchuyen");
        String taixe=req.getParameter("ma"); 
        String xe=req.getParameter("xe");
        String ngay=req.getParameter("date-chuyen");
        String gio=req.getParameter("time-chuyen");
        String giove="";
        if(gio.equals("06:00:00"))
            giove="14:00:00";
        else if(gio.equals("08:00:00"))
            giove="16:00:00";
        String da=ngay+" "+gio;
        String dave=ngay+" "+giove;
        int rows=testdao.themChuyen(da, xe, taixe);
        int rows2=testdao.themChuyen(dave, xe, taixe);
    //    System.out.println(rows+" hehehe "+rows2);
        for(int i=1;i<=24;i++){
            int tam=testsimpledao.themGheDi(rows, i);
            System.out.println(tam);
        }
        for(int i=1;i<=24;i++){
            int tam=testsimpledao.themGheVe(rows2, i);
            System.out.println(tam);
        } 
        try{
            listxe=testsimpledao.getListXe();
            listtaixe=testsimpledao.getListTaiXe();
            listchuyen=testsimpledao.getListChuyen();
           // System.out.println(listchuyen.size());
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            
            session.setAttribute("listxe", listxe);
            session.setAttribute("listtaixe", listtaixe);
            session.setAttribute("listchuyen", listchuyen);
            res.sendRedirect(req.getContextPath() + "/nhansu.jsp");
        }
        
    }
}
