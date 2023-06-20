package com.max.post.service.impl;

import com.max.post.entity.AnnouncementEntity;
import com.max.post.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("impl2")
//@Primary
public class AnnouncementServiceImplDummy implements AnnouncementService {

    @Override
    public AnnouncementEntity getAnnouncementById(Integer id) {
        AnnouncementEntity entity = new AnnouncementEntity();
        entity.setId(-100);
        return entity;
    }

    @Override
    public List<AnnouncementEntity> getFilteredListOfAnnouncements(String author) {
        AnnouncementEntity entity = new AnnouncementEntity();
        entity.setId(-100);
        return List.of(entity);
    }

    @Override
    public AnnouncementEntity createAnnouncement(AnnouncementEntity announcement) {
        AnnouncementEntity entity = new AnnouncementEntity();
        entity.setId(-100);
        return entity;
    }
}
