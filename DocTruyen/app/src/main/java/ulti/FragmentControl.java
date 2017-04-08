package ulti;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by TieuHoan on 08/04/2017.
 */

public class FragmentControl {
    public static FragmentManager fragmentManager;
    public static FragmentTransaction transaction;

    public static void goToFragmentAddBackStack(int idFragment, Fragment fragment, Context context, String nameClass) {
        fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.addToBackStack(nameClass);
        transaction.replace(idFragment, fragment);
        transaction.commitAllowingStateLoss();
    }

    public static void goToFragmentNoAddBackStack(int idFragment, Fragment fragment, Context context) {
        fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(idFragment, fragment);
        transaction.commitAllowingStateLoss();
    }

}
