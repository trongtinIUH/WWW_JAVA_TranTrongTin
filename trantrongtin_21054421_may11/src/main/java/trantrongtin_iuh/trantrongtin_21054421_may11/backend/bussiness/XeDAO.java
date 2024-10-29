package trantrongtin_iuh.trantrongtin_21054421_may11.backend.bussiness;

import jakarta.ejb.Local;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.dtos.XeDTO;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.repositories.entity.Xe;

import java.util.List;

@Local
public interface XeDAO {

    List<XeDTO> danhSachXe();
    //tìm kiếm theo tên xe hoăc giá xe
    List<XeDTO> searchXe( int giaXe);

    // hàm add xe mới theo tên hãng xe
    void addXeMoiTheoHangXe(Xe xe, String tenHangXe);
}
