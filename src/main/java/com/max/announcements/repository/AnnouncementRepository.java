package com.max.announcements.repository;

import com.max.announcements.entity.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Integer> {

    List<AnnouncementEntity> findAllByAuthor(String author);

}
