package com.pablosaraiva.web.blog;

import com.pablosaraiva.web.data.DbEntity;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class BlogPost implements DbEntity {
    @Id
    private String id;
    private String title;
    private String content;
    private String summary;
    private final LocalDateTime dateTime;
    private boolean published;

    public BlogPost(String title, String content, String summary, LocalDateTime dateTime, boolean published) {
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.dateTime = dateTime;
        this.published = published;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
