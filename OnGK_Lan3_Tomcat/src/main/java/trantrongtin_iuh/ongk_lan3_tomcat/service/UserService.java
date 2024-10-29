package trantrongtin_iuh.ongk_lan3_tomcat.service;

import trantrongtin_iuh.ongk_lan3_tomcat.dao.UderDAO;
import trantrongtin_iuh.ongk_lan3_tomcat.entity.User;

import java.util.List;

public class UserService {
    private UderDAO uderDAO = new UderDAO();



    public List<User> getAllUser() {
        return uderDAO.getAllUser();
    }

    public User findUserById(int id) {
        return uderDAO.findUserById(id);
    }

    public void addUser(User user) {
        uderDAO.addUser(user);
    }

    public void deleteUser(int id) {
        uderDAO.deleteUser(id);
    }

    public void updateUser(User user) {
        uderDAO.updateUser(user);
    }
}
