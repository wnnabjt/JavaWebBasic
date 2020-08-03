package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;
import userCRUD.PageBean;
import userCRUD.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void delete(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelected(String[] ids) {
        if(ids.length > 0 && ids != null) {
            for (String id : ids) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        PageBean<User> pb = new PageBean<User>();
        pb.setRows(rows);
        int totalCount = dao.findTotalCount();
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findUserByPage(start, rows);
        pb.setList(list);
        pb.setTotalCount(totalCount);
        int totPage = (totalCount % rows == 0) ? (totalCount / rows) : (totalCount / rows + 1);
        if(currentPage >= totPage) currentPage = totPage - 1;
        pb.setCurrentPage(currentPage);
        pb.setTotPage(totPage);
        return pb;
    }
}
