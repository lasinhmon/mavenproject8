/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import DBContext.Connect;
import entity.Chang;
import entity.Chuyen;
import entity.Ghe;
import entity.NhanSu;
import entity.NhanVien;
import entity.TaiXe;
import entity.Xe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lasin
 */
public class SimpleDAO {
     public List<Chang> getListChang() throws SQLException{
        
        List<Chang> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
            stmt=conn.prepareStatement("select MaChang, GaDi, GaDen, Gia from Chang");
            rs=stmt.executeQuery();
            while(rs.next()){
                Chang chang=new Chang();
                chang.setMachang(rs.getString(1));
                chang.setGadi(rs.getString(2));
                chang.setGaden(rs.getString(3));
                chang.setGia(rs.getInt(4));
                list.add(chang);
            }
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, stmt, rs);
        }
        return list;
    }
     public List<Xe> getListXe() throws SQLException{
        
        List<Xe> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
            stmt=conn.prepareStatement("select MaXe, BienSoXe from Xe");
            rs=stmt.executeQuery();
            while(rs.next()){
                Xe xe=new Xe();
                xe.setMaxe(rs.getString(1));
                xe.setBiensoxe(rs.getString(2));
                list.add(xe);
            }          
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, stmt, rs);
        }
        return list;
    }
      public List<TaiXe> getListTaiXe() throws SQLException{
        
        List<TaiXe> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
            stmt=conn.prepareStatement("select MaTaiXe, TenTaiXe, SDTtx from TaiXe");
            rs=stmt.executeQuery();
            while(rs.next()){
                TaiXe taixe=new TaiXe();
                taixe.setMa(rs.getString(1));
                taixe.setTentaixe(rs.getString(2));
                taixe.setSdt(rs.getString(3));
                list.add(taixe);
            }
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, stmt, rs);
        }
        return list;
    }
    public List<Ghe> getListGheByOffset(int offset){
        List<Ghe> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
       
            stmt=conn.prepareStatement("SELECT SoGhe, MaChang, TrangThai, MaChuyen, MaVe FROM SoGhe LIMIT 24 OFFSET ?;");
            stmt.setInt(1, offset);
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
            closeConnect(conn, stmt, rs);
        }       
        return list;
    }
    public List<Ghe> getListGhe(){
        List<Ghe> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
       
            stmt=conn.prepareStatement("SELECT SoGhe, MaChang, TrangThai, MaChuyen, MaVe FROM SoGhe;");
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
            closeConnect(conn, stmt, rs);
        }       
        return list;
    }
    public List<Chuyen> getListChuyen(){
        List<Chuyen> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
       
            stmt=conn.prepareStatement("select distinct c.MaChuyen,c.NgayGio,x.BienSoXe,tx.TenTaiXe from Chuyen c inner join TaiXe tx on tx.MaTaiXe=c.MaTaiXe inner join Xe x on x.MaXe=c.MaXe where c.DaXoa=0 order by c.MaChuyen");
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
            closeConnect(conn, stmt, rs);
        }       
        return list;
    }
     public Chang getChang(String gadi,String gaden) throws SQLException{
        
        Chang chang=new Chang();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
       
            stmt=conn.prepareStatement("select * from Chang where GaDi=? and GaDen=?");
            stmt.setString(1, gadi);
            stmt.setString(2, gaden);
            rs=stmt.executeQuery();
            while(rs.next()){
                chang.setMachang(rs.getString(1));
                chang.setGadi(rs.getString(2));
                chang.setGaden(rs.getString(3));
                chang.setGia(rs.getInt(4));
                return chang;
            }
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, stmt, rs);
        }
        return null;
    }
      public boolean checkSdt (String sdt){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
            stmt=conn.prepareStatement("SELECT SDT from KhachHang WHERE SDT=?");
            stmt.setString(1, sdt);
            rs=stmt.executeQuery();  
            if(rs.next())
                return true;               
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, stmt, rs);
        }       
        return false;
    }
    public NhanVien checkNv (String sdt){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=Connect.getConnection();
            stmt=conn.prepareStatement("SELECT SDT,Ten,DiaChi from NhanVien WHERE SDT=?");
            stmt.setString(1, sdt); 
            System.out.println("dhjfgdbas,d"+stmt);
            rs=stmt.executeQuery(); 
            NhanVien nv=new NhanVien(); 
            if(rs.next()){
                nv.setSdt(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setDiachi(rs.getString(3));
            }     
            return nv;       
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, stmt, rs);
        }       
        return null;
    }
    public NhanSu checkNs (String sdt){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        int rol=0;
        
        try{
            conn=Connect.getConnection();
            stmt=conn.prepareStatement("SELECT SDT,Ten,DiaChi,Rol from NhanSu WHERE SDT=?");
            stmt.setString(1, sdt);
            System.out.println("dhjfgdbas,d"+stmt);
            rs=stmt.executeQuery();
            NhanSu ns=new NhanSu();  
            if(rs.next()){             
                ns.setSdt(rs.getString(1));
                ns.setTen(rs.getString(2));
                ns.setDiachi(rs.getString(3));
                ns.setRole(rs.getInt(4));
            }
            return ns;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, stmt, rs);
        }       
        return null;
    }
    public int themTaixe(String ten,String sdt){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        int rows=0;
        try{
            conn=Connect.getConnection();
            String sql="INSERT INTO TaiXe VALUES (null,?,?);";
            st=conn.prepareStatement(sql);
            st.setString(1, ten); 
            st.setString(2, sdt);         
            rows=st.executeUpdate();  
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, st, rs);
        }       
        return rows;
    } 
    public int themNhanVienChuyen(String ten,String sdt,String diachi){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        int rows=0;
        try{
            conn=Connect.getConnection();
            String sql="INSERT INTO NhanSu VALUES (?,?,?,2);";
            st=conn.prepareStatement(sql);
            st.setString(1, sdt); 
            st.setString(2, ten);   
            st.setString(3, diachi);         
            rows=st.executeUpdate();  
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, st, rs);
        }       
        return rows;
    } 
    public int themNhanvien(String ten,String sdt,String diachi){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        int rows=0;
        try{
            conn=Connect.getConnection();
            String sql="INSERT INTO NhanVien VALUES (?,?,?);";
            st=conn.prepareStatement(sql);
            st.setString(1, sdt); 
            st.setString(2, ten);
            st.setString(3, diachi);          
            rows=st.executeUpdate();  
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, st, rs);
        }       
        return rows;
    } 
    public int themXe(String bsx){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        int rows=0;
        try{
            conn=Connect.getConnection();
            String sql="INSERT INTO Xe VALUES (null,?);";
            st=conn.prepareStatement(sql);
            st.setString(1, bsx);     
            rows=st.executeUpdate();  
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, st, rs);
        }       
        return rows;
    } 
    public int themGheDi(int machuyen,int so){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        int rows=0;
        try{
            conn=Connect.getConnection();
            String sql="INSERT INTO SoGhe VALUES (?,?,null,'CH01',0);";
            st=conn.prepareStatement(sql);
            st.setInt(1, machuyen);
            st.setInt(2, so);     
            rows=st.executeUpdate();  
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, st, rs);
        }       
        return rows;
    }
    public int themGheVe(int machuyen,int so){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        int rows=0;
        try{
            conn=Connect.getConnection();
            String sql="INSERT INTO SoGhe VALUES (?,?,null,'CH04',0);";
            st=conn.prepareStatement(sql);
            st.setInt(1, machuyen);
            st.setInt(2, so);     
            rows=st.executeUpdate();  
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, st, rs);
        }       
        return rows;
    }
    public int UpdateChuyen(String machuyen, String maten){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        int rows=0;
        try{
            conn=Connect.getConnection();
            String sql="UPDATE Chuyen set MaTaiXe=? where MaChuyen=?;";
            st=conn.prepareStatement(sql);
            st.setString(1, maten);
            st.setString(2, machuyen);     
            rows=st.executeUpdate();  
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, st, rs);
        }       
        return rows;
    }
    public int DeleteChuyen(String machuyen){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        int rows=0;
        try{
            conn=Connect.getConnection();
            String sql="UPDATE Chuyen set DaXoa=1 where MaChuyen=?;";
            st=conn.prepareStatement(sql);
            st.setString(1, machuyen);     
            rows=st.executeUpdate();  
            return rows;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            closeConnect(conn, st, rs);
        }       
        return rows;
    }
    public void closeConnect(Connection conn,PreparedStatement st,ResultSet rs){
        Connect.close(rs);
        Connect.close(st);
        Connect.close(conn);
    }
}
