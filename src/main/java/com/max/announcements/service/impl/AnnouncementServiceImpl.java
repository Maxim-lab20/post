package com.max.announcements.service.impl;

import com.max.announcements.dto.AnnouncementDTO;
import com.max.announcements.dto.AnnouncementWithCommentsDTO;
import com.max.announcements.entity.AnnouncementEntity;
import com.max.announcements.exception.AnnouncementNotFoundException;
import com.max.announcements.feign.CommentsServiceClient;
import com.max.announcements.mapper.AnnouncementMapper;
import com.max.announcements.repository.AnnouncementRepository;
import com.max.announcements.service.AnnouncementService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final CommentsServiceClient commentsServiceClient;

    @Override
    public AnnouncementDTO getAnnouncementById(Integer id) {
        Optional<AnnouncementEntity> announcementEntityOptional = announcementRepository.findById(id);

        if (announcementEntityOptional.isEmpty()) {
            throw new AnnouncementNotFoundException(
                    String.format("Announcement with id = %s not found.", id));
        }

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

    @Override
    public AnnouncementWithCommentsDTO getAnnouncementWithCommentsById(Integer id) {

        AnnouncementDTO announcementDTO = getAnnouncementById(id);
        List<String> comments = commentsServiceClient.getCommentsByAnnouncementId(id);

        return AnnouncementWithCommentsDTO.builder()
                .announcementDTO(announcementDTO)
                .comments(comments)
                .build();

    }
}
