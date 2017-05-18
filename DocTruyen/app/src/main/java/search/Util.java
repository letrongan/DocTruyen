package search;

/**
 * Created by TieuHoan on 11/05/2017.
 */

public class Util {
    public static String getStringDesLong(int start, int end, String[] content) {
        String kq = "";
        int l = 15 - (end - start);
        if (l >= 2) {
            kq += " ...";
            if (start >= (l / 2)) {
                for (int i = (start - l / 2); i < start; i++) {
                    kq = kq + " " + content[i];
                }
            } else {
                for (int i = 0; i < start; i++) {
                    kq = kq + " " + content[i];
                }
            }

            for (int i = start; i < end; i++) {
                kq = kq + " " + content[i];
            }

            if ((end + (l / 2)) >= (content.length - 1)) {
                for (int i = end; i < content.length; i++) {
                    kq = kq + " " + content[i];
                }
            } else {
                for (int i = end; i <= (end + l / 2); i++) {
                    kq = kq + " " + content[i];
                }
            }
            kq += "... ";

        } else {
            kq += " ...";
            for (int i = start; i <= end; i++) {
                kq = kq + " " + content[i];
            }
            kq += "... ";
        }
        return kq;
    }

}
