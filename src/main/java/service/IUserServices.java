package service;

import entity.User;

public interface IUserServices {
    //查看用户是否存在
    boolean queryUserByUname(User user);

    //添加用户
    boolean addUser(User user);

    //用户登陆
    boolean UserLogin(User user);
}
