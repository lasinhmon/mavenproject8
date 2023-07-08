/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DAO;
import dao.SimpleDAO;
import entity.Ghe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lasin
 */
@WebServlet("/PaginationControl")
public class PaginationControl extends HttpServlet{
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
        List<Ghe>list=new ArrayList<>();  
           
        String step=req.getParameter("step");
        System.out.println("ketq la"+step);
        String offset=req.getParameter("offset");//luon luon lon hon 1
        int sothuc=Integer.parseInt(offset)-1;
        if(step.equals("next")){
            System.out.println("kq la"+sothuc);
            list=testsimpledao.getListGheByOffset((sothuc+1)*24);           
            req.setAttribute("list", list);
            req.setAttribute("offset", sothuc+1);           
        }else if(step.equals("prev")){
            if(sothuc<=0){
                list=testsimpledao.getListGheByOffset(0);
                req.setAttribute("list", list);
                req.setAttribute("offset", 0);
            }
            else{
                list=testsimpledao.getListGheByOffset((sothuc-1)*24);
                req.setAttribute("list", list);
                req.setAttribute("offset", sothuc-1);
            }
        }
        else{
            sothuc=Integer.parseInt(step)-1;
            list=testsimpledao.getListGheByOffset((sothuc)*24);                       
            req.setAttribute("list", list);
            req.setAttribute("offset", sothuc);
        }

        RequestDispatcher dispatch = req.getRequestDispatcher("/nhanvien.jsp");
        dispatch.forward(req, res);
        System.out.println(step+""+offset);
    }
}
