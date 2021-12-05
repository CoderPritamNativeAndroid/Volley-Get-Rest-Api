package com.pritampachal.volleyhttplibrary;

public class RecyclerViewModelClass {
    String id,image,albumID,title;

    public RecyclerViewModelClass() {
    }

    public RecyclerViewModelClass(String id, String image, String albumID, String title) {
        this.id = id;
        this.image = image;
        this.albumID = albumID;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAlbumID() {
        return albumID;
    }

    public void setAlbumID(String albumID) {
        this.albumID = albumID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
