package com.codezl.gradle02.controller;

import com.codezl.gradle02.resexception.ResException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/29/15:41
 * @Description:
 */
@RequestMapping("/advice")
//测试controllerAdvice返回modelandview
//@RestController
@Controller
public class ControllerAdviceController {

    @GetMapping("one")
    @ResponseBody
    public String one(ModelMap map, @ModelAttribute("manager") String manage) {
        sysO(map.get("manager").toString());
        return manage;
    }

    @GetMapping("two")
    public ModelAndView two() {
        throw new ResException("测试advice异常处理器");
    }

    @GetMapping("three")
    @ResponseBody
    public Map three() throws Exception {
        throw new Exception("测试advice异常处理器");
    }

    public void sysO(String msg) {
        System.out.print(msg);
    }
}
