package com.siddharth.mapper;

import com.siddharth.dto.UserDTO;
import com.siddharth.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
}
