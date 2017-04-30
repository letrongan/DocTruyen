package ulti;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import model.Chap;
import model.Truyen;

/**
 * Created by TieuHoan on 17/04/2017.
 */

public class ReadDataBase {
    public String PATH = Environment.getDataDirectory() +
            "/data/bustudio.doctruyen/databases/kimdung.db";
    private Context context;
    private String NAME_DATABASE = "kimdung.db";
    private SQLiteDatabase sqLiteDatabase;
    private String ID = "stID", NAME = "stName", DESCRIBE = "stDescribe", IMG_THUMB = "stImage", NAME_CHAP = "deName", CONTENT_CHAP = "decontent";


    private String NAME_TABLE_KIM_DUNG = "kimdung", NAME_TABLE_ST_KIM_DUNG = "st_kimdung";

    public ReadDataBase(Context context) {
        this.context = context;
        try {
            copyDatabase(PATH, NAME_DATABASE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void copyDatabase(String path, String nameDataBase) throws Exception {

        File file = new File(path);
        if (!file.exists()) {
            File parent = file.getParentFile();
            parent.mkdirs();
            file.createNewFile();
            InputStream inputStream = context.getAssets().open(nameDataBase);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int count = inputStream.read(b);
            while (count != -1) {
                outputStream.write(b, 0, count);
                count = inputStream.read(b);
            }
            outputStream.close();
            inputStream.close();
        }


    }

    public ArrayList<String> getNameChap(String idQuery) {
        openDataBase();
        ArrayList<String> nameChaps = new ArrayList<>();
        String[] tableColumns = new String[]{
                ID, NAME_CHAP
        };
        String whereClause = ID + " = ? OR " + ID + " = ?";
        String[] whereArgs = new String[]{
                idQuery
        };

        Cursor cursor = sqLiteDatabase.query(NAME_TABLE_ST_KIM_DUNG, tableColumns, whereClause, whereArgs, null, null, null);
        int indexNameChap = cursor.getColumnIndex(NAME_CHAP);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            String nameChap = cursor.getString(indexNameChap);
            nameChaps.add(nameChap);
            cursor.moveToNext();
        }

        closeDataBase();
        return nameChaps;
    }

    public ArrayList<Chap> getAllChap(String idQuery) {

        openDataBase();
        ArrayList<Chap> chaps = new ArrayList<>();

        String[] tableColumns = new String[]{
                ID, NAME_CHAP, CONTENT_CHAP
        };
        String whereClause = ID + " = ? OR " + ID + " = ?";
        String[] whereArgs = new String[]{
                idQuery
        };

//        String query = "SELECT deName , decontent FROM st_kimdung WHERE stID =" + idQuery;
        Cursor cursor = sqLiteDatabase.query(NAME_TABLE_ST_KIM_DUNG, tableColumns, whereClause, whereArgs, null, null, null);
        int indexID = cursor.getColumnIndex(ID);
        int indexNameChap = cursor.getColumnIndex(NAME_CHAP);
        int indexContent = cursor.getColumnIndex(CONTENT_CHAP);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(indexID);
            String nameChap = cursor.getString(indexNameChap);
            String contentChap = "<html><body>" + cursor.getString(indexContent) + "</body></html>";
            Chap chap = new Chap(id, nameChap, contentChap);
            chaps.add(chap);
            cursor.moveToNext();
        }

        closeDataBase();
        return chaps;
    }

    public ArrayList<Truyen> getTruyen() {
        openDataBase();
        ArrayList<Truyen> truyens = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(NAME_TABLE_KIM_DUNG, null, null, null, null, null, null);
        int indexID = cursor.getColumnIndex(ID);
        int indexNAME = cursor.getColumnIndex(NAME);
        int indexImgThumb = cursor.getColumnIndex(IMG_THUMB);
        int indexDESCRIBE = cursor.getColumnIndex(DESCRIBE);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Integer id = cursor.getInt(indexID);
            String name = cursor.getString(indexNAME);
            String imgThumb = cursor.getString(indexImgThumb);
            String describe = "<html><body>" + cursor.getString(indexDESCRIBE) + "</body></html>";
            Truyen truyen = new Truyen(name, describe, id, imgThumb);
            truyens.add(truyen);
            cursor.moveToNext();
        }
        closeDataBase();
        return truyens;
    }

    private void openDataBase() {
        sqLiteDatabase = context.openOrCreateDatabase(PATH, Context.MODE_PRIVATE, null);

    }

    private void closeDataBase() {
        sqLiteDatabase.close();
    }
}
