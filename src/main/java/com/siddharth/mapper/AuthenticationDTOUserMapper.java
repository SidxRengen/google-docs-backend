package com.siddharth.mapper;

import com.siddharth.dto.AuthenticationRequestDTO;
import com.siddharth.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthenticationDTOUserMapper {
    User AuthenticationRequestDTOToUser(AuthenticationRequestDTO registerRequestDTO);
}
