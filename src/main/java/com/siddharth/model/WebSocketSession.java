package com.siddharth.model;

import lombok.*;

@Data
@AllArgsConstructor
public class WebSocketSession {
    private String username;
    private String docId;
}
