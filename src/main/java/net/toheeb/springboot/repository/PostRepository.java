package net.toheeb.springboot.repository;

import net.toheeb.springboot.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository <Post, Long>{ // Post-Entity Type, Long-Primary Type
    Optional<Post> findByUrl(String url);
}
