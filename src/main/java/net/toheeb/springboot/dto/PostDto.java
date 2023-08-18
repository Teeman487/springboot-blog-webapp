package net.toheeb.springboot.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto { //Model entity// PostDto is useful when we want to transport data between Controller layer & View Layer
    private Long id;
    @NotEmpty(message = "post title should not be empty")
    private String title;
    private String url;
    @NotEmpty(message = "post content should not be empty")
    private String content;
    @NotEmpty(message = "post short description should not be empty")
    private String shortDescription;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
}
