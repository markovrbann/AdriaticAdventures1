package com.example.adriaticadventures.ui.forumkrk;

public class Post {
    private String postId;
    private String title;
    private String content;

    public Post() {
        // Default constructor required for Firebase
    }

    public Post(String postId, String title, String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }

    public String getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
