package trantrongtin_iuh.gk_xe_payara.backend.responsitories;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import trantrongtin_iuh.gk_xe_payara.backend.responsitories.entity.Hangxe;
import trantrongtin_iuh.gk_xe_payara.backend.responsitories.entity.Xe;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class XeResponsitory {
    @PersistenceContext (unitName = "GK_Xe")
private EntityManager entityManager;


    public  void save (Xe xe){
        entityManager.persist(xe);
    }

    public void update(Xe xe){
        entityManager.merge(xe);
    }

    //hàm xóa
    public void delete(Xe xe){
        Xe managedXe = entityManager.find(Xe.class, xe.getMaXe());
        if(managedXe != null){
            entityManager.remove(managedXe);
        }else{
            throw new IllegalArgumentException("Xe not found");

        }}

    public Xe findById(String maXe){
        return entityManager.find(Xe.class, maXe);
    }

    public List<Xe> findAll() {
        return entityManager.createNamedQuery("Xe.findAll", Xe.class).getResultList();
    }

    //tìm kiếm xe theo tên
    public Xe findByName(String maXe) {
        return entityManager
                .createQuery("SELECT x FROM Xe x WHERE x.tenXe = :maXe", Xe.class)
                .setParameter("maXe", maXe)
                .getSingleResult();
    }

    //thêm xe mới theo tên hãng xe
    public void addXeMoiTheoHangXe(Xe xe, String tenhangxe) {
        // Tìm hãng xe theo tên
        Hangxe hangxe = null;
        try {
            hangxe = entityManager
                    .createQuery("SELECT h FROM Hangxe h WHERE h.tenhang = :tenHangXe", Hangxe.class)
                    .setParameter("tenHangXe", tenhangxe)
                    .getSingleResult(); // Ném ngoại lệ nếu không tìm thấy
        } catch (NoResultException e) {
            // Không tìm thấy hãng xe
            throw new IllegalArgumentException("Hãng xe không tồn tại: " + tenhangxe);
        }

        // Gán hãng xe cho đối tượng xe
        xe.setMahangxe(hangxe);

        // Lưu xe vào cơ sở dữ liệu
        entityManager.persist(xe);
    }



}
