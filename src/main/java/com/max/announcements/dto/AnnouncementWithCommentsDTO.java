package com.max.announcements.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class AnnouncementWithCommentsDTO {

    private AnnouncementDTO announcementDTO;
    private List<String> comments;

}
