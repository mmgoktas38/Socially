package com.kogo.socially.modals;

public class ScreenItem {

    private String title;
    private int imageIntro;

    public ScreenItem() {
    }

    public ScreenItem(String title, int imageIntro) {
        this.title = title;
        this.imageIntro = imageIntro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageIntro() {
        return imageIntro;
    }

    public void setImageIntro(int imageIntro) {
        this.imageIntro = imageIntro;
    }
}
