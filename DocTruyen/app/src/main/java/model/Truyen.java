package model;

import java.io.Serializable;

/**
 * Created by TieuHoan on 17/04/2017.
 */

public class Truyen implements Serializable {
    private String name, describe, imgThumb;
    private int id, viewCount;
    private int favorite;

    public Truyen() {
    }

    public Truyen(String name, String describe, String imgThumb, int id, int viewCount, int favorite) {
        this.name = name;
        this.describe = describe;
        this.imgThumb = imgThumb;
        this.id = id;
        this.favorite = favorite;
        this.viewCount = viewCount;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public String getImgThumb() {
        return imgThumb;
    }

    public void setImgThumb(String imgThumb) {
        this.imgThumb = imgThumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
