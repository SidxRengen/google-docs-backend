package com.siddharth.dto;

import com.siddharth.enums.Permission;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDocDTO {

    @NotNull(message = "User is required")
    @JsonProperty(required = true)
    private String username;

    @NotNull(message = "Permission is required")
    @JsonProperty(required = true)
    private Permission permission;
}
