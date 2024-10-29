package trantrongtin_iuh.gk_xe_payara.backend.bussiness;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import trantrongtin_iuh.gk_xe_payara.backend.dtos.XeDTO;
import trantrongtin_iuh.gk_xe_payara.backend.responsitories.XeResponsitory;
import trantrongtin_iuh.gk_xe_payara.backend.responsitories.entity.Xe;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class Xeimpl  implements  XeDAO{
    @Inject
    private XeResponsitory xeResponsitory;


    @Override
    public List<XeDTO> danhSachXe() {
        List<Xe> xeList = xeResponsitory.findAll(); // Lấy danh sách xe từ repository
        List<XeDTO> xeDTOList = new ArrayList<>();

        for (Xe xe : xeList) {
            XeDTO xeDTO = new XeDTO(
                    xe.getMaXe(),
                    xe.getTenXe(),
                    xe.getNamSanXuat(),
                    xe.getMahangxe() != null ? xe.getMahangxe().getMahangxe() : null // Lấy tên hãng xe
            );
            xeDTOList.add(xeDTO);
        }

        return xeDTOList; // Trả về danh sách XeDTO
    }


    @Override
    public XeDTO findByName(String name) {
        Xe xe = xeResponsitory.findByName(name); // Lấy đối tượng Xe từ repository
        if (xe != null) {
            return new XeDTO(
                    xe.getMaXe(),
                    xe.getTenXe(),
                    xe.getNamSanXuat(),
                    xe.getMahangxe() != null ? xe.getMahangxe().getMahangxe() : null // Lấy tên hãng xe
            );
        }
        return null; // Nếu không tìm thấy xe
    }



    @Override
    public void addXeMoiTheoHangXe(Xe xe, String tenhangxe) {
        xeResponsitory.addXeMoiTheoHangXe(xe, tenhangxe);

    }
}
