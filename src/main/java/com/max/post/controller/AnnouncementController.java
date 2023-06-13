package com.max.post.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AnnouncementController {

    @GetMapping("/") // get resources
    public String getAnnouncement() {
        return "hey, this is an announcement";
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
