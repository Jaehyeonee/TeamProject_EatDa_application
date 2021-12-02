package eatda.TeamProject_EatDa_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Category2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category2);


        //홈버튼
        ImageButton hbtn_l = (ImageButton) findViewById(R.id.ripple_left);
        ImageButton hbtn_r = (ImageButton) findViewById(R.id.ripple_right);

        hbtn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category2.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        hbtn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category2.this, MyRecipeMain.class);
                startActivity(intent);
            }
        });
    }
}
