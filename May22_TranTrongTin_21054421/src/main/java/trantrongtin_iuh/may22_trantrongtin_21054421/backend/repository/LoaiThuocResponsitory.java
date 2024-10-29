package trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Loaithuoc;

import java.util.List;

public class LoaiThuocResponsitory {
    @PersistenceContext(unitName = "hihi")
    private EntityManager entityManager;


    //danh sach cac loai thuoc
    public List<Loaithuoc> danhSachLoaiThuoc(){
        return entityManager.createNamedQuery("Loaithuoc.findAll", Loaithuoc.class).getResultList();
    }
}
