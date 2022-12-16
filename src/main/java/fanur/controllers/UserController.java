package fanur.controllers;

import fanur.model.Repository;
import fanur.model.User;

import java.util.List;

public class UserController {
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        validateUserData(user);
        repository.CreateUser(user);
    }

    public User readUser(String userId) {
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }

        throw new IllegalStateException("Пользователь не найден");
    }

    public List<User> readUsers() {
        return repository.getAllUsers();
    }

    public void validateUserData(User user) {
        if ((user.getFirstName()).isEmpty() || (user.getLastName()).isEmpty() ||
                (user.getPhone()).isEmpty()) throw new IllegalStateException("Не заполнены поля");
        validatePhone(user);
    }

    public void validatePhone(User user) {
        String phone = user.getPhone();
        if (!phone.matches("\\+7\\d*")) {
            throw new IllegalStateException("Некорректный номер телефона ");
        }

    }

    public void editUser(User user) {
        validateUserData(user);
        repository.updateUser(user);
    }

    public void deleteUser(String userId) {
        repository.deleteUser(userId);
    }

}