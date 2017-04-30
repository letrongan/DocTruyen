package database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import model.User;

/**
 * Created by anh hoang anh on 4/8/2017.
 */

public class Acount_DataBase  {


    public static final String PATH = Environment.getDataDirectory() +
            "/data/bustudio.doctruyen/databases/Account.sqlite";
    private Context context;
    private SQLiteDatabase  database;
    public static final String TABLE_NAME = "ACCOUNT";
    public static final String USER = "User";
    public static final String PASS = "Pass";

    public Acount_DataBase(Context context) {
        this.context = context;
        try {
            copyDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void copyDatabase() throws Exception {

        File file = new File(PATH);
        if (!file.exists()) {
            File parent = file.getParentFile();
            parent.mkdirs();
            file.createNewFile();
            InputStream inputStream = context.getAssets().open("Account.sqlite");
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

    public ArrayList<User> readDataBase() {
        openDataBase();
        ArrayList<User> arrUser = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        int indexUser = cursor.getColumnIndex(USER);
        int indexPass = cursor.getColumnIndex(PASS);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(indexUser);
            String pass = cursor.getString(indexPass);
            User user = new User(name,pass);
            arrUser.add(user);
            cursor.moveToNext();

        }
        closeDataBase();
        return arrUser;
    }

    private void openDataBase() {
        database = context.openOrCreateDatabase(PATH, Context.MODE_PRIVATE, null);

    }

    private void closeDataBase() {
        database.close();
    }
}



