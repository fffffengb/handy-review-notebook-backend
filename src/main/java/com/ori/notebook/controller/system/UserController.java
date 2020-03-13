package com.ori.notebook.controller.system;

import com.ori.notebook.dao.system.UserDao;
import com.ori.notebook.model.result.Result;
import com.ori.notebook.model.result.ResultCode;
import com.ori.notebook.service.system.UserService;
import com.ori.notebook.utils.Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sys")
public class UserController {
    private UserService userService;
    @Value("${user.timeout}")
    private long timeout;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/nickname" , method = RequestMethod.PATCH)
    public Result changeNickname (@RequestBody Map<String, String> map){
        userService.changeNickname(map.get("nickname"));
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login (@RequestBody Map<String, String> map) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(map.get("username"), map.get("password"));
        //账号或密码错误在common中统一处理
        subject.login(usernamePasswordToken);
        //设置超时时间
        subject.getSession().setTimeout(timeout);
        Map<String, Object> res = new HashMap<>();
        res.put("nickname", Utils.getCurUser().getNickname());
        res.put("token", subject.getSession().getId());
        return new Result(ResultCode.SUCCESS, res);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody Map<String, String> map){
        return new Result(ResultCode.SUCCESS,
                userService.register(map.get("username"), map.get("nickname"), map.get("password") ));
    }
}
