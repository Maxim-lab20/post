package com.max.post.repository;

import com.max.post.entity.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Integer> {

    List<AnnouncementEntity> findAllByAuthor(String author);

}
