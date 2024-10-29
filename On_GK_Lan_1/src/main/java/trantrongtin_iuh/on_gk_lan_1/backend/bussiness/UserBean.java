package trantrongtin_iuh.on_gk_lan_1.backend.bussiness;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import trantrongtin_iuh.on_gk_lan_1.backend.reponsitories.UserReponsitory;
import trantrongtin_iuh.on_gk_lan_1.backend.reponsitories.entity.User;

import java.util.List;

@Stateless
public class UserBean  implements  UserBeanRemote{

@Inject
private UserReponsitory userRepository;


    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUser(int id) {
        return  userRepository.findById(id);
    }

    @Override
    public List<User> getUsers() {
        return  userRepository.findAll();
    }
}
