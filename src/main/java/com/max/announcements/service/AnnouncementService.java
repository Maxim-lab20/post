package com.max.announcements.service;

import com.max.announcements.dto.AnnouncementDTO;

import java.util.List;

public interface AnnouncementService {

    AnnouncementDTO getAnnouncementById(Integer id);

    List<AnnouncementDTO> getFilteredListOfAnnouncements(String author);

    AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO);

}
