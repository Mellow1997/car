package service;

import dao.IUserDao;
import dao.UserDaoImpl;
import entity.User;

public class UserServicesImpl implements IUserServices {

    IUserDao iud = new UserDaoImpl();

    //查看用户是否存在
    public boolean queryUserByUname(User user) {
        return iud.queryUserByUname(user);

    }

    //添加用户
    public boolean addUser(User user) {
        return iud.addUser(user);
    }

    //用户登陆
    public boolean UserLogin(User user) {
        return iud.queryUserLogin(user);
    }
}
