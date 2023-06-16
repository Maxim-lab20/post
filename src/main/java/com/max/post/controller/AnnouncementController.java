package com.max.post.controller;

import com.max.post.dto.AnnouncementDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementDTO> getAnnouncementById(@PathVariable Integer id,
                                                               HttpServletRequest request) {
        String uniqueId = request.getHeader("unique-id");
        AnnouncementDTO announcementDTO = AnnouncementDTO.builder()
                .id(id)
                .build();

        return ResponseEntity.ok()
                .header("unique-id", uniqueId)
                .body(announcementDTO);
    }

    @GetMapping
    public ResponseEntity<AnnouncementDTO> getFilteredListOfAnnouncements(@RequestParam String author,
                                                                          @RequestParam(required = false)
                                                                          Integer votes) {
        AnnouncementDTO announcementDTO = AnnouncementDTO.builder()
                .author(author)
                .votes(votes)
                .build();

        return ResponseEntity.ok(announcementDTO);
    }

    @PostMapping
    public ResponseEntity<AnnouncementDTO> createAnnouncement(@Valid @RequestBody AnnouncementDTO announcementDTO) {
        return new ResponseEntity<>(announcementDTO, HttpStatus.CREATED);
    }

}
