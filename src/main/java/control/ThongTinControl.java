/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DAO;
import java.io.IOException;
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
@WebServlet("/ThongTinControl")
public class ThongTinControl extends HttpServlet{
    private DAO testdao;
    public void init(){
        testdao=new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       // Object tam=(Object)req.getParameter("tam");
        String ngaydi=req.getParameter("ngaydi");        
        String soghe=req.getParameter("soghe");
        String gia=(String)req.getParameter("gia");
        String gadi=(String)req.getParameter("gadi");
        String gaden=(String)req.getParameter("gaden");
        String sdt=(String)req.getParameter("sdt");
        String ten=(String)req.getParameter("ten");
        String diachi=(String)req.getParameter("diachi");
        String ngdi="",soghedi="",giadi="";
        String t="a";
        if(!((String)req.getParameter("ngdi")).equals(t)){
            ngdi=(String)req.getParameter("ngdi");
            soghedi=(String)req.getParameter("soghedi");
            giadi=(String)req.getParameter("giadi"); 
            req.setAttribute("ngdi",ngdi);
            req.setAttribute("soghedi", soghedi);
            req.setAttribute("giadi", giadi);
        }
        else{
            System.out.println("co gi dau");
        } 

     //   System.out.println(ngaydi+" "+soghe+" "+gaden+" "+gadi+" "+sdt+" "+ten+" "+diachi);
        req.setAttribute("ngaydi",ngaydi);
        req.setAttribute("soghe", soghe);
        req.setAttribute("gia", gia);
        req.setAttribute("gadi", gadi);
        req.setAttribute("gaden", gaden);
        req.setAttribute("sdt", sdt);
        req.setAttribute("ten", ten);
        req.setAttribute("diachi", diachi);
       
        RequestDispatcher dispatch = req.getRequestDispatcher("veinfo.jsp");
        dispatch.forward(req, res);
    }
    
}
