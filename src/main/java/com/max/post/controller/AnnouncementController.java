package com.max.post.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AnnouncementController {

    @GetMapping("/announcements/{id}") // get resources
    public String getAnnouncement(@PathVariable Integer id) {
        return "hey, this is an announcement with id= " + id;
    }

    @PostMapping("/") // create resources
    public String createAnnouncement() {
        return "hey, I created an announcement";
    }

    @PutMapping("/") // update resources entirely
    public String updateAnnouncement() {
        return "hey, I update entirely an announcement";
    }

    @PatchMapping("/") // update resources partially
    public String updateAnnouncementPartially() {
        return "hey, I update partially an announcement";
    }

}
