/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.sun.javafx.runtime.VersionInfo;
import dao.DAO;
import dao.SimpleDAO;
import entity.Chang;
import entity.Chuyen;
import java.io.IOException;
import java.util.Arrays;
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
@WebServlet("/LuuControl")
public class LuuControl extends HttpServlet{
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
        //ket noi co so du lieu
        int tongtt=0;
        String ngaydi=req.getParameter("ngaydi");        
        String soghe=req.getParameter("soghe");
        String gia=(String)req.getParameter("gia");
        
        String gadi=(String)req.getParameter("gadi");
        String gaden=(String)req.getParameter("gaden");
        String gadi2=gaden;
        String gaden2=gadi;
        String sdt=(String)req.getParameter("sdt");
        String ten=(String)req.getParameter("ten");
        String ngdi="",soghedi="",giadi="";
        String[] elements2=null,trailing2=null;
        String first2="";
        if(!((String)req.getParameter("ngdi")).equals("a")){
            ngdi=(String)req.getParameter("ngdi");
            soghedi=(String)req.getParameter("soghedi");
            giadi=(String)req.getParameter("giadi");
            elements2 = soghedi.split(" ");          
            first2 = elements2[0];
            trailing2 = Arrays.copyOfRange(elements2,0,elements2.length);
            tongtt+=tongtt+(Integer.parseInt(giadi)*elements2.length);
          //  System.out.println("ngay ve "+ngaydi + "ngay di "+ngdi);
        }
       
