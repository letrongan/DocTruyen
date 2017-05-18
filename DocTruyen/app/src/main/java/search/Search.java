package search;

import android.text.Html;

import java.util.ArrayList;

import model.Chap;

/**
 * Created by TieuHoan on 11/05/2017.
 */

public class Search {
    public static ArrayList<SearchResult> search(ArrayList<Chap> chaps, String keyWord) {
        keyWord = keyWord.trim();
        String[] listKey = keyWord.split(" ");
        if (keyWord.length() == 0 || listKey.length == 0) {
            return null;
        }

        ArrayList<SearchResult> searchResults = new ArrayList<>();

        for (int i = 0; i < chaps.size(); i++) {
            searchResults.addAll(getResult(i + "", chaps.get(i).getNameChap(), tach(chaps.get(i).getContent()), listKey));
        }
        return searchResults;
    }


    public static String[] tach(String content) {
        String s = Html.fromHtml(content).toString().trim();
        String[] s_ = s.split(" ");
        return s_;
    }

    public static ArrayList<SearchResult> getResult(String chapterID, String chapterName, String[] content, String[] listkey) {
        ArrayList<SearchResult>[] searchResults = new ArrayList[5];
        searchResults[0] = new ArrayList<>();
        searchResults[1] = new ArrayList<>();
        searchResults[2] = new ArrayList<>();
        searchResults[3] = new ArrayList<>();
        searchResults[4] = new ArrayList<>();

        for (int i = 0; i < content.length; i++) {
            int last_index = i;
            String s = content[i];
            if (s.compareToIgnoreCase(listkey[0]) == 0) {
                String re = "";
                if (i + listkey.length + 10 < content.length) {
                    int key_index = 0;
                    for (int j = 0; j < (listkey.length + 10); j++) {
                        if (content[i + j].compareToIgnoreCase(listkey[key_index]) == 0) {
                            key_index++;
                            last_index = i + j;
                        }

                        if (key_index >= listkey.length) {
                            break;
                        }

                    }

                    for (int j = i; j <= last_index; j++) {
                        re = re + " " + content[j];
                    }
                }
                if (re != "") {
                    float scroll = 0;
                    float scrollMax = 0;
                    for (int j = 0; j < ((i + last_index) / 2); j++) {
                        scroll += content[j].length() + 1;
                    }

                    for (int j = 0; j < content.length; j++) {
                        scrollMax += content[j].length() + 1;
                    }

                    SearchResult searchResult = new SearchResult(chapterID,
                            chapterName,
                            search.Util.getStringDesLong(i, last_index, content),
                            ((float) (scroll / scrollMax)));

                    if ((last_index - i) == (listkey.length - 1)) {
                        searchResults[0].add(0, searchResult);
                    } else if ((last_index - i) == (listkey.length - 2)) {
                        searchResults[1].add(searchResult);
                    }else if ((last_index - i) == (listkey.length - 3)) {
                        searchResults[2].add(searchResult);
                    }else if ((last_index - i) == (listkey.length - 4)) {
                        searchResults[3].add(searchResult);
                    }else if ((last_index - i) == (listkey.length - 5)) {
                        searchResults[4].add(searchResult);
                    }
                }
            }
        }

        ArrayList<SearchResult> results = new ArrayList<>();
        for(int i = 0; i<5; i++){
            results.addAll(searchResults[i]);
        }

        return results;
    }
}


