package qlhv.service;

import java.util.List;
import qlhv.dao.HocVienDAO;
import qlhv.dao.HocVienDAOImpl;
import qlhv.model.HocVien;

/**
 *
 * @author TRAN HOAN
 */
public class HocVienServiceImpl implements HocVienService{
    
    private HocVienDAO hocVienDAO= null;

    public HocVienServiceImpl() {
        hocVienDAO =new HocVienDAOImpl();
    }
         
    @Override

    public List<HocVien> getList() {
        return hocVienDAO.getList();
    }
    
}
