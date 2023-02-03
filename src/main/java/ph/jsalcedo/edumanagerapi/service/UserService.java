package ph.cdo.jsalcedo.edumanagerapi.service;

import org.springframework.stereotype.Service;
import ph.cdo.jsalcedo.edumanagerapi.model.User;

import java.util.List;


public interface UserService {
    User getUser(String email);
    List<User> getAllUsers();
    void saveUser(User user);

}
