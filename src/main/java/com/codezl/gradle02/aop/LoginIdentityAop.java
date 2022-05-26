package com.codezl.gradle02.aop;

import com.alibaba.fastjson.JSONObject;
import com.codezl.gradle02.annotation.LoginIdentity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/16/16:19
 * @Description:
 */
@Aspect
@Component
public class LoginIdentityAop {

    @Pointcut("@annotation(com.codezl.gradle02.annotation.LoginIdentity)")
    public void pointcut1() {}

    @Before("pointcut1() && @annotation(login)")
    public void before1(JoinPoint point, LoginIdentity login) {
        String value = login.value();
        System.out.print("\n注解信息"+value+"》》切点"+point+"》注解》》"+login+"\n");
        HttpServletRequest request = this.cruHttpResquest();
        System.out.print("\n当前请求"+request);
        String name = request.getHeader("name");
        if (name==null) {
            HttpServletResponse response = this.cruHttpResponse();
            JSONObject res = new JSONObject();
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            try (PrintWriter writer = response.getWriter()) {
                res.put("msg", "失败");
                res.put("code", 1);
                writer.write(String.valueOf(res));
                writer.flush();
                writer.close();
                //throw new RuntimeException("登录验证失败");

//            res.put("msg","成功");
//            res.put("code",500);
//            writer.write(String.valueOf(res));
//            writer.close();
                throw new RuntimeException("未登录");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //return true;
    }

    public HttpServletRequest cruHttpResquest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return Optional.of(servletRequestAttributes).map(ServletRequestAttributes::getRequest).get();
    }

    public HttpServletResponse cruHttpResponse() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return servletRequestAttributes.getResponse();
    }
}
