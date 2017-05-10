package ulti;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

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
            "/data/bustudio.doctruyen/databases/kd.db";
    private Context context;
    private String NAME_DATABASE = "kd.db";
    private SQLiteDatabase sqLiteDatabase;
    private String FAVORITE = "favorite", VIEW_COUNT = "viewcount", ID = "stID", NAME = "stName", DESCRIBE = "stDescribe", IMG_THUMB = "stImage", NAME_CHAP = "deName", CONTENT_CHAP = "decontent";


    private String NAME_TABLE_KIM_DUNG = "kimdung", NAME_TABLE_ST_KIM_DUNG = "st_kimdung";


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
        int indexViewCount = cursor.getColumnIndex(VIEW_COUNT);
        int indexFavorite = cursor.getColumnIndex(FAVORITE);
        Log.e("indexViewCount", String.valueOf(indexViewCount));
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Integer id = cursor.getInt(indexID);
            Integer viewCount = cursor.getInt(indexViewCount);
            String name = cursor.getString(indexNAME);
            String imgThumb = cursor.getString(indexImgThumb);
            String describe = "<html><body>" + cursor.getString(indexDESCRIBE) + "</body></html>";
            int favorite = cursor.getInt(indexFavorite);
            Truyen truyen = new Truyen(name, describe, imgThumb, id, viewCount, favorite);
            truyens.add(truyen);
            cursor.moveToNext();
        }
        closeDataBase();
        return truyens;
    }

    public ArrayList<Truyen> getFavoriteTruyen() {
        ArrayList<Truyen> truyens = new ArrayList<>();

        for (Truyen truyen : getTruyen()) {
            if (truyen.getFavorite() == 1) {
                truyens.add(truyen);
            }
        }
        return truyens;
    }

    public void writeContinue(int idchap, int idtruyen, Context context) {
        {
            openDataBase();
            ContentValues cv = new ContentValues();

            try {
                sqLiteDatabase.beginTransaction();
                cv.put("idchap", idchap);
                cv.put("idtruyen", idtruyen);
//                cv.put("iduser", iduser);

                sqLiteDatabase.insert("continue", null, cv);
                sqLiteDatabase.setTransactionSuccessful();
                Log.e("continues", "success");
            } catch (Exception ex) {

            } finally {
                sqLiteDatabase.endTransaction();
                closeDataBase();
            }
        }
    }

    public void addViewCount(int viewCount, String idQuery) {

        openDataBase();
        ContentValues cv = new ContentValues();
        cv.put(VIEW_COUNT, viewCount);

        String whereClause = ID + " = ? OR " + ID + " = ?";
        String[] whereArgs = new String[]{
                idQuery
        };
        sqLiteDatabase.update(NAME_TABLE_KIM_DUNG, cv, whereClause, whereArgs);

        closeDataBase();
    }

    public void addFavorite(int favorite, String idQuery) {
        openDataBase();
        ContentValues cv = new ContentValues();
        cv.put(FAVORITE, favorite);

        String whereClause = ID + " = ? OR " + ID + " = ?";
        String[] whereArgs = new String[]{
                idQuery
        };
        sqLiteDatabase.update(NAME_TABLE_KIM_DUNG, cv, whereClause, whereArgs);

        closeDataBase();

    }


    private void openDataBase() {
        sqLiteDatabase = context.openOrCreateDatabase(PATH, Context.MODE_PRIVATE, null);

    }

    private void closeDataBase() {
        sqLiteDatabase.close();
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

    public ReadDataBase(Context context) {
        this.context = context;
        try {
            copyDatabase(PATH, NAME_DATABASE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
