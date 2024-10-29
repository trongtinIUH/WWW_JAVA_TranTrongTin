package trantrongtin_iuh.ongk_xe.backend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import trantrongtin_iuh.ongk_xe.backend.repository.entity.Hangxe;
import trantrongtin_iuh.ongk_xe.backend.repository.entity.Xe;

import java.util.List;

public class XeReponsitory {
    @PersistenceContext (unitName = "Hihi")
    private EntityManager entityManager;

    //hàm hien th danh sách xe
    public List<Xe> danhSachXe(){
        return entityManager.createNamedQuery("Xe.findAll", Xe.class).getResultList();
    }

    //hàm add xe
    public void addXe(Xe xe, String tenHangxe){
        Hangxe hangxe = null;
try{
       hangxe = (Hangxe) entityManager.createQuery("Select h from Hangxe h where h.tenHang = :tenHangXe")
        .setParameter("tenHangXe", tenHangxe)
        .getSingleResult();
}catch (Exception e){
    throw new RuntimeException("Lỗi khi thêm xe: " + e.getMessage());

    }
    xe.setMaHangxe(hangxe);
    entityManager.persist(xe);
    }

    //hàm tìm kiếm xe theo giá
    public  List<Xe> searchXe(int giaXe){
        try{
            return entityManager.createQuery("SELECT x FROM Xe x WHERE x.giaXe = :giaXe", Xe.class)
                    .setParameter("giaXe", giaXe)
                    .getResultList();
        }catch (Exception e){
            throw new RuntimeException("Lỗi khi tìm kiếm xe: " + e.getMessage());
        }
    }

    //xóa xe theo mã
    public void deleteXe(String maXe){
        Xe xe = entityManager.find(Xe.class, maXe);
        if(xe != null){
            entityManager.remove(xe);
        }
    }
}
