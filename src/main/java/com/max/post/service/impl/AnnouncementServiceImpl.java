package com.max.post.service.impl;

import com.max.post.dto.AnnouncementDTO;
import com.max.post.entity.AnnouncementEntity;
import com.max.post.mapper.AnnouncementMapper;
import com.max.post.repository.AnnouncementRepository;
import com.max.post.service.AnnouncementService;
import jakarta.transaction.Transactional;
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

        return announcementEntityOptional.map(AnnouncementMapper.INSTANCE::toDTO)
                .orElse(null);
    }

    @Override
    public List<AnnouncementDTO> getFilteredListOfAnnouncements(String author) {
        return announcementRepository.findAllByAuthor(author).stream()
                .map(AnnouncementMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO) {
        AnnouncementEntity announcementEntity = AnnouncementMapper.INSTANCE.toEntity(announcementDTO);
        AnnouncementEntity savedEntity = announcementRepository.save(announcementEntity);

        return AnnouncementMapper.INSTANCE.toDTO(savedEntity);
    }

}
