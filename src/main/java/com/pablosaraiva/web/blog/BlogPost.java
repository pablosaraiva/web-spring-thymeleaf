package com.pablosaraiva.web.blog;

import java.time.LocalDateTime;

public class BlogPost {
    private final String title;
    private final String content;
    private final String summary;
    private final LocalDateTime dateTime;

    public BlogPost(String title, String content, String summary, LocalDateTime dateTime) {
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
}
