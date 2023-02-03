package ph.jsalcedo.edumanagerapi.service;



import ph.jsalcedo.edumanagerapi.model.User;

import java.util.List;


public interface UserService {
    User getUser(String email);
    List<User> getAllUsers();
    void saveUser(User user);

}
