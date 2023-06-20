package com.max.post.repository;

import com.max.post.entity.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Integer> {

    // JPA Derived Method
    List<AnnouncementEntity> findAllByAuthor(String author);

    //JPQL
//    @Query("SELECT announcement FROM AnnouncementEntity announcement WHERE announcement.author = :author")
//    List<AnnouncementEntity> findAllByAuthor(String author);

    // native query
//    @Query(value = "SELECT * FROM announcement WHERE author = :author", nativeQuery = true)
//    List<AnnouncementEntity> findAllByAuthor(String author);

}
