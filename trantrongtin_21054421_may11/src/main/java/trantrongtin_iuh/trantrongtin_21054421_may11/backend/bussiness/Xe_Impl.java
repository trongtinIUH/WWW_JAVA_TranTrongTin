package trantrongtin_iuh.trantrongtin_21054421_may11.backend.bussiness;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.dtos.XeDTO;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.repositories.XeReponsitory;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.repositories.entity.Xe;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class Xe_Impl implements XeDAO{
    @Inject
    private XeReponsitory xeReponsitory;

    @Override
    public List<XeDTO> danhSachXe() {
    List<Xe> xeList = xeReponsitory.findAll();
    List<XeDTO> xeDTOList = new ArrayList<>();
        for(Xe xe: xeList){
              XeDTO xeDTO= new XeDTO(
                        xe.getMaXe(),
                        xe.getTenXe(),
                        xe.getGiaXe(),
                        xe.getNamSanXuat(),
                        xe.getMaHangXe() != null ? xe.getMaHangXe().getMaHangXe() : null
                );
                xeDTOList.add(xeDTO);
        }
        return xeDTOList;
    }


    //tìm kiếm theo tên xe hoăc giá xe
    @Override
    public List<XeDTO> searchXe(int giaXe) {
        List<Xe> xeList = xeReponsitory.searchXe(giaXe);
        List <XeDTO> xeDTOList = new ArrayList<>();
    //Xe xe = xeReponsitory.searchXe( giaXe);
//        if(xeList!=null){
//return new XeDTO(
//        xe.getMaXe(),
//        xe.getTenXe(),
//        xe.getGiaXe(),
//        xe.getNamSanXuat(),
//        xe.getMaHangXe() != null ? xe.getMaHangXe().getMaHangXe() : null
//);
//        }
        if( xeList != null){
            for(Xe xe: xeList){
                XeDTO xeDTO = new XeDTO(
                        xe.getMaXe(),
                        xe.getTenXe(),
                        xe.getGiaXe(),
                        xe.getNamSanXuat(),
                        xe.getMaHangXe() != null ? xe.getMaHangXe().getMaHangXe() : null
                );
                xeDTOList.add(xeDTO);
            }
            return xeDTOList;
        }
        return null;
    }

    @Override
    public void addXeMoiTheoHangXe(Xe xe, String tenHangXe) {
        xeReponsitory.addXeMoiTheoHangXe(xe, tenHangXe);
    }


}
