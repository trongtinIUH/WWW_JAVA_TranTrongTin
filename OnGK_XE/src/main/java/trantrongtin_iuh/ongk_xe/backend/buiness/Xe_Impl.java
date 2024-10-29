package trantrongtin_iuh.ongk_xe.backend.buiness;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import trantrongtin_iuh.ongk_xe.backend.dtos.XeDTO;
import trantrongtin_iuh.ongk_xe.backend.repository.XeReponsitory;
import trantrongtin_iuh.ongk_xe.backend.repository.entity.Xe;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class Xe_Impl  implements  XeDAO {
    @Inject
    private XeReponsitory xeReponsitory;

    @Override
    public List<XeDTO> danhSachXe() {
        List<Xe> xeList = xeReponsitory.danhSachXe();
        List<XeDTO> xeDTOList = new ArrayList<>();
        for(Xe xe: xeList){
            XeDTO xeDTO = new XeDTO(
                    xe.getMaXe(),
                    xe.getTenXe(),
                    xe.getGiaXe(),
                    xe.getNamSanXuat(),
                    xe.getMaHangxe() != null ? xe.getMaHangxe().getMaHangXe() : null
            );
            xeDTOList.add(xeDTO);
        }
        return xeDTOList;
    }

    @Override
    public void addXeMoiTheoHangXe(Xe xe, String tenHangXe) {
        xeReponsitory.addXe(xe, tenHangXe);
    }

    @Override
    public List<XeDTO> searchXe(int giaXe) {
      List<Xe> xeList = xeReponsitory.searchXe(giaXe);
        List<XeDTO> xeDTOList = new ArrayList<>();
        for (Xe xe: xeList){
            XeDTO xeDTO = new XeDTO(
                    xe.getMaXe(),
                    xe.getTenXe(),
                    xe.getGiaXe(),
                    xe.getNamSanXuat(),
                    xe.getMaHangxe() != null ? xe.getMaHangxe().getMaHangXe() : null
            );
            xeDTOList.add(xeDTO);
        }
        return xeDTOList;
    }

    @Override
    public void deleteXe(String maXe) {
        xeReponsitory.deleteXe(maXe);
    }


}
