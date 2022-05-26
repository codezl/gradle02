package com.codezl.gradle02.controller;

import com.codezl.gradle02.annotation.LoginIdentity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/16/17:22
 * @Description:
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @GetMapping("user")
    @LoginIdentity("user")
    public Object userLogin() {
        return "login";
    }
}
