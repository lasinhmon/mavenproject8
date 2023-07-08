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
@WebServlet("/UpdateChuyenControl")
public class UpdateChuyenControl extends HttpServlet{
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
        HttpSession session=req.getSession();        
        List<Xe>listxe=new ArrayList<>();
        List<TaiXe>listtaixe=new ArrayList<>();
        List<Chuyen>listchuyen=new ArrayList<>();
        session.removeAttribute("listxe");
        session.removeAttribute("listtaixe");
        session.removeAttribute("listchuyen");
        String taixe=req.getParameter("matx");
        String machuyen=req.getParameter("chuyen");
        int tam=Integer.parseInt(machuyen);
        String m="";
        if(tam%2==0)
            m=Integer.toString(tam-1);
        else
            m=Integer.toString(tam+1);
        if(req.getParameter("act").equals("Update")){     
            int rows=testsimpledao.UpdateChuyen(machuyen, taixe);
            int rows2=testsimpledao.UpdateChuyen(m, taixe);
        }else{
            int rows=testsimpledao.DeleteChuyen(machuyen);
            int rows2=testsimpledao.DeleteChuyen(m);
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
