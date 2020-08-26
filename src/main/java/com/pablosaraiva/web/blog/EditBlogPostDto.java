package com.pablosaraiva.web.blog;

public class EditBlogPostDto {
    private String id;
    private String title;
    private String summary;
    private String content;

    public EditBlogPostDto() {

    }

    public EditBlogPostDto(BlogPost post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.summary = post.getSummary();
        this.content = post.getContent();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
