package com.kogo.socially.modals;

public class ScreenItem {

    private int imageIntro;
   // private int imageButtonNext;

    public ScreenItem() {
    }

    public ScreenItem(int imageIntro) {
        this.imageIntro = imageIntro;
        //   this.imageButtonNext = imageButtonNext;
    }

   // public int getImageButtonNext() {
    //     return imageButtonNext;
    // }

    // public void setImageButtonNext(int imageButtonNext) {
    //  this.imageButtonNext = imageButtonNext;
    // }

    public int getImageIntro() {
        return imageIntro;
    }

    public void setImageIntro(int imageIntro) {
        this.imageIntro = imageIntro;
    }
}
