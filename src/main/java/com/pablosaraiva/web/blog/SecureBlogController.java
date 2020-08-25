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

        return "blog-post";
    }

    @GetMapping("/blog/create-post")
    public String getCreatePostPage(Model model) {
        model.addAttribute("postForm", new NewBlogPostDto());
        return "secure-create-post";
    }

    @PostMapping("/blog/create-post")
    public String postCreatePostPage(@ModelAttribute("postForm") NewBlogPostDto dto, Model model) {
        final BlogPost blogPost = new BlogPost(dto.getTitle(), dto.getContent(), dto.getSummary(), LocalDateTime.now(), false);
        blogService.save(blogPost);

        getBlog(model);

        return "secure-blog";
    }

    @GetMapping("/blog/publish/{id}")
    public String publishBlogPost(@PathVariable String id, Model model) {
        blogService.publish(id);

        getBlog(model);

        return "secure-blog";
    }
}
