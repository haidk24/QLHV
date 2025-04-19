package qlhv.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import qlhv.model.HocVien;
import qlhv.service.HocVienService;
import qlhv.service.HocVienServiceImpl;
import qlhv.untility.ClassTableModel;
import qlhv.view.HocVienAddJFrame;
import qlhv.view.HocVienJFrame;

/**
 *
 * @author TRAN HOAN
 */
public class QuanLyHocVienController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JButton btnPrint;
    
    private HocVienService hocVienService= null;
    
    private String[] listColumn = {"Mã học viên", "STT", "Họ và tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Tình trạng"}; 
    
    private TableRowSorter<TableModel> rowSorter= null;

    public QuanLyHocVienController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JButton btnPrint ) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.btnPrint = btnPrint;
        
        this.hocVienService= new HocVienServiceImpl();
    }
    
    public void setDateToTable(){
        List<HocVien> listItem = hocVienService.getList();
        
        DefaultTableModel model = new  ClassTableModel().setTableHocVien(listItem, listColumn);
        JTable table = new JTable(model);
        
        rowSorter = new  TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { 
                String text = jtfSearch.getText();
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                }
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ text,0));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                }
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i"+ text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()== 2 && table.getSelectedRow()!= -1){
                    DefaultTableModel model= (DefaultTableModel) table.getModel();
                    int selectedRowIndex= table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    System.out.println(selectedRowIndex);
                    
                    HocVien hocVien= new HocVien();
                    hocVien.setMa_hoc_vien((int) model.getValueAt(selectedRowIndex, 0));
                    hocVien.setHo_ten(model.getValueAt(selectedRowIndex, 2).toString());
                    hocVien.setNgay_sinh((Date) model.getValueAt(selectedRowIndex, 3));
                    hocVien.setGioi_tinh(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam"));
                    hocVien.setSo_dien_thoai(model.getValueAt(selectedRowIndex, 5)!=null?
                            model.getValueAt(selectedRowIndex, 5).toString(): "");
                    hocVien.setDia_chi(model.getValueAt(selectedRowIndex, 6)!=null?
                            model.getValueAt(selectedRowIndex, 6).toString():"");
                    hocVien.setTinh_trang((boolean) model.getValueAt(selectedRowIndex, 7));
                    
                    
                    HocVienJFrame frame= new HocVienJFrame(hocVien);
                    frame.setTitle("Thông tin học viên");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
            
        });
        
        table.getTableHeader().setFont(new  Font("Arrial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scrollPane= new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }
    
    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                HocVienAddJFrame frame= new  HocVienAddJFrame(new HocVien());
                frame.setTitle("Thông tin học viên");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);      
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
        });
        btnPrint.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                XSSFWorkbook workbook = null;
                FileOutputStream out = null;

                try {
                    // 1. Tạo workbook và sheet
                    workbook = new XSSFWorkbook();
                    XSSFSheet sheet = workbook.createSheet("Học viên");

                    // 2. Tạo tiêu đề
                    String[] headers = {"STT", "Họ và tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ"};
                    XSSFRow headerRow = sheet.createRow(0);
                    for (int i = 0; i < headers.length; i++) {
                        XSSFCell cell = headerRow.createCell(i);
                        cell.setCellValue(headers[i]);
                    }

                    // 3. Thêm dữ liệu
                    List<HocVien> listItem = hocVienService.getList();
                    for (int i = 0; i < listItem.size(); i++) {
                        HocVien hocVien = listItem.get(i);
                        XSSFRow row = sheet.createRow(i + 1);

                        // Xử lý dữ liệu null
                        row.createCell(0).setCellValue(i + 1);
                        row.createCell(1).setCellValue(hocVien.getHo_ten() != null ? hocVien.getHo_ten() : "");
                        row.createCell(2).setCellValue(hocVien.getNgay_sinh() != null ? hocVien.getNgay_sinh().toString() : "");
                        row.createCell(3).setCellValue(hocVien.isGioi_tinh() ? "Nam" : "Nữ");
                        row.createCell(4).setCellValue(hocVien.getSo_dien_thoai() != null ? hocVien.getSo_dien_thoai() : "");
                        row.createCell(5).setCellValue(hocVien.getDia_chi() != null ? hocVien.getDia_chi() : "");
                    }

                    // 4. Tự động điều chỉnh cột
                    for (int i = 0; i < headers.length; i++) {
                        sheet.autoSizeColumn(i);
                    }

                    // 5. Chọn nơi lưu file bằng JFileChooser
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Chọn vị trí lưu file");
                    fileChooser.setSelectedFile(new File("Danh_sach_hoc_vien.xlsx"));

                    int userChoice = fileChooser.showSaveDialog(null);
                    if (userChoice == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        String filePath = selectedFile.getAbsolutePath();

                        // Đảm bảo có đuôi .xlsx
                        if (!filePath.endsWith(".xlsx")) {
                            selectedFile = new File(filePath + ".xlsx");
                        }

                        // 6. Ghi file
                        out = new FileOutputStream(selectedFile);
                        workbook.write(out);

                        JOptionPane.showMessageDialog(null, 
                            "Xuất file thành công!\nĐường dẫn: " + selectedFile.getAbsolutePath(),
                            "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    // Hiển thị chi tiết lỗi
                    StringWriter sw = new StringWriter();
                    ex.printStackTrace(new PrintWriter(sw));
                    String errorDetails = sw.toString();

                    JTextArea textArea = new JTextArea(errorDetails);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setPreferredSize(new Dimension(500, 300));

                    JOptionPane.showMessageDialog(null, scrollPane, 
                        "Lỗi khi xuất file", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (out != null) out.close();
                        if (workbook != null) workbook.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}

