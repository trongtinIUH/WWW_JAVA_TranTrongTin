package trantrongtin_iuh.ongk_xe.backend.buiness;

import jakarta.ejb.Local;
import org.w3c.dom.stylesheets.LinkStyle;
import trantrongtin_iuh.ongk_xe.backend.dtos.XeDTO;
import trantrongtin_iuh.ongk_xe.backend.repository.entity.Xe;

import java.util.List;

@Local
public interface XeDAO {

    List<XeDTO> danhSachXe();
    //tìm kiếm theo tên xe hoăc giá xe
    void addXeMoiTheoHangXe(Xe xe, String tenHangXe);
    List<XeDTO> searchXe( int giaXe);
    void deleteXe(String maXe);
}
