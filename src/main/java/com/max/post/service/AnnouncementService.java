package com.max.post.service;

import com.max.post.dto.AnnouncementDTO;

import java.util.List;

public interface AnnouncementService {

    AnnouncementDTO getAnnouncementById(Integer id);

    List<AnnouncementDTO> getFilteredListOfAnnouncements(String author);

    AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO);

}
