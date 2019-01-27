package cn.yu.shop.service;

import cn.yu.shop.pojo.User;

/**
 * 注册用户的服务
 *
 * @author Yu
 * @version 1.0
 * @date 2019/1/27 16:58
 **/
public interface RegisterService {

    /**
     *  验证用户填写的注册信息是否已存在
     *
     * @author Yu
     * @date 17:43 2019/1/27
     * @param user 填写的用户注册信息
     * @return int 返回相关提示  返回值1 用户名已存在  返回值2 注册邮箱已存在 返回值3  注册手机已存在  返回值0  注册信息可用
     **/
    public int validateUser(User user);

    /**
     *  将用户信息存入数据库中
     *
     * @author Yu
     * @date 19:07 2019/1/27
     * @param user 用户表单信息
     **/
    public void registerUser(User user);

}
