package com.max.announcements.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class AnnouncementDTO {

    private Integer id;
    @NotBlank
    private String text;
    @NotBlank
    private String author;
    @Min(0)
    private Integer votes;
    @NotEmpty
    @Email
    private String email;

}
