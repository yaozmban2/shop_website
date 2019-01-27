package ControllerTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


/**
 * @author Yu
 * @version 1.0
 * @date 2019/1/27 21:05
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mvc.xml", "classpath:mybatis-config.xml"})
public class RegisterControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(RegisterControllerTest.class);

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testRegister() throws Exception {

        String url = "/register";

        ResultActions resultActions = mockMvc.perform(post(url).param("username", "yaozmban3")
                .param("password", "asd3332514").param("email", "asdasd@156.com")
                .param("telephone", "18456874512"));
        resultActions.andDo(MockMvcResultHandlers.print());
    }

}
