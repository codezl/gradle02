package com.codezl.gradle02.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/14/10:42
 * @Description:
 */
@Component
@Data
@ServerEndpoint("/websocket/{token}")
//@Slf4j
public class WebsocketService {

    private Session session;
    private Integer count;
    private static ConcurrentHashMap<Integer,WebsocketService> map = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value = "token") String token) {
        this.session=session;
        map.put(1,this);
        System.out.print("登录验证"+token);
        count++;
    }

    @OnMessage
    public void onMessage(String message,Session session) {

    }

    @OnClose
    public void onClose(Session session,CloseReason closeReason) {

    }

    @OnError
    public void onError(Throwable throwable,Session session) {

    }

    public void freshOnlineCount() {

    }
}
