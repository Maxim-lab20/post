package com.max.post.service.impl;

import com.max.post.dto.AnnouncementDTO;
import com.max.post.entity.AnnouncementEntity;
import com.max.post.mapper.AnnouncementMapper;
import com.max.post.repository.AnnouncementRepository;
import com.max.post.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    @Override
    public AnnouncementDTO getAnnouncementById(Integer id) {

        Optional<AnnouncementEntity> announcementEntityOptional = announcementRepository.findById(id);

        if (announcementEntityOptional.isPresent()) {
            AnnouncementEntity announcementEntity = announcementEntityOptional.get();
            AnnouncementDTO announcementDTO = AnnouncementMapper.INSTANCE.toDTO(announcementEntity);
            return announcementDTO;
        }

        return null;
    }

    @Override
    public List<AnnouncementDTO> getFilteredListOfAnnouncements(String author) {
        List<AnnouncementEntity> entityList = announcementRepository.findAllByAuthor(author);
        List<AnnouncementDTO> announcementDTOS = entityList.stream()
                .map(AnnouncementMapper.INSTANCE::toDTO)
                .toList();

        return announcementDTOS;
    }


    @Override
    public AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO) {
        AnnouncementEntity announcementEntity = AnnouncementMapper.INSTANCE.toEntity(announcementDTO);
        AnnouncementEntity savedEntity = announcementRepository.save(announcementEntity);
        AnnouncementDTO announcementDTOToBeReturned = AnnouncementMapper.INSTANCE.toDTO(savedEntity);
        return announcementDTOToBeReturned;
    }

}
