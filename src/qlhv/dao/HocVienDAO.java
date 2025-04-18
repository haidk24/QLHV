package qlhv.dao;

import java.util.List;
import qlhv.model.HocVien;

/**
 *
 * @author TRAN HOAN
 */
public interface HocVienDAO {
    public List<HocVien> getList();
    public int createOrUpdate(HocVien hocVien);
    public boolean delete(int maHocVien);
}
