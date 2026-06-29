package com.siddharth.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursorDTO {
    private String username;
    private int index;
    private int length;
}
