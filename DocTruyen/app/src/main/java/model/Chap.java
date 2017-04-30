package model;

import java.io.Serializable;

/**
 * Created by TieuHoan on 21/04/2017.
 */

public class Chap implements Serializable {
    private int id ;
    private String  nameChap  , content ;

    public Chap() {
    }

    public Chap(int id, String nameChap, String content) {
        this.id = id;
        this.nameChap = nameChap;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNameChap() {
        return nameChap;
    }

    public void setNameChap(String nameChap) {
        this.nameChap = nameChap;
    }
}
