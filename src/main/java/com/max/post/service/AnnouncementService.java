package com.max.post.service;

import com.max.post.entity.AnnouncementEntity;

import java.util.List;

public interface AnnouncementService {

    AnnouncementEntity getAnnouncementById(Integer id);

    List<AnnouncementEntity> getFilteredListOfAnnouncements(String author);

    AnnouncementEntity createAnnouncement(AnnouncementEntity announcement);

}
