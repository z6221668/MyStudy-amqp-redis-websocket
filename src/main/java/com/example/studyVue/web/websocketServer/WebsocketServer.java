package com.example.studyVue.web.websocketServer;

import com.example.studyVue.web.entity.po.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author: z6~
 * @time: 2019-10-23 16:55
 */
@Component
@ServerEndpoint("/websocket_server/{name}")
public class WebsocketServer {

    private static final Logger logger = LoggerFactory.getLogger(WebsocketServer.class);

    public static CopyOnWriteArrayList<Client> socketServers = new CopyOnWriteArrayList<>();

    //使用websocket封装的session
    private Session session;

    private String name;

    //在线人数
    private static int onlineNum = 0;


    private static Map<String, WebsocketServer> client = new ConcurrentHashMap<>();

    /**
     * 用户触发连接
     */
    @OnOpen
    public synchronized void onOpen(Session session, @PathParam("name") String name) throws InterruptedException {

        this.session = session;
        this.name = name;
        onlineNum++;
        logger.info("客户端连接，用户名为：" + name);
        logger.info("当前人数为" + onlineNum);
        System.out.println("检测用户是否重名");
        Thread.sleep(1000);
        for (WebsocketServer value : client.values()) {
            if (value.name.equals(name)) {
                System.out.println("重复名,减去当前用户");
                onlineNum--;
            }
            return;
        }
        client.put(name, this);
        sendMessage("成功了！！！", name);


    }

    @OnMessage
    public void onMessage(String text) {
        Client client = socketServers.stream().filter(cli -> cli.getSession() == session).collect(Collectors.toList()).get(0);
        sendMessage(text, client.getUserName());
    }

    @OnClose
    public void onClose() {
        socketServers.forEach(client -> {
            if (client.getSession().getId().equals(session.getId())) {
                logger.info("客户端" + client.getUserName() + "断开连接");
                socketServers.remove(client);
            }
        });
    }


    /**
     * 发送消息 ,指定username发送message
     */
    public synchronized void sendMessage(String message, String name) {
        for (WebsocketServer value : client.values()) {
            System.out.println(value.name);
            if (name.equals(value.name)) {
                value.session.getAsyncRemote().sendText(message);
                break;
            }
        }
//
//        socketServers.forEach(client -> {
//            if (name.equals(client.getUserName())) {
//                try {
//                    client.getSession().getBasicRemote().sendText(message);
//                    logger.info("发送消息：" + message);
//                } catch (IOException e) {
//                    logger.info("发送失败");
//                }
//            }
//        });
    }


}
