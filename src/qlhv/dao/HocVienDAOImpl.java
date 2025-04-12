package qlhv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import qlhv.model.HocVien;
import java.sql.ResultSet;   
import java.sql.SQLException;

/**
 *
 * @author TRAN HOAN
 */
public class HocVienDAOImpl implements HocVienDAO{

    @Override
    public List<HocVien> getList() {
        try {
            Connection cons= DBConnect.getConnection();
            String sql= "SELECT * FROM db_qlhv.hoc_vien";
            List<HocVien> list= new ArrayList<>();
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                HocVien hocVien= new HocVien();
                hocVien.setMa_hoc_vien(rs.getInt("ma_hoc_vien"));
                hocVien.setHo_ten(rs.getString("ho_ten"));
                hocVien.setNgay_sinh(rs.getDate("ngay_sinh"));
                hocVien.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hocVien.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                hocVien.setDia_chi(rs.getString("dia_chi"));
                hocVien.setTinh_trang(rs.getBoolean("tinh_trang"));
                
                
                list.add(hocVien);
                
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args){
        HocVienDAO hocVienDAO= new HocVienDAOImpl();
        System.out.println(hocVienDAO.getList());
    }
    
}
