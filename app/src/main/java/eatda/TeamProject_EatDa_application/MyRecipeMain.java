package eatda.TeamProject_EatDa_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//TODO: 필요없는 JAVA 코드 XML 참고용으로 냅둠.


public class MyRecipeMain extends AppCompatActivity {
    ImageButton addMenuBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myrecipe_main);
        addMenuBtn=findViewById(R.id.addMenuBtton);
        addMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMenuIntent = new Intent(MyRecipeMain.this, AddMenuActivity.class );
            }
        });

        //홈버튼
        ImageButton hbtn_l = (ImageButton) findViewById(R.id.hbtn1);
        ImageButton hbtn_r = (ImageButton) findViewById(R.id.hbtn2);

        hbtn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyRecipeMain.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        hbtn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyRecipeMain.this, MyMenu_MainRecycleView.class);
                startActivity(intent);
            }
        });
    }


}
