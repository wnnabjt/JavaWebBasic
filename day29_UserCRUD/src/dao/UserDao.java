package dao;

import userCRUD.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();

    public abstract User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int id);

    User findUserById(int id);

    void update(User user);

    int findTotalCount();

    List<User> findUserByPage(int start, int rows);
}
