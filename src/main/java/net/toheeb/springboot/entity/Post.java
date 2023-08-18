package net.toheeb.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="posts")
public class Post {   //post jpa entity // To verify whether hibernate will create a database table for this post jpa entity or not

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)  // optional annotation that enables you to customize the mapping between the entity field and the database column
    private String title;
    private String url;
    @Lob
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String content;
    private String shortDescription;

    @CreationTimestamp    // will help to automatically populate value for the field createdon
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updateOn;

}
