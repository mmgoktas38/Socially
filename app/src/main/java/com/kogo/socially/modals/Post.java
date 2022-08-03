package com.kogo.socially.modals;

public class Post {

    private String username;
    private String sharingTime;
    private String profileImage;
    private double likesCount;
    private double commentsCount;
    private int saveCount;
    private String postImage;

    public Post() {
    }

    public Post(String username, String sharingTime, String profileImage, double likesCount, double commentsCount, int saveCount, String postImage) {
        this.username = username;
        this.sharingTime = sharingTime;
        this.profileImage = profileImage;
        this.likesCount = likesCount;
        this.commentsCount = commentsCount;
        this.saveCount = saveCount;
        this.postImage = postImage;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSharingTime() {
        return sharingTime;
    }

    public void setSharingTime(String sharingTime) {
        this.sharingTime = sharingTime;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public double getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(double likesCount) {
        this.likesCount = likesCount;
    }

    public double getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(double commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getSaveCount() {
        return saveCount;
    }

    public void setSaveCount(int saveCount) {
        this.saveCount = saveCount;
    }
}
