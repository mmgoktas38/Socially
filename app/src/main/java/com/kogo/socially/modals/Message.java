package com.kogo.socially.modals;

public class Message {

    private String profileImage;
    private String nameSurname;
    private String message;

    public Message() {
    }

    public Message(String profileImage, String nameSurname, String message) {
        this.profileImage = profileImage;
        this.nameSurname = nameSurname;
        this.message = message;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
