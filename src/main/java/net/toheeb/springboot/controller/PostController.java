package net.toheeb.springboot.controller;

import jakarta.validation.Valid;
import net.toheeb.springboot.dto.PostDto;
import net.toheeb.springboot.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller  //
public class PostController { // Spring tea recomend to use interface for injecting the dependency to achieve loose coupling

    private PostService postService; // Spring tea recomend to use interface for injecting the dependency to achieve loose coupling

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create handler method, GET request and return model view
    @GetMapping("/admin/posts")
    public String posts(Model model)  {
        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts",posts);
        return "/admin/posts"; // Thymeleaf view name

    }
    @GetMapping("admin/posts/newpost")
    // handler method to handle new post request
    public String newPostForm(Model model) {
        PostDto postDto = new PostDto();
        model.addAttribute("post",postDto);
        return "admin/create_post";

    }
    // handler method to handle form submit request
    @PostMapping("/admin/posts")
    public String createPost(@Valid @ModelAttribute PostDto postDto,
                 BindingResult result,
                             Model model
                   ){ // ModelAttribute annotation will read form data and set the values to fields of the model object
       if(result.hasErrors()){
          model.addAttribute("post", postDto);
          return "admin/create_post";
       }


        postDto.setUrl(getUrl(postDto.getTitle()));
        postService.createPost(postDto);
        return "redirect:/admin/posts";
    }
    private static String getUrl(String postTitle) {
        // OOPS Concepts Explained in Java
        // oops-concepts-explained-in-java
        String title = postTitle.trim().toLowerCase();
        String url= title.replaceAll("\\s+","-");
        url = url.replaceAll("[^A-Za-z0-9]","-");
        return url;
    }
}
