package trantrongtin_iuh.on_gk_lan_1.backend.bussiness;

import jakarta.ejb.Local;
import trantrongtin_iuh.on_gk_lan_1.backend.reponsitories.entity.User;

import java.util.List;

@Local
public interface UserBeanRemote {
    void add(User user);
    void update(User user);
    void delete(User user);
    User getUser(int id);
    List<User> getUsers();
}
