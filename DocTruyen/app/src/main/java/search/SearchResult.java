package search;

import java.io.Serializable;

/**
 * Created by TieuHoan on 11/05/2017.
 */

public class SearchResult implements Serializable {
    private String chapterID;
    private String chapterName;
    private String ssearchContent;
    float scroll;


    public SearchResult(String chapterID, String chapterName, String ssearchContent, float scroll) {
        this.chapterID = chapterID;
        this.chapterName = chapterName;
        this.ssearchContent = ssearchContent;
        this.scroll = scroll;
    }

    public String getChapterID() {
        return chapterID;
    }

    public void setChapterID(String chapterID) {
        this.chapterID = chapterID;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getSsearchContent() {
        return ssearchContent;
    }

    public void setSsearchContent(String ssearchContent) {
        this.ssearchContent = ssearchContent;
    }

    public float getScroll() {
        return scroll;
    }

    public void setScroll(float scroll) {
        this.scroll = scroll;
    }
}