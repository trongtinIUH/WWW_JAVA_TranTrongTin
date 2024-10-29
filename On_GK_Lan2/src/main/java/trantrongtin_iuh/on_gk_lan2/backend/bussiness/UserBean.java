package trantrongtin_iuh.on_gk_lan2.backend.bussiness;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import trantrongtin_iuh.on_gk_lan2.backend.reponsotories.UserReponsitory;
import trantrongtin_iuh.on_gk_lan2.backend.reponsotories.entity.User;

import java.util.List;

@Stateless
public class UserBean implements  UserBeanRemote{
    @Inject
    private UserReponsitory userReponsitory;


    @Override
    public void add(User user) {
        userReponsitory.save(user);
    }

    @Override
    public void update(User user) {
        userReponsitory.update(user);
    }

    @Override
    public void delete(User user) {
        userReponsitory.delete(user);
    }

    @Override
    public User getUser(int id) {
        return userReponsitory.findById(id);
    }

    @Override
    public List<User> getUsers() {
            return userReponsitory.findAll();
    }
}
