package net.toheeb.springboot.mapper;

import net.toheeb.springboot.dto.PostDto;
import net.toheeb.springboot.entity.Post;

public class PostMapper {

    // map Post entity to PostDto
    public static PostDto mapToPostDto(Post post){
       // PostDto  postDto = PostDto.builder()
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updateOn(post.getUpdateOn())
                .build();
        //return postDto;
    }

    // MAP Postdto to Post entity
    public static Post mapToPost(PostDto postDto) {
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .url(postDto.getUrl())
                .content(postDto.getContent())
                .shortDescription(postDto.getShortDescription())
                .createdOn(postDto.getCreatedOn())
                .updateOn(postDto.getUpdateOn())
                .build();
    }
}
