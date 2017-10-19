package service.impl;

import dao.UserDao;
import dao.impl.UserDaoXmlImpl;
import domain.User;
import myException.UserExistException;
import service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
    UserDao userDao = new UserDaoXmlImpl();
    @Override
    public void registerUser(User user) throws UserExistException {
        User fromDao =userDao.find(user.getUsername());
        if(fromDao !=null)
            throw new UserExistException("用户名已存在");
        userDao.add(user);
    }
    @Override
    public User  loginUser(String user, String password){
        return userDao.find(user,password);

    }
}
