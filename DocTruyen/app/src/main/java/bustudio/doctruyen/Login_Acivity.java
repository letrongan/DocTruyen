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

/**
 * Created by anh hoang anh on 4/7/2017.
 */

public class Login_Acivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUser;
    private EditText edtPass;
    private ToggleButton cbSave;
    private TextView btnLogin;
    private TextView btnRegister;
    private TextView btnLogin_Face;
    private Acount_DataBase myDataBase;
    private ArrayList<User>arrUser;
    private MyShare myShare;
    private String userName;
    private String password;
    private String isCB;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        myDataBase = new Acount_DataBase(this);
        arrUser = myDataBase.readDataBase();
        myShare = new MyShare(this);
        userName = myShare.getData(MyShare.KEY_USER_NAME);
        password = myShare.getData(MyShare.KEY_PASS);
        isCB = myShare.getData(MyShare.KEY_CB);
        initView();
    }

    private void initView() {
        edtUser = (EditText) this.findViewById(R.id.edtUser);
        edtPass = (EditText) this.findViewById(R.id.edtPass);
        cbSave = (ToggleButton) this.findViewById(R.id.cbSave);
        btnLogin = (TextView) this.findViewById(R.id.btnLogin);
        btnLogin_Face = (TextView) this.findViewById(R.id.btnLogin_Face);
        btnRegister = (TextView) this.findViewById(R.id.btnRegister);
        if (userName.isEmpty() == false || password.isEmpty() == false) {
            edtUser.setText(userName);
            edtPass.setText(password);
        }
        if (isCB.isEmpty()) {
            cbSave.setChecked(false);
        }
        if (!isCB.isEmpty()) {
            cbSave.setChecked(true);
        }
        btnLogin.setOnClickListener(this);
        btnLogin_Face.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String ten = edtUser.getText().toString();
        String pass = edtPass.getText().toString();
        switch (v.getId()){

            case R.id.btnLogin:
                if (cbSave.isChecked()) {
                    myShare.putData(myShare.KEY_PASS, pass);
                    myShare.putData(myShare.KEY_USER_NAME, ten);
                    myShare.putData(myShare.KEY_CB, "isCheck");
                }
                if (!cbSave.isChecked()) {
                    myShare.putData(myShare.KEY_PASS, "");
                    myShare.putData(myShare.KEY_USER_NAME, "");
                    myShare.putData(myShare.KEY_CB, "");
                }
                if (ten.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(Login_Acivity.this, "Vui lòng điền đầy đủ UserName và PassWord", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    for(int i= 0;i<arrUser.size();i++){
                        if(ten.equals(arrUser.get(i).getUserName().toString())
                                &&pass.equals(arrUser.get(i).getPassWord().toString())){
                            Toast.makeText(Login_Acivity.this,"Dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                            break;

                        }
                    }

                    Toast.makeText(Login_Acivity.this,"Sai UserName hoặc PassWord",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnLogin_Face:
                break;
            case R.id.btnRegister:
                break;

        }

    }
}
