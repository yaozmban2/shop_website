package ServiceTest;

import cn.yu.shop.pojo.User;
import cn.yu.shop.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Yu
 * @version 1.0
 * @date 2019/1/27 18:14
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@WebAppConfiguration
public class RegistServiceTest {

    @Autowired
    RegisterService registerService;

    @Test
    public void testValidateUser() {
        User user = new User();
        User user2 = new User();
        User user3 = new User();
        user.setUsername("yaozmban2");
        user2.setEmail("455766338@qq.com");
        user3.setTelephone("17854569845");
        System.out.println( "已存在用户名的返回值" + registerService.validateUser(user));
        System.out.println( "已存在email的返回值" + registerService.validateUser(user2));
        System.out.println( "已存在telephone的返回值" + registerService.validateUser(user3));

    }

}
