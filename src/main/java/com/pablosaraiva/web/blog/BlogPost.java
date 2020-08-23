package com.pablosaraiva.web.blog;

import com.pablosaraiva.web.data.DbEntity;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class BlogPost implements DbEntity {
    @Id
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
