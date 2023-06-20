package com.max.post.mapper;

import com.max.post.dto.AnnouncementDTO;
import com.max.post.entity.AnnouncementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnnouncementMapper {
    AnnouncementMapper INSTANCE = Mappers.getMapper(AnnouncementMapper.class);

    @Mapping(target = "id", ignore = true)
    AnnouncementEntity toEntity(AnnouncementDTO dto);

    AnnouncementDTO toDTO(AnnouncementEntity entity);
}
