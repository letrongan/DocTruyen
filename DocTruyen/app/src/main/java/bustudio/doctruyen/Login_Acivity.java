package bustudio.doctruyen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

import database.Acount_DataBase;
import database.MyShare;
import model.User;
import ulti.FragmentControl;

/**
 * Created by anh hoang anh on 4/7/2017.
 */

public class Login_Acivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        initFragment();

    }

    public void initFragment() {
        FragmentControl fragmentControl = new FragmentControl();
        fragmentControl.goToFragmentAddBackStack(R.id.frameLogIn, new LogInFragment(), Login_Acivity.this, getClass().getName());
    }



}
