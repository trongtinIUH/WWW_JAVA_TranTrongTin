package trantrongtin_iuh.gk_xe_payara.backend.responsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import trantrongtin_iuh.gk_xe_payara.backend.responsitories.entity.Hangxe;

import java.util.List;

public class HangXeResponsitory {
    @PersistenceContext(unitName = "GK_Xe")
    private EntityManager entityManager;

    public void save(Hangxe hangxe) {
        entityManager.persist(hangxe);
    }

    public void update(Hangxe hangxe) {
        entityManager.merge(hangxe);
    }

    public void delete(Hangxe hangxe) {
        Hangxe managedHangxe = entityManager.find(Hangxe.class, hangxe.getMahangxe());
        if (managedHangxe != null) {
            entityManager.remove(managedHangxe);
        } else {
            throw new IllegalArgumentException("Hangxe not found");
        }
    }


    public Hangxe findById(String mahangxe) {
        return entityManager.find(Hangxe.class, mahangxe);
    }

    public List<Hangxe> findAll() {
        return entityManager.createNamedQuery("Hangxe.findAll", Hangxe.class).getResultList();
    }


}
