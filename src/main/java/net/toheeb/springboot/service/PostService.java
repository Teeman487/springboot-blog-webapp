package net.toheeb.springboot.service;

import net.toheeb.springboot.dto.PostDto;

import java.util.List;

public interface PostService { // Define a method that will retrieve all the posts from database table
List<PostDto> findAllPosts();

void createPost(PostDto postdto);

PostDto findPostById(Long postId);

void updatePost(PostDto postDto);
}
