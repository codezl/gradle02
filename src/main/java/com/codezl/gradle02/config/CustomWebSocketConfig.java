package com.codezl.gradle02.config;

import com.codezl.gradle02.interceptor.CustomWebSocketInterceptor;
import com.codezl.gradle02.service.CustomWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * websocket的配置类
 * @ClassName: CustomWebSocketConfig 
 * @Description: TODO
 * @author OnlyMate
 * @Date 2018年8月16日 下午3:17:26  
 *
 */
@Configuration
@EnableWebSocket
public class CustomWebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(customWebSocketHandler(), "/webSocketBySpring/customWebSocketHandler").addInterceptors(new CustomWebSocketInterceptor()).setAllowedOrigins("*");
        registry.addHandler(customWebSocketHandler(), "/sockjs/webSocketBySpring/customWebSocketHandler").addInterceptors(new CustomWebSocketInterceptor()).setAllowedOrigins("*").withSockJS();
    }

    //@Bean
    // 此处不需要用@Bean注解，因为CustomWebSocketHandler类已经存在@Service注解，已经放入了spring容器
    public WebSocketHandler customWebSocketHandler() {
        return new CustomWebSocketHandler();
    }
}