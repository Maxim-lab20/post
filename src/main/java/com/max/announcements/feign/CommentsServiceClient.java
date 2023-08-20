package com.max.announcements.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "comments-service", url = "http://localhost:9090")
public interface CommentsServiceClient {

    @GetMapping("/comments/{id}") // http://localhost:9090/comments/{id}
    List<String> getCommentsByAnnouncementId(@PathVariable Integer id);

}
