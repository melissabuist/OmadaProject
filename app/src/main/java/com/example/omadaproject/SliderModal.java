package com.example.omadaproject;

public class SliderModal {

    // string variable for storing
    // title, image url and description.
    private String title;
    private String heading;
    private String imgUrl;
    private int backgroundDrawable;

    public SliderModal() {
        // empty constructor is required
        // when using firebase
    }

    // creating the get methods.
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeading() {
        return heading;
    }

    // creating the set methods for the quotes, authors, and images
    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    // constructor for the modal class
    public SliderModal(String title, String heading, String imgUrl, int backgroundDrawable) {
        this.title = title;
        this.heading = heading;
        this.imgUrl = imgUrl;
        this.backgroundDrawable = backgroundDrawable;
    }

    public int getBackgroundDrawable() {
        return backgroundDrawable;
    }

    public void setBackgroundDrawable(int backgroundDrawable) {
        this.backgroundDrawable = backgroundDrawable;
    }
}
