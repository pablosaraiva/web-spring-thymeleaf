package com.pablosaraiva.web.blog;

import com.github.rjeschke.txtmark.Processor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/secure")
public class SecureBlogController {

    private final BlogService blogService;

    public SecureBlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog")
    public String getBlog(Model model) {
        model.addAttribute("posts", blogService.getLatestPosts());
        return "secure-blog";
    }

    @GetMapping("/blog/posts/{id}")
    public String getBlogPost(@PathVariable("id") String id, Model model) {
        final BlogPost blogPost = blogService.findById(id);

        if (blogPost != null) {
            String contentHtml = Processor.process(blogPost.getContent());
            model.addAttribute("renderedContent", contentHtml);
        }
        model.addAttribute("post", blogPost);

        return "secure-blog-post";
    }

    @GetMapping("/blog/create-post")
    public String getCreatePostPage(Model model) {
        model.addAttribute("postForm", new EditBlogPostDto());
        return "secure-edit-post";
    }

    @GetMapping("/blog/edit-post/{id}")
    public String getEditPostPage(@PathVariable String id, Model model) {
        final BlogPost post = blogService.findById(id);
        model.addAttribute("postForm", new EditBlogPostDto(post));
        return "secure-edit-post";
    }

    @GetMapping("/blog/publish/{id}")
    public String publishBlogPost(@PathVariable String id, Model model) {
        blogService.publish(id);

        getBlog(model);

        return "secure-blog";
    }

    @PostMapping("/blog/save-post")
    public String postEditPostPage(@ModelAttribute("postForm") EditBlogPostDto dto, Model model) {
        if (dto.getId() == null || dto.getId().isBlank()) {
            doCreatePost(dto);
        } else {
            doEditPost(dto);
        }

        getBlog(model);

        return "secure-blog";
    }

    private void doEditPost(EditBlogPostDto dto) {
        final BlogPost blogPost = blogService.findById(dto.getId());
        if (blogPost != null) {
            blogPost.setContent(dto.getContent());
            blogPost.setSummary(dto.getSummary());
            blogPost.setTitle(dto.getTitle());
            blogService.save(blogPost);
        }
    }

    private void doCreatePost(EditBlogPostDto dto) {
        final BlogPost blogPost = new BlogPost(dto.getTitle(), dto.getContent(), dto.getSummary(), LocalDateTime.now(), false);
        blogService.save(blogPost);
    }
}