        String save=req.getParameter("save");
        int so=-1;
        String[] elements = soghe.split(" ");
        String first = elements[0];
        String[] trailing = Arrays.copyOfRange(elements,0,elements.length);
        tongtt=Integer.parseInt(gia)*elements.length;
        if(testsimpledao.checkSdt(sdt))
        {
            so=testdao.getVe(sdt);
        }
        else{
            System.out.println("khong ton tai");
            System.out.println(sdt+" "+ten);
            int kh=testdao.themKH(sdt, ten);
            so=testdao.getVe(sdt);
        }
        int rows=0,rows2=0,tt=-1;
        if(save.equals("Thanh Toan >")){
            tt=2; 
        } 
        else if(save.equals("Dat Cho >")){
            tt=1;
        }
        if((gadi.equals("TPHCM") && gaden.equals("DaLat"))||(gadi.equals("DaLat") && gaden.equals("TPHCM"))){
           // System.out.println("ay ne");
            for(int i=0;i<trailing.length;i++){
                System.out.println("ay nua ne");
                rows=testdao.datCho(so, ngaydi, trailing[i], gadi, gaden,tt);
            }
            if(!ngdi.equals("")){
                gadi=gadi2;
                gaden=gaden2;
                for(int i=0;i<trailing2.length;i++){
                    rows2=testdao.datCho(so, ngdi, trailing2[i], gaden, gadi,tt);
              
                }
            }
        }
        else{
            if((gadi.equals("BaoLoc") && gaden.equals("TPHCM"))||(gadi.equals("DaLat") && gaden.equals("BaoLoc"))){
                for(int i=0;i<trailing.length;i++){                
                    Chang ch=new Chang();
                    Chuyen chuyen=new Chuyen();
                    try{                                                   
                        ch=testsimpledao.getChang(gadi, gaden);
                        chuyen=testdao.getChuyen(ngaydi);
                        int xoa=testdao.xoaCho(trailing[i],chuyen.getMachuyen());        
                        int tao=testdao.taoCho(chuyen.getMachuyen(), trailing[i], ch.getMachang());
                        rows=testdao.datCho(so, ngaydi, trailing[i],gadi, gaden,tt);
                        Chang chconlai=new Chang();
                        if(gadi.equals("BaoLoc") && gaden.equals("TPHCM"))
                            chconlai=testsimpledao.getChang("DaLat", "BaoLoc");
                        else if(gadi.equals("DaLat") && gaden.equals("BaoLoc"))
                            chconlai=testsimpledao.getChang("BaoLoc", "TPHCM");
                        int taochoconlai=testdao.taoCho(chuyen.getMachuyen(), trailing[i], chconlai.getMachang());
                    }catch(Exception e){
                        System.out.println(e);
                    }                         
                }
                if(!ngdi.equals("")){
                    for(int i=0;i<trailing2.length;i++){
                        Chang ch=new Chang();
                        Chuyen chuyen=new Chuyen();
                        try{                                                               
                            ch=testsimpledao.getChang(gaden, gadi);
                            chuyen=testdao.getChuyen(ngdi);
                            int xoa=testdao.xoaCho(trailing2[i],chuyen.getMachuyen()); 
                            int tao=testdao.taoCho(chuyen.getMachuyen(), trailing2[i], ch.getMachang());
                            rows2=testdao.datCho(so, ngdi, trailing2[i],gaden, gadi,tt);
                            Chang chconlai=new Chang();
                            if(gadi.equals("BaoLoc") && gaden.equals("TPHCM"))
                                    //Chuyen chuyenconlai=new Chuyen();
                                chconlai=testsimpledao.getChang("BaoLoc", "DaLat");
                            else if(gadi.equals("DaLat") && gaden.equals("BaoLoc"))
                                chconlai=testsimpledao.getChang("TPHCM", "BaoLoc");
                                int taochoconlai=testdao.taoCho(chuyen.getMachuyen(), trailing2[i], chconlai.getMachang());
                            }catch(Exception e){
                                System.out.println(e);
                            }      
                        }
                    }
                }else if((gadi.equals("TPHCM") && gaden.equals("BaoLoc"))||(gadi.equals("BaoLoc") && gaden.equals("DaLat"))){
                    for(int i=0;i<trailing.length;i++){                      
                        Chang ch=new Chang();
                        Chuyen chuyen=new Chuyen();
                        try{                                                    
                            ch=testsimpledao.getChang(gadi, gaden);
                            chuyen=testdao.getChuyen(ngaydi);
                            int xoa=testdao.xoaCho(trailing[i],chuyen.getMachuyen());        
                            int tao=testdao.taoCho(chuyen.getMachuyen(), trailing[i], ch.getMachang());
                            rows=testdao.datCho(so, ngaydi, trailing[i],gadi, gaden,tt);
                            Chang chconlai=new Chang();
                            if(gadi.equals("TPHCM") && gaden.equals("BaoLoc"))
                                chconlai=testsimpledao.getChang("BaoLoc", "DaLat");
                            else if(gadi.equals("BaoLoc") && gaden.equals("DaLat"))
                                chconlai=testsimpledao.getChang("TPHCM", "BaoLoc");
                            int taochoconlai=testdao.taoCho(chuyen.getMachuyen(), trailing[i], chconlai.getMachang());
                        }catch(Exception e){
                            System.out.println(e);
                        }                         
                    } 
                    if(!ngdi.equals("")){
                        for(int i=0;i<trailing2.length;i++){
                            Chang ch=new Chang();
                            Chuyen chuyen=new Chuyen();
                            try{  
                                                              
                                ch=testsimpledao.getChang(gaden, gadi);
                                chuyen=testdao.getChuyen(ngdi);
                                int xoa=testdao.xoaCho(trailing2[i],chuyen.getMachuyen()); 
                                int tao=testdao.taoCho(chuyen.getMachuyen(), trailing2[i], ch.getMachang());
                                rows2=testdao.datCho(so, ngdi, trailing2[i],gaden, gadi,tt);
                                Chang chconlai=new Chang();
                            if(gadi.equals("TPHCM") && gaden.equals("BaoLoc"))
                                chconlai=testsimpledao.getChang("DaLat", "BaoLoc");
                            else if(gadi.equals("BaoLoc") && gaden.equals("DaLat"))
                                chconlai=testsimpledao.getChang("BaoLoc", "TPHCM");
                                int taochoconlai=testdao.taoCho(chuyen.getMachuyen(), trailing2[i], chconlai.getMachang());
                            }catch(Exception e){
                                System.out.println(e);
                            }      
                        }
                    }
                }
            }
        String tongt="";
        tongt=Integer.toString(tongtt);
        if(rows>0 || (rows>0 &&rows2>0)){
            req.setAttribute("res","ok");

        }else{
            req.setAttribute("res","fail");
        }
        req.setAttribute("txt_inv_mobile", sdt);
        req.setAttribute("txt_inv_customer", ten);
        req.setAttribute("vnp_OrderInfo", Integer.toString(so));
        req.setAttribute("amount",tongt );
        if(save.equals("Thanh Toan >")){
         
            RequestDispatcher dispatch = req.getRequestDispatcher("vnpay_pay.jsp");
            dispatch.forward(req, res); 
        } 
        else if(save.equals("Dat Cho >")){
            RequestDispatcher dispatch = req.getRequestDispatcher("hoanthanh.jsp");
            dispatch.forward(req, res);
        }
        // ho ten 
        // sdt
        //dia chi
        // so ve (so)
        //tong tien
      //  System.out.println("hehe"+tongtt);
      //  RequestDispatcher dispatch = req.getRequestDispatcher("vnpay_pay.jsp");
      //  dispatch.forward(req, res);
    }
}
