package com.siddharth.mapper;

import com.siddharth.dto.RegisterRequestDTO;
import com.siddharth.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterRequestDTOUserMapper {

    User RegisterRequestDTOToUser(RegisterRequestDTO registerRequestDTO);
}
