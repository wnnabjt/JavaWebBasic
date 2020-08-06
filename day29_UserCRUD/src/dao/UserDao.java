package dao;

import userCRUD.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public List<User> findAll();

    public abstract User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int id);

    User findUserById(int id);

    void update(User user);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findUserByPage(int start, int rows, Map<String, String[]> condition);
}
