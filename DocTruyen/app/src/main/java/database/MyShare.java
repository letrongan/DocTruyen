package database;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by nguyenhoanganh on 21/02/2017.
 */

public class MyShare {
    public static final String KEY_USER_NAME = "key_user_name";
    public static final String KEY_PASS = "key_password";
    private SharedPreferences preferences;
    public static final String KEY_CB ="key_checkBox";

    public MyShare(Context context) {
        preferences = context.getSharedPreferences("MyShared", context.MODE_PRIVATE);
    }

    public void putData(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getData(String key) {
        return preferences.getString(key, "");
    }
}
