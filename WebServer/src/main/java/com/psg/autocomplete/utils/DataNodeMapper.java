package com.psg.autocomplete.utils;

import com.psg.autocomplete.dto.DataNodeDto;
import com.psg.autocomplete.entites.DataNode;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

/**
 * @author Karanjot Singh
 */
@Configuration
@Mapper(componentModel = "spring")
public interface DataNodeMapper {
    DataNodeDto dataNodeToDataNodeDto(DataNode dataNode);

    DataNode dataNodeDtoToDataNode(DataNodeDto dataNodeDto);
}
