package start.service;

import start.model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User getUserId (int id);
    void saveUser (User user);
    void updateUser(int i, User user);
    void deleteUser(int id);
}
