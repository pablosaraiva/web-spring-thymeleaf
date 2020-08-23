package com.pablosaraiva.web.blog;

import com.github.rjeschke.txtmark.Processor;
import com.pablosaraiva.web.blog.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
