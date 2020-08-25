package com.pablosaraiva.web.blog;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogPost> getLatestPosts() {
        return blogRepository.findAllByDateDesc();
    }

    public List<BlogPost> getLatestPublishedPosts() {
        return blogRepository.findAllPublishedByDateDesc();
    }


    public BlogPost findById(String id) {
        return blogRepository.findById(id).orElse(null);
    }

    public void save(BlogPost blogPost) {
        blogRepository.save(blogPost);
    }

    public void publish(String id) {
        final BlogPost post = findById(id);
        if (post != null) {
            post.setPublished(true);
        }

        save(post);
    }
}
