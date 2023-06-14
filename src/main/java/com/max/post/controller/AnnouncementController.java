package com.max.post.controller;

import com.max.post.model.Announcement;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnnouncementController {

    @GetMapping("/announcements/{id}")
    public String getAnnouncement(@PathVariable Integer id,
                                  HttpServletRequest request) {
        String uniqueId = request.getHeader("unique-id");
        return String.format("announcement with id = %s, the request is having unique-id = %s",
                id, uniqueId);
    }

    @GetMapping("/announcements")
    public String filterAnnouncements(@RequestParam String name,
                                      @RequestParam(required = false) Integer votes) {
        return String.format("we got announcements list filtered by name = %s and votes = %s",
                name,
                votes);
    }

    @PostMapping("/announcements")
    public String createAnnouncement(@RequestBody Announcement announcement) {
        return String.format("announcement saved! announcement data: %s ", announcement);
    }

}
