package trantrongtin_iuh.may22_trantrongtin_21054421.backend.bussiness;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.dtos.ThuocDTO;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.LoaiThuocResponsitory;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.ThuocReponsitory;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Loaithuoc;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Thuoc;

import java.util.List;

@Stateless
public class QuanLyThuoc_Impl implements  QuanLyThuocDAO{

    @Inject
    private ThuocReponsitory thuocReponsitory;

    @Inject
    private LoaiThuocResponsitory loaiThuocResponsitory;


    @Override
    public List<Thuoc> danhSachThuoc() {
        return thuocReponsitory.danhSachThuoc();
    }

    @Override
    public List<Loaithuoc> danhSachLoaiThuoc() {
        return loaiThuocResponsitory.danhSachLoaiThuoc();
    }

    @Override
    public List<ThuocDTO> danhSachThuocTheoLoai() {
        List<Thuoc> thuocList = thuocReponsitory.danhSachThuoc();
        List<ThuocDTO> thuocDTOList = new java.util.ArrayList<>();
        for(Thuoc thuoc: thuocList){
            ThuocDTO thuocDTO = new ThuocDTO(
                    thuoc.getMaThuoc(),
                    thuoc.getTenthuoc(),
                    thuoc.getGiaThuoc(),
                    thuoc.getNamSX(),
                    thuoc.getMaLoai() != null ? thuoc.getMaLoai().getMaLoai() : null
            );
            thuocDTOList.add(thuocDTO);
        }
        return thuocDTOList;
    }

    @Override
    public void addThuoc(Thuoc thuoc, String maLoai) {
        thuocReponsitory.addThuoc(thuoc, maLoai);
    }
}
