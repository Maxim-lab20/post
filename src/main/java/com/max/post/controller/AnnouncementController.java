package com.max.post.controller;

import com.max.post.model.Announcement;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnnouncementController {

    @GetMapping("/announcements/{id}") // get resources
    public String getAnnouncement(@PathVariable Integer id) {
        return "hey, this is an announcement with id= " + id;
    }

    @GetMapping("/announcements") // get resources
    public String filterAnnouncements(@RequestParam String name,
                                      @RequestParam(required = false) Integer votes) {
        return "we got announcements list filtered by name= " + name + " and votes= " + votes;
    }

    @PostMapping("/announcements") // create resources
    public String createAnnouncement(@RequestBody Announcement announcement) {
        return "announcement saved! announcement data: " + announcement;
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
