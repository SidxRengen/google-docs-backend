package com.siddharth.mapper;

import com.siddharth.dto.DocumentDTO;
import com.siddharth.model.Doc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserDocMapper.class)
public interface DocumentMapper {

    @Mapping(source = "owner.username", target = "owner")
    @Mapping(target = "content", ignore = true)
    DocumentDTO toDto(Doc document);

}
