package com.max.post.service.impl;

import com.max.post.entity.AnnouncementEntity;
import com.max.post.repository.AnnouncementRepository;
import com.max.post.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("impl1")
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    @Override
    public AnnouncementEntity getAnnouncementById(Integer id) {

        Optional<AnnouncementEntity> announcementEntityOptional = announcementRepository.findById(id);

        return announcementEntityOptional.orElse(null);

    }

    @Override
    public List<AnnouncementEntity> getFilteredListOfAnnouncements(String author) {
        return announcementRepository.findAllByAuthor(author);
    }

    @Override
    public AnnouncementEntity createAnnouncement(AnnouncementEntity announcement) {
        return announcementRepository.save(announcement);
    }
}
