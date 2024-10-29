package trantrongtin_iuh.ongk_lan3_tomcat.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import trantrongtin_iuh.ongk_lan3_tomcat.entity.User;

import java.util.List;

public class UderDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnGK_Lan3");



    public List<User> getAllUser() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> users = entityManager.createNamedQuery("User.findAll").getResultList();
        entityManager.close();
        return users;
    }

    //tìm user
    public User findUserById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(User.class, id);
        } finally {
            entityManager.close();
        }
    }

    //thêm user
    public void addUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    //hàm xóa
    public void deleteUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    //hàm cập nhật
    public void updateUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

}