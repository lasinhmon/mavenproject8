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
import javax.servlet.http.HttpSession;

/**
 *
 * @author lasin
 */
@WebServlet("/ActionControl")
public class ActionControl extends HttpServlet{
    private DAO testdao;
    private SimpleDAO testsimpledao;
    public void init(){
        testdao=new DAO();
        testsimpledao=new SimpleDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String ve="",soghe="",chuyen="";
        try{
        ve=req.getParameter("ve");
        
        soghe=req.getParameter("soghe");
        chuyen=req.getParameter("chuyen");
        String act=req.getParameter("act");
            if(act.equals("Delete")){
                int rows=testdao.huyCho(Integer.parseInt(ve), Integer.parseInt(chuyen), soghe);
            }
            else if(act.equals("Update")){
                int rows=testdao.suaCho(Integer.parseInt(ve), Integer.parseInt(chuyen), soghe);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{                        
            List<Ghe>list=new ArrayList<>();
            int ind=Integer.parseInt(chuyen)-1;
          //  System.out.println(so);
            list=testsimpledao.getListGheByOffset(ind);
            req.setAttribute("offset", ind);
            req.setAttribute("list", list);
            //so=testdao.getVe(sdt);
            RequestDispatcher dispatch = req.getRequestDispatcher("/nhanvien.jsp");
            dispatch.forward(req, res);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
