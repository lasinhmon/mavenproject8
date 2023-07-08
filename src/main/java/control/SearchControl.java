/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DAO;
import dao.SimpleDAO;
import entity.Chuyen;
import entity.Ghe;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet("/SearchControl")
public class SearchControl extends HttpServlet{
   private static Connection connection;
    private DAO testdao;
    private SimpleDAO testsimpledao;
    public void init(){
        testdao=new DAO();
        testsimpledao=new SimpleDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
        HttpSession session = req.getSession();
        List<Ghe>list = new ArrayList();
        list=testsimpledao.getListGhe();
       // System.out.println(list.size());
        String sear=req.getParameter("searchVe");
        String find=req.getParameter("find");
        List<Ghe>result=new ArrayList();
       // result=null;
        try{
            if(find.equals("Tim")){
                for(Ghe item : list){
                    if(item.getMave()== null)
                        continue;
                    else if(item.getMave().equals(sear)){
                        result.add(item);
                   }
                }
            }else if(find.equals("Thong ke ghe trong")){
              //  String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
              //  System.out.println("hehe"+date);
                String date=req.getParameter("todate");
              //  System.out.println("hihi"+datetam);
                for(Ghe item : list){              
                    List<Chuyen>listChuyen=testdao.getListChuyen3(date);
                    for(Chuyen itemchuyen:listChuyen){
                        if(item.getMachuyen()==itemchuyen.getMachuyen()&&item.getTrangthai()==0)
                            result.add(item);
                    }
                }
                
            }else if(find.equals("Thong ke ghe chua thanh toan")){
                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
              //  System.out.println(date);
                for(Ghe item : list){              
                    List<Chuyen>listChuyen=testdao.getListChuyen3(date);
                    for(Chuyen itemchuyen:listChuyen){
                        if(item.getMachuyen()==itemchuyen.getMachuyen()&&item.getTrangthai()==1)
                            result.add(item);
                    }
                }
                
            }
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
       // req.setAttribute("list", list);
        req.setAttribute("result", result);
        req.setAttribute("offset", 0);
        RequestDispatcher dispatch = req.getRequestDispatcher("/nhanvien.jsp");
        dispatch.forward(req, res);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
 
    }   
}
