package com.max.announcements.feign.clients;

import com.max.announcements.feign.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "comments-service",
        url = "http://localhost:9090",
        configuration = FeignConfiguration.class
)
public interface CommentsServiceClient {

    // this method calls -> http://localhost:9090/comments/{id}
    @GetMapping("/comments/{id}")
    List<String> getCommentsByAnnouncementId(@PathVariable Integer id);

}
