package cn.yu.shop.dao;

import cn.yu.shop.pojo.User;

import java.util.List;

public interface UserMapper {

    public List<User> selectUserByUsername(User user);

    public List<User> selectUserByEmail(User user);

    public List<User> selectUserByTelephone(User user);

    public void insertUser(User user);

}