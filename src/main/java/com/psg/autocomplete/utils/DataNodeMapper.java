package com.psg.autocomplete.utils;

import com.psg.autocomplete.dto.DataNodeDto;
import com.psg.autocomplete.entites.DataNode;
import org.mapstruct.Mapper;

/**
 * @author Karanjot Singh
 */
@Mapper
public interface DataNodeMapper {
    DataNodeDto dataNodeToDataNodeDto(DataNode dataNode);

    DataNode dataNodeDtoToDataNode(DataNodeDto dataNodeDto);
}
