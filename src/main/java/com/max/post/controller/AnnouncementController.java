package com.max.post.controller;

import com.max.post.entity.AnnouncementEntity;
import com.max.post.service.AnnouncementService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    public AnnouncementController(@Qualifier("impl1") AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementEntity> getAnnouncementById(@PathVariable Integer id,
                                                                  HttpServletRequest request) {
        String uniqueId = request.getHeader("unique-id");

        return ResponseEntity.ok()
                .header("unique-id", uniqueId)
                .body(announcementService.getAnnouncementById(id));
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementEntity>> getFilteredListOfAnnouncements(@RequestParam String author) {
        return ResponseEntity.ok(announcementService.getFilteredListOfAnnouncements(author));
    }

    @PostMapping
    public ResponseEntity<AnnouncementEntity> createAnnouncement(@RequestBody AnnouncementEntity announcement) {
        return new ResponseEntity<>(announcementService.createAnnouncement(announcement), HttpStatus.CREATED);
    }

}
