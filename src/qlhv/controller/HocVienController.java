package qlhv.controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import qlhv.model.HocVien;
import qlhv.service.HocVienService;
import qlhv.service.HocVienServiceImpl;

/**
 *
 * @author TRAN HOAN
 */
public class HocVienController {
    private  JButton btnSubmit;
    private JTextField jtfMaHocVien;
    private  JTextField jtfHoTen;
    private  JDateChooser jdcNgaySinh;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private JTextField jtfSoDienThoai;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbTinhTrang;  
    private JLabel jlbErrorNgaySinh;
    private JLabel jlbErrorHoTen;
    private JLabel jlbMsg; 
    
    private HocVien hocVien= null;
    
    private HocVienService hocVienService= null;

    public HocVienController(JButton btnSubmit, JTextField jtfMaHocVien, JTextField jtfHoTen, JDateChooser jdcNgaySinh, JRadioButton jrdNam,
            JRadioButton jrdNu, JTextField jtfSoDienThoai, JTextArea jtaDiaChi, JCheckBox jcbTinhTrang, JLabel jlbMsg, JLabel jlbErrorNgaySinh, JLabel jlbErrorHoTen) {
        this.btnSubmit = btnSubmit;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbErrorNgaySinh= jlbErrorNgaySinh;
        this.jlbErrorHoTen= jlbErrorHoTen;
        this.jlbMsg = jlbMsg;
        
        this.hocVienService= new HocVienServiceImpl();
    }

    public void setView(HocVien hocVien){
        this.hocVien= hocVien;
        jtfMaHocVien.setText("#"+hocVien.getMa_hoc_vien());
        jtfHoTen.setText(hocVien.getHo_ten());
        jdcNgaySinh.setDate(hocVien.getNgay_sinh());
        if(hocVien.isGioi_tinh()){
            jrdNam.setSelected(true);
            jrdNu.setSelected(false);
        }
        else{
            jrdNam.setSelected(false);
            jrdNu.setSelected(true);
        }
        jtfSoDienThoai.setText(hocVien.getSo_dien_thoai());
        jtaDiaChi.setText(hocVien.getDia_chi());
        jcbTinhTrang.setSelected(hocVien.isTinh_trang());
    }
    
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfHoTen.getText().length()==0 || jdcNgaySinh.getDate()== null){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    if(jtfHoTen.getText().length()==0){
                        jlbErrorHoTen.setText("*Vui lòng nhập họ tên.");
                    }
                    else{
                        jlbErrorHoTen.setText("");
                        }
                    if(jdcNgaySinh.getDate()== null){
                        jlbErrorNgaySinh.setText("*Vui lòng nhập ngày sinh.");
                    }
                    else{
                        jlbErrorNgaySinh.setText("");
                    }
                }
                else{
                    hocVien.setHo_ten(jtfHoTen.getText());
                    hocVien.setNgay_sinh(new java.sql.Date(jdcNgaySinh.getDate().getTime()));
                    hocVien.setGioi_tinh(jrdNam.isSelected());
                    hocVien.setSo_dien_thoai(jtfSoDienThoai.getText());
                    hocVien.setDia_chi(jtaDiaChi.getText());
                    hocVien.setTinh_trang(jcbTinhTrang.isSelected());
                    int lastId= hocVienService.createOrUpdate(hocVien);
                    
                    if(lastId>0){
                        hocVien.setMa_hoc_vien(lastId);
                        jtfMaHocVien.setText("#"+lastId);
                       jlbMsg.setText("Cập nhật dữ liệu thành công!"); 
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
            
        });
    }
    
}