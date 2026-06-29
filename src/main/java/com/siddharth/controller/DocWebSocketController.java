package com.siddharth.controller;

import com.siddharth.engine.Crdt;
import com.siddharth.engine.CrdtManagerService;
import com.siddharth.engine.Item;
import com.siddharth.dto.CursorDTO;
import com.siddharth.dto.DocumentChangeDTO;
import com.siddharth.mapper.DocumentChangeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class DocWebSocketController {
    @Autowired
    CrdtManagerService crdtManagerService;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    DocumentChangeMapper documentChangeMapper;

    @MessageMapping("/change/{id}")
    public void greeting(@DestinationVariable String id, DocumentChangeDTO message) {
        Crdt crdt = crdtManagerService.getCrdt(Long.parseLong(id));
        if (message.getOperation().equals("delete")) {
            crdt.delete(message.getId());
        } else if (message.getOperation().equals("insert")) {
            crdt.insert(message.getId(),
                    new Item(message.getId(), message.getContent(), crdt.getItem(message.getRight()),
                            crdt.getItem(message.getLeft()), message.getOperation(), message.getIsDeleted(),
                            message.getIsBold(), message.getIsItalic()));
        } else {
            crdt.format(message.getId(), message.getIsBold(), message.getIsItalic());
        }

        messagingTemplate.convertAndSend("/docs/broadcast/changes/" + id, message);
    }

    @MessageMapping("/cursor/{id}")
    public void cursor(@DestinationVariable String id, CursorDTO message) {
        messagingTemplate.convertAndSend("/docs/broadcast/cursors/" + id, message);
    }

    @MessageMapping("/username/{id}")
    public void usernames(@DestinationVariable String id, String message) {
        messagingTemplate.convertAndSend("/docs/broadcast/usernames/" + id, message);
    }

}
