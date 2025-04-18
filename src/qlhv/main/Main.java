
package qlhv.main;

import qlhv.view.DangNhapJDialog;
import qlhv.view.MainJFrame;

/**
 *
 * @author VU THANH HAI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //    new MainJFrame().setVisible(true);
        DangNhapJDialog dialog;
        dialog = new DangNhapJDialog(null,true);
        dialog.setTitle("Đăng Nhập Hệ Thống");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
       
    }
    
}
