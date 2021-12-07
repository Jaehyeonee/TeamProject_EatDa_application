package eatda.TeamProject_EatDa_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


//TODO: 로그인 입력안하면 다음으로 못 넘어가게 (완료)

public class LoginActivity extends AppCompatActivity {
    ImageButton btn_login;
    TextInputEditText edit_id;
    TextInputEditText edit_pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        edit_id =(TextInputEditText) findViewById(R.id.edit_id);
        edit_pwd =(TextInputEditText)findViewById(R.id.edit_pwd);

        btn_login= (ImageButton) findViewById(R.id.mainStartBtn);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_id = edit_id.getEditableText().toString();
                String pwd = edit_pwd.getEditableText().toString();

                if(user_id.length()==0 || pwd.length()==0){
                    //아이디 비밀번호 필수 입력사항
                    Toast toast = Toast.makeText(LoginActivity.this, "입력사항이 누락되었습니다", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                Intent intent = new Intent(LoginActivity.this, MyMenu_MainRecycleView.class);
                startActivity(intent);

            }
        });


    }
}
