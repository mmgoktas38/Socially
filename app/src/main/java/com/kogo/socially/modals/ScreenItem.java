package com.kogo.socially.modals;

public class ScreenItem {

    private String title;
    private int imageIntro;
    private int imageButtonNext;

    public ScreenItem() {
    }

    public ScreenItem(String title, int imageIntro, int imageButtonNext) {
        this.title = title;
        this.imageIntro = imageIntro;
        this.imageButtonNext = imageButtonNext;
    }

    public int getImageButtonNext() {
        return imageButtonNext;
    }

    public void setImageButtonNext(int imageButtonNext) {
        this.imageButtonNext = imageButtonNext;
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
