package com.pablosaraiva.web.blog;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class BlogPost {
    @Id
    private final String id;
    private final String title;
    private final String content;
    private final String summary;
    private final LocalDateTime dateTime;

    public BlogPost(String id, String title, String content, String summary, LocalDateTime dateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getSummary() {
        return summary;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getId() {
        return id;
    }
}
