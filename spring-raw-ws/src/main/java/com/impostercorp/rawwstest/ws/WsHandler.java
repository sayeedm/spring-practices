package com.impostercorp.rawwstest.ws;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * Created by sayeedm on 3/6/17.
 */
@Component
public class WsHandler extends TextWebSocketHandler {
    private List<WebSocketSession> sessions = new CopyOnWriteArrayList<WebSocketSession>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws InterruptedException, IOException {
        try {
            System.out.println("From session " + session.getId() + " : " + message.getPayload());
            sendMessageToAll(message, session);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        try {
            System.out.println("Incoming session " + session.getId() + " from " + session.getRemoteAddress().toString());
            sessions.add(session);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws IOException{
        System.out.println("onTransportError");
        exception.printStackTrace();
    }

    private void sendMessageToAll(TextMessage json, WebSocketSession ownSession) throws IOException, InterruptedException{
        try {
            for (WebSocketSession s : sessions) {
                if (!s.getId().equals(ownSession.getId())) {
                    System.out.println("Sending " + json.getPayload() + " to " + s.getId());
                    try {
                        if (s.isOpen())
                            s.sendMessage(json);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
