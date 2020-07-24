package practice.login.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import practice.login.domain.User;
import practice.login.util.JDBCUtils;

/**
 * 操作数据库中User的类
 */

public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户的全部数据
     */
    public User login(User loginUser) {
        try {
            String sql = "select * from user where username = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername());
            return user;
        } catch(DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
