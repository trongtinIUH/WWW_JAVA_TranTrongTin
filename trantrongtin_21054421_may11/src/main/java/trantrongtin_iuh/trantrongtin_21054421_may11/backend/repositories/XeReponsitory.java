package trantrongtin_iuh.trantrongtin_21054421_may11.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.repositories.entity.Hangxe;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.repositories.entity.Xe;

import java.util.List;

public class XeReponsitory {
    @PersistenceContext(unitName = "GK_Xe")
    private EntityManager entityManager;

    // hiển thị danh sách xe
    public List<Xe> findAll() {
        return entityManager.createNamedQuery("Xe.findAll", Xe.class).getResultList();
    }

    //tìm kiếm theo giá xe
    public List<Xe> searchXe(int giaXe) {
        try {
            return entityManager
                    .createQuery("SELECT x FROM Xe x WHERE x.giaXe = :giaXe", Xe.class)
                    .setParameter("giaXe", giaXe)
                    .getResultList();
        } catch (NoResultException e) {
            // Không tìm thấy xe với giá đã cho
            return null; // Hoặc bạn có thể ném ra một ngoại lệ tùy chỉnh
        } catch (Exception e) {
            // Xử lý các lỗi khác nếu cần
            throw new RuntimeException("Lỗi khi tìm kiếm xe: " + e.getMessage());
        }
    }

//hàm thêm xe mới theo tên hãng xe
    public void addXeMoiTheoHangXe(Xe xe, String tenhangxe){
        Hangxe hangxe = null;
try{
hangxe = entityManager
        .createQuery("select h from Hangxe h where h.tenHang = :tenHangXe", Hangxe.class)
        .setParameter("tenHangXe", tenhangxe)
        .getSingleResult();
}catch (NoResultException e){
    throw new NoResultException("Hãng xe không tồn tại: " + tenhangxe);
}
xe.setMaHangXe(hangxe);
entityManager.persist(xe);
    }




}
