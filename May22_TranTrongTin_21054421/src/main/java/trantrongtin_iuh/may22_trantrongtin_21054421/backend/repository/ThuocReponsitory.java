package trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Loaithuoc;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Thuoc;

import java.util.List;

public class ThuocReponsitory {
    @PersistenceContext (unitName = "hihi")
    private EntityManager entityManager;

    // xuất danh sách thuốc
    public List<Thuoc> danhSachThuoc(){
        return entityManager.createNamedQuery("Thuoc.findAll", Thuoc.class).getResultList();
    }

    //add thuốc
    public void addThuoc(Thuoc thuoc, String maLoai) {
        if (maLoai == null || maLoai.isEmpty()) {
            throw new RuntimeException("Mã loại thuốc không được phép null hoặc rỗng");
        }

        Loaithuoc loaithuoc = null;
        try {
            loaithuoc = (Loaithuoc) entityManager.createQuery("SELECT l FROM Loaithuoc l WHERE l.maLoai = :maLoai")
                    .setParameter("maLoai", maLoai)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new RuntimeException("Mã loại thuốc không tồn tại: " + maLoai);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi truy vấn loại thuốc: " + e.getMessage());
        }

        thuoc.setMaLoai(loaithuoc);
        entityManager.persist(thuoc);
    }



}
