package bustudio.doctruyen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

import database.Acount_DataBase;
import database.MyShare;
import model.User;

/**
 * Created by TieuHoan on 08/04/2017.
 */

public class LogInFragment extends Fragment implements View.OnClickListener {
    private EditText edtUser;
    private EditText edtPass;
    private ToggleButton cbSave;
    private TextView btnLogin;
    private TextView btnRegister;
    private TextView btnLogin_Face;
    private Acount_DataBase myDataBase;
    private ArrayList<User> arrUser;
    private MyShare myShare;
    private String userName;
    private String password;
    private String isCB;
    private Context context;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        myDataBase = new Acount_DataBase(context);
        arrUser = myDataBase.readDataBase();
        myShare = new MyShare(context);
        userName = myShare.getData(MyShare.KEY_USER_NAME);
        password = myShare.getData(MyShare.KEY_PASS);
        isCB = myShare.getData(MyShare.KEY_CB);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.log_in_fragment, null, false);
        initView(view);
        return view;


    }


    private void initView(View view) {
        edtUser = (EditText) view.findViewById(R.id.edtUser);
        edtPass = (EditText) view.findViewById(R.id.edtPass);
        cbSave = (ToggleButton) view.findViewById(R.id.cbSave);
        btnLogin = (TextView) view.findViewById(R.id.btnLogin);
        btnLogin_Face = (TextView) view.findViewById(R.id.btnLogin_Face);
        btnRegister = (TextView) view.findViewById(R.id.btnRegister);
        if (userName.isEmpty() == false || password.isEmpty() == false){
            edtUser.setText(userName);
            edtPass.setText(password);
            if (isCB.isEmpty()) {
            }
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
        switch (v.getId()) {

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
                    Toast.makeText(context, "Vui lòng điền đầy đủ UserName và PassWord", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    for (int i = 0; i < arrUser.size(); i++) {
                        if (ten.equals(arrUser.get(i).getUserName().toString())
                                && pass.equals(arrUser.get(i).getPassWord().toString())) {
                            Toast.makeText(context, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                            return;

                        }
                    }

                    Toast.makeText(context, "Sai UserName hoặc PassWord", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnLogin_Face:
                break;
            case R.id.btnRegister:
                break;

        }

    }
}
