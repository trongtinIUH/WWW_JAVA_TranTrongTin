package trantrongtin_iuh.on_gk_lan_1.backend.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import trantrongtin_iuh.on_gk_lan_1.backend.reponsitories.entity.User;

import java.util.List;

public class UserReponsitory {
    @PersistenceContext(unitName = "OnGK_Lan1")
    private EntityManager entityManager;


    //hàm lưu
    public  void save(User user) {
        entityManager.persist(user);
    }
    //hàm tìm theo id
    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }
    //hàm tìm all
    public List<User> findAll() {
        return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
    }
    //hàm update
    public void update(User user) {
        entityManager.merge(user);
    }
    //hàm xóa
    public void delete(User user) {
        User managedUser = entityManager.find(User.class, user.getId());
        if (managedUser != null) {
            entityManager.remove(managedUser);
        } else {
            throw new IllegalArgumentException("ko thấy id để xóa!");
        }
    }
}
