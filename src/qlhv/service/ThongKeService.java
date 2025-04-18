
package qlhv.service;

import java.util.List;
import qlhv.bean.KhoaHocBean;
import qlhv.bean.LopHocBean;

/**
 *
 * @author VU THANH HAI
 */
public interface ThongKeService {
     public List<LopHocBean> getListByLopHoc();
    
     public List<KhoaHocBean> getListByKhoaHoc();
}
