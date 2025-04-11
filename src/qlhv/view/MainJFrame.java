/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.view;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author VU THANH HAI
 */
public class MainJFrame extends javax.swing.JFrame {

    public MainJFrame() {
        initComponents();
        setTitle("QUẢN LÝ HỌC VIÊN");

        List<DanhMucBean> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new DanhMucBean("TrangChinh", jpnTrangChu, jlbTrangChu));
        listDanhMuc.add(new DanhMucBean("HocVien", jpnHocVien, jlbHocVien));

        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setDashboard(jpnTrangChu, jlbTrangChu);
        controller.setEvent(listDanhMuc);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
                 
}
