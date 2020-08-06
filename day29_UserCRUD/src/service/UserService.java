package service;


import userCRUD.PageBean;
import userCRUD.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public abstract List<User> findAll();

    public abstract User login(User user);

    /**
     * 保存user
     * @param user
     */
    void addUser(User user);

    void delete(String id);

    User findUserById(String id);

    void updateUser(User user);

    void delSelected(String[] ids);

    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> map);
}
