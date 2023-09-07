package net.toheeb.springboot.service.impl;

import net.toheeb.springboot.dto.PostDto;
import net.toheeb.springboot.entity.Post;
import net.toheeb.springboot.mapper.PostMapper;
import net.toheeb.springboot.repository.PostRepository;
import net.toheeb.springboot.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service   // this annottaion indicates that PostServiceImpl is a spring service class,
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        /*return posts.stream().map((post) -> PostMapper.mapToPostDto(post))
                .collect(Collectors.toList());*/
        return posts.stream().map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = PostMapper.mapToPost(postDto);
        postRepository.save(post);
    }

    @Override
    public PostDto findPostById(Long postId) {
        Post post = postRepository.findById(postId).get();
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public void updatePost(PostDto postDto) {
        Post post = PostMapper.mapToPost(postDto);
        postRepository.save(post);

    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
