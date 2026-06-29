package com.siddharth.mapper;

import com.siddharth.dto.UserDocDTO;
import com.siddharth.model.UserDoc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDocMapper {
    @Mapping(source = "user.username", target = "username")
    UserDocDTO userDocToUserDocDTO(UserDoc userDoc);
}
