package com.max.announcements.mapper;

import com.max.announcements.dto.AnnouncementDTO;
import com.max.announcements.entity.AnnouncementEntity;
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
