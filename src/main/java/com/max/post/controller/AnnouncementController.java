package com.max.post.controller;

import com.max.post.dto.AnnouncementDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getAnnouncement(@PathVariable Integer id,
                                                  HttpServletRequest request) {
        String uniqueId = request.getHeader("unique-id");
        String responseBody = String.format("announcement with id = %s, the request is having " +
                "unique-id = %s", id, uniqueId);

        return ResponseEntity.ok()
                .header("unique-id", uniqueId)
                .body(responseBody);
    }

    @GetMapping
    public ResponseEntity<String> filterAnnouncements(@RequestParam String name,
                                                      @RequestParam(required = false) Integer votes) {
        String responseBody = String.format("we got announcements list filtered by name = %s " +
                "and votes = %s", name, votes);

        return ResponseEntity.ok(responseBody);
    }

    @PostMapping
    public ResponseEntity<AnnouncementDTO> createAnnouncement(@Valid @RequestBody AnnouncementDTO announcementDTO) {
        return ResponseEntity.ok(announcementDTO);
    }

}
