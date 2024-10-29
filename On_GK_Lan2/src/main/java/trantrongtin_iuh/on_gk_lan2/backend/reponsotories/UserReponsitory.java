package trantrongtin_iuh.on_gk_lan2.backend.reponsotories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import trantrongtin_iuh.on_gk_lan2.backend.reponsotories.entity.User;

import java.util.List;

public class UserReponsitory {
        @PersistenceContext(unitName = "OnGkLan2")
        private EntityManager entityManager;

        public void save(User user) {
            entityManager.persist(user);
        }

        public User findById(Integer id) {
            return entityManager.find(User.class, id);
        }
        public List<User> findAll() {
            return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
        }

        public void delete(User user) {
            User managedUser = entityManager.find(User.class, user.getId());
            if (managedUser != null) {
                entityManager.remove(managedUser);
            } else {
                throw new IllegalArgumentException("User not found");
            }
        }

        public void update(User user) {
            entityManager.merge(user);
        }
}
