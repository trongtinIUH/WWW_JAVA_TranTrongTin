package trantrongtin_iuh.gk_xe_payara.backend.bussiness;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import trantrongtin_iuh.gk_xe_payara.backend.dtos.XeDTO;
import trantrongtin_iuh.gk_xe_payara.backend.responsitories.entity.Xe;

import java.util.List;

@Local
public interface XeDAO {
    //hiển thị danh sách xe
     List<XeDTO> danhSachXe();
   //tìm kiếm xe theo tên hoặc giá

    XeDTO findByName(String name);

    //thêm xe mới theo tên hãng xe
    void addXeMoiTheoHangXe(Xe xe, String tenhangxe);
}
