package fanur.model;

import java.util.List;

public interface Repository {
    List<User> getAllUsers();

    void CreateUser(User user);

    void updateUser(User user);

    void deleteUser(String userID);
}