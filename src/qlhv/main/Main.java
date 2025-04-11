/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.main;

import qlhv.view.DangNhapJDialog;

/**
 *
 * @author VU THANH HAI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DangNhapJDialog dialog;
        dialog = new DangNhapJDialog(null,true);
        dialog.setTitle("Đăng Nhập Hệ Thống");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
       
    }
    
}
