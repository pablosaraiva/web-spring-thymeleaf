package com.pablosaraiva.web.blog;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BlogService {
    public List<BlogPost> getLastPostsSummaries(int numberOfPosts) {
        return generatePosts(5);
    }

    private List<BlogPost> generatePosts(int numberOfPosts) {
        final List<BlogPost> blogPosts = new ArrayList<>(numberOfPosts);
        for (int i = 0; i < numberOfPosts; i++) {
            blogPosts.add(buildFakePost(UUID.randomUUID().toString()));
        }

        return blogPosts;
    }

    public BlogPost findById(String id) {
        return buildFakePost(id);
    }

    private BlogPost buildFakePost(String id) {
        return new BlogPost(
                "Post " + id,
                "This is the content",
                "This is the summary", LocalDateTime.of(2020, 8, 22, 8, 18));
    }
}
