package com.codezl.gradle02.config;

import com.codezl.gradle02.resexception.ResException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/29/15:36
 * @Description:
 */
//@RestControllerAdvice
@ControllerAdvice
public class CommonAdviceConfig {

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("manager","codezl");
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> resException(Exception e, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<>();
        map.put("msg",e.getMessage());
        map.put("code",405);
//        response.reset();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter pw = null;
//        try {
//            pw = response.getWriter();
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//        pw.write("{\"msg\":\"测试错误\",\"code\": 404}");
//        pw.flush();
//        pw.close();
        return map;
    }

//    @ResponseBody
    @ExceptionHandler(value = ResException.class)
    public ModelAndView resErrorV(ResException e) {
        ModelAndView view = new ModelAndView();
        view.setViewName("error");
        view.addObject("code",404);
        view.addObject("msg","页面错误");
        return view;
    }

}
