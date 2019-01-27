package cn.yu.shop.controller;

import cn.yu.shop.pojo.User;
import cn.yu.shop.service.RegisterService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户注册相关的Controller
 *
 * @author Yu
 * @version 1.0
 * @date 2019/1/27 16:08
 **/
@Api("用户注册")
@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;

    /**
     *  用户注册
     *
     * @author Yu
     * @date 18:51 2019/1/27
     * @param user 用户的注册表单 表单中各数据的id见后 用户名-username 用户密码-password 用户邮箱-email 手机号-telephone
     * @return 返回值： 1-用户名已存在 2-用户邮箱已存在 3-用户电话已存在 0-用户注册成功
     **/
    @ApiOperation("用户注册")
    @ApiResponses({
            @ApiResponse(code = 0, message = "用户注册成功"),
            @ApiResponse(code = 1, message = "用户名已存在"),
            @ApiResponse(code = 2, message = "用户邮箱已存在"),
            @ApiResponse(code = 3, message = "用户电话已存在")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名(必须)"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "用户密码（必须）"),
            @ApiImplicitParam(paramType = "query", name = "email", value = "用户邮箱（必须）"),
            @ApiImplicitParam(paramType = "query", name = "telephone", value = "用户手机号（必须）"),
            @ApiImplicitParam(paramType = "query", name = "userid", value = "用户id（不用填）"),
            @ApiImplicitParam(paramType = "query", name = "regtime", value = "注册时间（不用填）")
    })
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public int register(User user, Model model) {

        //验证用户名、邮箱、用户电话是否重复
        int iValidateResult = registerService.validateUser(user);
        if (0 != iValidateResult) {
            return iValidateResult;
        } else {
            registerService.registerUser(user);
            return 0;
        }
    }

}
