package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;
import userCRUD.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
