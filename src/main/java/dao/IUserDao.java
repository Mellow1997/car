package dao;

import entity.User;

import java.sql.ResultSet;

public interface IUserDao {
    //查询用户是否存在
    boolean queryUserByUname(User user);

    //添加用户
    boolean addUser(User user);

    //检查用户登陆
    boolean queryUserLogin(User user);

    //
    boolean queryResult(ResultSet rs);
}
