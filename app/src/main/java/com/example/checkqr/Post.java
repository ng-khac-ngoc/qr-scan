package com.example.checkqr;

public class Post {
    private String urlCheck;

    public Post(String urlCheck) {
        this.urlCheck = urlCheck;
    }

    public String getUrlCheck() {
        return urlCheck;
    }

    public void setUrlCheck(String urlCheck) {
        this.urlCheck = urlCheck;
    }

    @Override
    public String toString() {
        return "Post{" +
                "urlCheck='" + urlCheck + '\'' +
                '}';
    }
}
