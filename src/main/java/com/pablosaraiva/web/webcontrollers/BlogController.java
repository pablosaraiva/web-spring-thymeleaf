package com.pablosaraiva.web.webcontrollers;

import com.pablosaraiva.web.blog.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog")
    public String getBlog(Model model) {
        model.addAttribute("posts", blogService.getLastPostsSummaries(1));
        return "blog";
    }
}
