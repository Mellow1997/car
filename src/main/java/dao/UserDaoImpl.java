package dao;

import entity.User;
import utils.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {

    //查询用户是否存在
    public boolean queryUserByUname(User user) {
        String sql = "select * from user where uname = ?";
        Object[] users = {user.getUname()};
        return queryResult(DbUtils.query(sql, users));
    }

    //添加用户
    public boolean addUser(User user) {
        String sql = "insert into user(uname,password) values(?,?)";
        Object[] users = {user.getUname(), user.getPwd()};
        return DbUtils.update(sql, users);
    }

    //检查用户登陆
    public boolean queryUserLogin(User user) {
        String sql = "select * from user  where uname = ? and password= ? ";
        Object[] users = {user.getUname(),user.getPwd()};
        return queryResult(DbUtils.query(sql, users));
    }


    public boolean queryResult(ResultSet rs) {
        try {
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                DbUtils.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return false;
    }


}
