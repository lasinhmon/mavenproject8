/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DAO;
import entity.Chang;
import entity.Chuyen;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
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
@WebServlet("/GheControl")
public class GheControl extends HttpServlet{
    private DAO testdao;
    public void init(){
        testdao=new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
// phai lay dc so ghe da lay dc
// phai lay dc ngay gio cua xe
// phai lay duoc ga di ga den
        HttpSession se=req.getSession();
        String soghedi="",giadi="",ngdi="";
        String ta=(String)se.getAttribute("ancom");
        //1 hoac ngay 
        String tam=req.getParameter("total-ghe");
        String ng=(String)req.getParameter("ngaydi");
        System.out.println(ng);
        long milliSeconds= Long.parseLong(ng);
        LocalDateTime triggerTime =
        LocalDateTime.ofInstant(Instant.ofEpochMilli(milliSeconds), 
                                ZoneId.systemDefault());  
        String formattedString = triggerTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH")); 
        String gd=(String)req.getParameter("gadi");
        String gden=(String)req.getParameter("gaden");
        String gia=(String)req.getParameter("gia");
        req.setAttribute("ngaydi",formattedString);
        req.setAttribute("ngayve",ta);
        req.setAttribute("soghe", tam);
        req.setAttribute("gadi", gd);
        req.setAttribute("gaden", gden);
        req.setAttribute("gia", gia);
        if((String)se.getAttribute("ngdi")!=null){
            ngdi=(String)se.getAttribute("ngdi");
            giadi=(String)se.getAttribute("giadi");
            soghedi=(String)se.getAttribute("soghedi");
            HttpSession session=req.getSession();
            session.invalidate();
            req.setAttribute("ngdi",ngdi);
            req.setAttribute("giadi", giadi);
            req.setAttribute("soghedi", soghedi);
            System.out.println("ngay ve "+ng + "ngay di "+ngdi);
            RequestDispatcher dispatch = req.getRequestDispatcher("/thongtin.jsp");
            dispatch.forward(req, res);
            return;
        }
        if(ta.equals("1")){
            System.out.println("dc nha");
            RequestDispatcher dispatch = req.getRequestDispatcher("/thongtin.jsp");
            dispatch.forward(req, res);
        }
        else{
            RequestDispatcher dispatch = req.getRequestDispatcher("FromControl");
            dispatch.forward(req, res);
        }
    }
}
