package trantrongtin_iuh.may22_trantrongtin_21054421.backend.bussiness;

import jakarta.ejb.Local;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.dtos.ThuocDTO;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Loaithuoc;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Thuoc;

import java.util.List;

@Local
public interface QuanLyThuocDAO {
    //xuất danh sách thuốc
    List<Thuoc> danhSachThuoc();

    //danh sách loaại thuốc
    List<Loaithuoc> danhSachLoaiThuoc();

    //c
    List<ThuocDTO> danhSachThuocTheoLoai();
    void addThuoc(Thuoc thuoc, String maLoai);
}
