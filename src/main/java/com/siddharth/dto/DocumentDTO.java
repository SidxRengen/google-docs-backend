package com.siddharth.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentDTO {
    private Long id;
    private String owner;
    private String title;
    private String content;

    private List<UserDocDTO> sharedWith;
}
