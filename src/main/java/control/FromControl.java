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
@WebServlet("/FromControl")
public class FromControl extends HttpServlet{
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
        String ngaydi=(String)req.getAttribute("ngaydi");
        String ngayve=(String)req.getAttribute("ngayve");
        String soghe=(String)req.getAttribute("soghe");
        String gadi=(String)req.getAttribute("gadi");
        String gaden=(String)req.getAttribute("gaden");
        String gia=(String)req.getParameter("gia");
        try{
            chang=testsimpledao.getChang(gaden,gadi);
            System.out.println(chang.getGadi());
           /* if(chang.getGadi().equals("TPHCM")||chang.getGadi().equals("BaoLoc")){
                if(!chang.getGadi().equals("TPHCM")&&!chang.getGaden().equals("DaLat")){
                    chuyen=testdao.getListChuyen("TPHCM", "DaLat", ngayve);               
                    ghe=testdao.getListGhe("TPHCM", "DaLat",chang.getGadi() , chang.getGaden(),ngayve);  
                }
                else {
                    chuyen=testdao.getListChuyen("TPHCM", "DaLat", ngayve);               
                    ghe=testdao.getListGhe2("TPHCM", "DaLat",ngayve);  
                    System.out.println(ghe.size());
                }
            }
            else if(chang.getGadi().equals("DaLat")||chang.getGadi().equals("BaoLoc")){
                if(!chang.getGadi().equals("DaLat")&&!chang.getGaden().equals("TPHCM")){
                    chuyen=testdao.getListChuyen("DaLat", "TPHCM", ngayve);               
                    ghe=testdao.getListGhe("DaLat", "TPHCM",chang.getGadi() , chang.getGaden(),ngayve);  
                }
                else{
                    chuyen=testdao.getListChuyen("DaLat", "TPHCM", ngayve);               
                    ghe=testdao.getListGhe2("DaLat", "TPHCM",ngayve);  
                    System.out.println(ghe.size());
                }
            }
*/
            if((chang.getGadi().equals("TPHCM") && chang.getGaden().equals("DaLat"))||(chang.getGadi().equals("DaLat") && chang.getGaden().equals("TPHCM"))){
                chuyen=testdao.getListChuyen(chang.getGadi(), chang.getGaden(), ngayve);               
                ghe=testdao.getListGhe2(chang.getGadi(), chang.getGaden(),ngayve);  
            }
            else{
                if((chang.getGadi().equals("TPHCM") && chang.getGaden().equals("BaoLoc"))||(chang.getGadi().equals("BaoLoc") && chang.getGaden().equals("DaLat"))){
                    chuyen=testdao.getListChuyen("TPHCM", "DaLat", ngayve);               
                    ghe=testdao.getListGhe("TPHCM", "DaLat",chang.getGadi() , chang.getGaden(),ngayve);  
                }
                else if((chang.getGadi().equals("DaLat") && chang.getGaden().equals("BaoLoc"))||(chang.getGadi().equals("BaoLoc") && chang.getGaden().equals("TPHCM"))){
                    chuyen=testdao.getListChuyen("DaLat", "TPHCM", ngayve);               
                    ghe=testdao.getListGhe("DaLat", "TPHCM",chang.getGadi() , chang.getGaden(),ngayve);  
                }
            }
            if(chang!=null&&chuyen!=null){
                System.out.println(ngaydi);
                HttpSession session=req.getSession();
                session.setAttribute("chang", chang);
                session.setAttribute("chuyen", chuyen);
                session.setAttribute("ghe", ghe);
                session.setAttribute("ngaydi",ngaydi);
                session.setAttribute("soghe", soghe);
                session.setAttribute("gia", gia);
                res.sendRedirect("lotrinh.jsp");
            }
            else{
                res.sendRedirect("index.jsp");
            }
        }
        catch(Exception e){

        }
        
    }
}
