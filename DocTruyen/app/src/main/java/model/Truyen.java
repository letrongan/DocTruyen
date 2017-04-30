package model;

import java.io.Serializable;

/**
 * Created by TieuHoan on 17/04/2017.
 */

public class Truyen implements Serializable {
    private String name, describe, imgThumb;
    private int id;

    public Truyen(String name, String describe, int id, String imgThumb) {
        this.name = name;
        this.describe = describe;
        this.id = id;
        this.imgThumb = imgThumb;
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

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
