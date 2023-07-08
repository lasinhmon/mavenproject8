/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Chang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DBContext.Connect;
import entity.Chuyen;
import entity.Ghe;
import entity.TaiXe;
import entity.Xe;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/**
 *
 * @author lasin
 */
public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    public List<Chuyen> getListChuyen2(String gadi,String gaden, String ngay)throws SQLException{
        List<Chuyen> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();       
            stmt=conn.prepareStatement("select distinct ch.MaChuyen, ch.NgayGio, ch.MaXe, ch.MaTaiXe from Chuyen ch inner join SoGhe sg on sg.MaChuyen=ch.MaChuyen inner join Chang c on c.MaChang=sg.MaChang where c.GaDi=? and c.GaDen=? and DATE(ch.NgayGio) = ?");
            stmt.setString(1, gadi);
            stmt.setString(2, gaden);
            stmt.setString(3, ngay);
            rs=stmt.executeQuery();           
            while(rs.next()){
                Chuyen tam=new Chuyen();
                tam.setMachuyen(rs.getInt(1));
                Timestamp timestamp = rs.getTimestamp(2); 
                tam.setNgay(rs.getTimestamp(2));
                tam.setMaxe(rs.getString(3));
                tam.setMataixe(rs.getString(4));
                list.add(tam); 
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(stmt);
            Connect.close(conn);
        }        
        return list;
    }
    public List<Chuyen> getListChuyen(String gadi,String gaden, String ngay)throws SQLException{
        List<Chuyen> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();      
            stmt=conn.prepareStatement("select distinct ch.MaChuyen, ch.NgayGio, ch.MaXe, ch.MaTaiXe from Chuyen ch inner join SoGhe sg on sg.MaChuyen=ch.MaChuyen inner join Chang c on c.MaChang=sg.MaChang where c.GaDi=? and c.GaDen=? and DATE(ch.NgayGio) = ?");
            stmt.setString(1, gadi);
            stmt.setString(2, gaden);
            stmt.setString(3, ngay);
            rs=stmt.executeQuery();           
            while(rs.next()){
                Chuyen tam=new Chuyen();
                tam.setMachuyen(rs.getInt(1));
                Timestamp timestamp = rs.getTimestamp(2); 
                tam.setNgay(rs.getTimestamp(2));
                tam.setMaxe(rs.getString(3));
                tam.setMataixe(rs.getString(4));
                list.add(tam); 
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(stmt);
            Connect.close(conn);
        }       
        return list;
    }
    public List<Chuyen> getListChuyen3(String ngay)throws SQLException{
        List<Chuyen> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();       
            stmt=conn.prepareStatement("select distinct ch.MaChuyen, ch.NgayGio, ch.MaXe, ch.MaTaiXe from Chuyen ch inner join SoGhe sg on sg.MaChuyen=ch.MaChuyen inner join Chang c on c.MaChang=sg.MaChang where DATE(ch.NgayGio) = ?");
            stmt.setString(1, ngay);
            rs=stmt.executeQuery();      
            while(rs.next()){
                Chuyen tam=new Chuyen();
                tam.setMachuyen(rs.getInt(1));
                Timestamp timestamp = rs.getTimestamp(2); 
                tam.setNgay(rs.getTimestamp(2));
                tam.setMaxe(rs.getString(3));
                tam.setMataixe(rs.getString(4));
                list.add(tam); 
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(stmt);
            Connect.close(conn);
        }       
        return list;
    }
    public Chuyen getChuyen(String ngay)throws SQLException{
        Chuyen chuyen=new Chuyen();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();      
            stmt=conn.prepareStatement("select distinct ch.MaChuyen, ch.NgayGio, ch.MaXe, ch.MaTaiXe from Chuyen ch inner join SoGhe sg on sg.MaChuyen=ch.MaChuyen inner join Chang c on c.MaChang=sg.MaChang where ch.NgayGio = ?");
            stmt.setString(1, ngay);
            rs=stmt.executeQuery();           
            while(rs.next()){
                chuyen.setMachuyen(rs.getInt(1));
                Timestamp timestamp = rs.getTimestamp(2); 
                chuyen.setNgay(rs.getTimestamp(2));
                chuyen.setMaxe(rs.getString(3));
                chuyen.setMataixe(rs.getString(4));
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(stmt);
            Connect.close(conn);
        }       
        return chuyen;
    }
    public List<Ghe> getListGhe(String gadi,String gaden,String changdi,String changden, String todate)throws SQLException{
        List<Ghe> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();      
            stmt=conn.prepareStatement("select sg.SoGhe, sg.MaChang, sg.TrangThai,sg.MaChuyen,sg.MaVe\n" +
                                       "from SoGhe sg\n" +
                                       "inner join Chang c on c.MaChang=sg.MaChang\n" +
                                       "inner join Chuyen ch on sg.MaChuyen=ch.MaChuyen\n" +
                                       "where c.GaDi=? and c.GaDen=? and DATE(ch.NgayGio) = ? and sg.TrangThai=1 or sg.TrangThai=2\n" +
                                       "union(\n" +
                                       "select sg.SoGhe, sg.MaChang, sg.TrangThai,sg.MaChuyen,sg.MaVe\n" +
                                       "from SoGhe sg\n" +
                                       "inner join Chang c on c.MaChang=sg.MaChang\n" +
                                       "inner join Chuyen ch on sg.MaChuyen=ch.MaChuyen\n" +
                                       "where c.GaDi=? and c.GaDen=? and DATE(ch.NgayGio) = ? and sg.TrangThai=1 or sg.TrangThai=2)");
            stmt.setString(1, gadi);
            stmt.setString(2, gaden);
            stmt.setString(3, todate);
            stmt.setString(4, changdi);
            stmt.setString(5, changden);
            stmt.setString(6, todate);
            rs=stmt.executeQuery();         
            while(rs.next()){
                Ghe tam=new Ghe();
                tam.setSoghe(rs.getInt(1));
                tam.setMachang(rs.getString(2));
                tam.setTrangthai(rs.getInt(3));
                tam.setMachuyen(rs.getInt(4));
                tam.setMave(rs.getString(5));
                list.add(tam); 
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(stmt);
            Connect.close(conn);
        }      
        return list;
    }
    public List<Ghe> getListGhe2(String gadi,String gaden, String todate)throws SQLException{
        List<Ghe> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();     
            stmt=conn.prepareStatement("select sg.SoGhe, sg.MaChang, sg.TrangThai,sg.MaChuyen,sg.MaVe\n" +
                                       "from SoGhe sg\n" +
                                       "inner join Chang c on c.MaChang=sg.MaChang\n" +
                                       "inner join Chuyen ch on sg.MaChuyen=ch.MaChuyen\n" +
                                       "where c.GaDi=? and c.GaDen=? and DATE(ch.NgayGio) = ? and sg.TrangThai=1 or sg.TrangThai=2\n" +
                                       "union(\n" +
                                       "select sg.SoGhe, sg.MaChang, sg.TrangThai,sg.MaChuyen,sg.MaVe\n" +
                                       "from SoGhe sg\n" +
                                       "inner join Chang c on c.MaChang=sg.MaChang\n" +
                                       "inner join Chuyen ch on sg.MaChuyen=ch.MaChuyen\n" +
                                       "where DATE(ch.NgayGio) = ? and sg.TrangThai=1 or sg.TrangThai=2)");
            stmt.setString(1, gadi);
            stmt.setString(2, gaden);
            stmt.setString(3, todate);
            stmt.setString(4, todate);
            rs=stmt.executeQuery();         
            while(rs.next()){
                Ghe tam=new Ghe();
                tam.setSoghe(rs.getInt(1));
                tam.setMachang(rs.getString(2));
                tam.setTrangthai(rs.getInt(3));
                tam.setMachuyen(rs.getInt(4));
                tam.setMave(rs.getString(5));
                list.add(tam); 
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(stmt);
            Connect.close(conn);
        }       
        return list;
    }
    public int themKH(String sdt,String ten){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        int rows=0;
        try{
            conn=Connect.getConnection();
            String sql="INSERT INTO KhachHang VALUES (?,?,null);";
            st=conn.prepareStatement(sql);
            st.setString(1, sdt); 
            st.setString(2, ten);            
            rows=st.executeUpdate();  
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(st);
            Connect.close(conn);
        }       
        return rows;
    } 
    public int themChuyen(String date,String xe,String ma){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        int rows=0;
        try{
            conn=Connect.getConnection();
            String sql="INSERT INTO Chuyen VALUES (null,?,?,?,0);";
            st=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setString(1, date); 
            st.setString(2, xe); 
            st.setString(3, ma);           
            rows=st.executeUpdate();  
            if(rows==0)
                throw new SQLException("Fail");
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(st);
            Connect.close(conn);
        }       
        return -1;
    } 
    public int getVe(String sdt){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
            String sql="INSERT INTO Ve VALUES (null,?);";
            st=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setString(1, sdt);            
            int rows=st.executeUpdate();  
            if(rows==0)
                throw new SQLException("Fail");
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
                
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(st);
            Connect.close(conn);
        }       
        return -1;
    }
    public int datCho(int mave,String ngaygio,String soghe,String gadi,String gaden,int so){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
       
            st=conn.prepareStatement("update SoGhe   \n" +
                                     "SET TrangThai=?,\n" +
                                     "MaVe=?\n" +
                                     "where MaChuyen=(select MaChuyen from Chuyen where NgayGio=?)\n" +
                                     "and SoGhe=? and MaChang=(select MaChang from Chang where GaDi=? and GaDen=?)");
            st.setInt(1, so);
            st.setInt(2, mave);
            st.setString(3, ngaygio);
            st.setString(4, soghe);
            st.setString(5, gadi);
            st.setString(6, gaden);
            System.out.println(st);
            int rows=st.executeUpdate();  
            System.out.println("dat cho thanh cong");
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(st);
            Connect.close(conn);
        }       
        return -1;

    }
    public int huyCho(int mave,int machuyen,String soghe){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
       
            st=conn.prepareStatement("update SoGhe   \n" +
                                     "SET TrangThai=0, MaVe=null\n" +
                                     "where MaVe=? and MaChuyen=? \n" +
                                     "and SoGhe=? ");
            st.setInt(1, mave);
            st.setInt(2, machuyen);
            st.setString(3, soghe);
            int rows=st.executeUpdate();  
            System.out.println("huy cho thanh cong");
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(st);
            Connect.close(conn);
        }       
        return -1;
    }
    public int suaCho(int mave,int machuyen,String soghe){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();      
            st=conn.prepareStatement("update SoGhe   \n" +
                                     "SET TrangThai=2 \n" +
                                     "where MaVe=? and MaChuyen=? \n" +
                                     "and SoGhe=? ");
            st.setInt(1, mave);
            st.setInt(2, machuyen);
            st.setString(3, soghe);
            int rows=st.executeUpdate();  
            System.out.println("sua cho thanh cong");
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(st);
            Connect.close(conn);
        }       
        return -1;
    }
    public int taoCho(int machuyen,String soghe,String machang){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();      
            st=conn.prepareStatement("INSERT INTO SoGhe values(?,?,null,?,0);");
            st.setInt(1, machuyen);
            st.setString(2, soghe);
            st.setString(3, machang);
            int rows=st.executeUpdate();  
            System.out.println("tao cho thanh cong");
            return rows;
        }catch(SQLException e){
            System.out.println("tao cho k thanh cong");
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(st);
            Connect.close(conn);
        }       
        return -1;
    }
    public int xoaCho(String soghe,int machuyen){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();       
            st=conn.prepareStatement("delete from SoGhe where SoGhe=? and MaChuyen=?");
            st.setString(1, soghe);
            st.setInt(2, machuyen);
            int rows=st.executeUpdate();  
            System.out.println("xoa cho thanh cong"+rows);
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Connect.close(rs);
            Connect.close(st);
            Connect.close(conn);
        }       
        return -1;
    }  
}
