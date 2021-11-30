package eatda.TeamProject_EatDa_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//TODO: 로그인 입력안하면 다음으로 못 넘어가게

public class LoginActivity extends AppCompatActivity {
    ImageButton btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        btn_login= (ImageButton) findViewById(R.id.mainStartBtn);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MyMenu_MainRecycleView.class);
                startActivity(intent);

            }
        });








    }
}
