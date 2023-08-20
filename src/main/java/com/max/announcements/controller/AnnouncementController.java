package com.max.announcements.controller;

import com.max.announcements.dto.AnnouncementDTO;
import com.max.announcements.service.AnnouncementService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementDTO> getAnnouncementById(@PathVariable Integer id,
                                                               HttpServletRequest request) {
        String uniqueId = request.getHeader("unique-id");

        return ResponseEntity.ok()
                .header("unique-id", uniqueId)
                .body(announcementService.getAnnouncementById(id));
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementDTO>> getFilteredListOfAnnouncements(@RequestParam String author) {
        return ResponseEntity.ok(announcementService.getFilteredListOfAnnouncements(author));
    }

    @PostMapping
    public ResponseEntity<AnnouncementDTO> createAnnouncement(@RequestBody AnnouncementDTO announcementDTO) {
        return new ResponseEntity<>(announcementService.createAnnouncement(announcementDTO), HttpStatus.CREATED);
    }

}
