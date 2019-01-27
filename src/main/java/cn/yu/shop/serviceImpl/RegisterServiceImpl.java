package cn.yu.shop.serviceImpl;

import cn.yu.shop.dao.UserMapper;
import cn.yu.shop.pojo.User;
import cn.yu.shop.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Yu
 * @version 1.0
 * @date 2019/1/27 16:58
 **/
@Service("registerService")
public class RegisterServiceImpl  implements RegisterService {

    @Autowired
    UserMapper mapper;

    @Override
    public int validateUser(User user) {

        if (!mapper.selectUserByUsername(user).isEmpty()) {
            return 1;
        }
        if (!mapper.selectUserByEmail(user).isEmpty()) {
            return 2;
        }
        if (!mapper.selectUserByTelephone(user).isEmpty()) {
            return 3;
        }

        return 0;
    }

    @Override
    public void registerUser(User user) {

        user.setRegtime(new Date());
        mapper.insertUser(user);

    }

}
