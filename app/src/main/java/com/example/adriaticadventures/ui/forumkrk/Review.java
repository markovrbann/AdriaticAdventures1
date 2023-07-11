package com.example.adriaticadventures.ui.forumkrk;

public class Review {
    private String content;

    public Review() {
        // Potreban prazan konstruktor za Firebase Firestore
    }

    public Review(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
