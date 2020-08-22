package com.pablosaraiva.web.blog;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService {
    public List<BlogPost> getLastPostsSummaries(int numberOfPosts) {
        final BlogPost blogPost = new BlogPost(
                "First post",
                "This is the content",
                "This is the summary", LocalDateTime.of(2020, 8, 22, 8, 18));

        return List.of(blogPost);
    }
}
