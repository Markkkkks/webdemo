package service;

import domain.User;
import myException.UserExistException;

public interface BusinessService {
    void registerUser(User user) throws UserExistException;

    User  loginUser(String user, String password);
}
