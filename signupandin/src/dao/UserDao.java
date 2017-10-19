package dao;

import domain.User;

public interface UserDao {
    User find(String username, String password);

    void add(User user);

    User find(String username);
}
