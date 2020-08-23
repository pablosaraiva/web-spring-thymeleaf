package com.pablosaraiva.web.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogPostController {

    private final BlogService blogService;

    public BlogPostController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("blog/posts/{id}")
    public String getBlogPost(@PathVariable("id") String id, Model model) {
        model.addAttribute("post", blogService.findById(id));

        return "blog-post";
    }

}
