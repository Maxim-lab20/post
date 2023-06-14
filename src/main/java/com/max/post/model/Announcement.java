package com.max.post.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Announcement {

    private String text;
    private String author;
    private Integer votes;

}
