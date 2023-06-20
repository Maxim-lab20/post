package com.max.post.controller;

import com.max.post.entity.AnnouncementEntity;
import com.max.post.repository.AnnouncementRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/announcements")
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementRepository announcementRepository;

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementEntity> getAnnouncementById(@PathVariable Integer id,
                                                                  HttpServletRequest request) {
        String uniqueId = request.getHeader("unique-id");
        Optional<AnnouncementEntity> announcementEntityOptional = announcementRepository.findById(id);

        return announcementEntityOptional
                .map(entity -> ResponseEntity.ok()
                        .header("unique-id", uniqueId)
                        .body(entity))
                .orElse(null);
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementEntity>> getFilteredListOfAnnouncements(@RequestParam String author) {

        List<AnnouncementEntity> entityList = announcementRepository.findAllByAuthor(author);

        return ResponseEntity.ok(entityList);
    }

    @PostMapping
    public ResponseEntity<AnnouncementEntity> createAnnouncement(@RequestBody AnnouncementEntity announcement) {
        AnnouncementEntity savedEntity = announcementRepository.save(announcement);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

}
