package com.max.post.dto;

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

    @NotBlank
    private String text;
    @NotBlank
    private String author;
    @Min(0)
    private Integer votes;
    @NotEmpty
    @Email
    private String email;

    /*
    Important Java bean validations
    @NotNull validates that the annotated property value is not null.
    @Size validates that the annotated property value has a size between the attributes min and max; can be applied to String, Collection, Map, and array properties.
    @Min validates that the annotated property has a value not smaller than the value attribute.
    @Max validates that the annotated property has a value no larger than the value attribute.
    @Email validates that the annotated property is a valid email address.
    not null and not "" = @NotEmpty validates that the property is not null or empty; can be applied to String, Collection, Map, or Array values.
    not null, not "" and not " ","   " = @NotBlank can be applied only to text values and validates that the property is not null or whitespace.
    */

}
