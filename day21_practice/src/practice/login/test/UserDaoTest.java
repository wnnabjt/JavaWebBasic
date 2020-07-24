package practice.login.test;

import org.junit.Test;
import practice.login.dao.UserDao;
import practice.login.domain.User;

public class UserDaoTest {

    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("zhangsan");
        loginUser.setPassword("wnnnggabjt123@");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }

}
