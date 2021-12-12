package eatda.TeamProject_EatDa_application;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowCatRecipe3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_result);

        String index = getIntent().getStringExtra("index");
        int int_index = Integer.parseInt(index);

        Integer[] imageID = {R.drawable.c3img1,R.drawable.c3img2,R.drawable.c3img3};

        ImageView showrecipe = (ImageView) findViewById(R.id.addedMyImageView);
        showrecipe.setImageResource(imageID[int_index]);

    }
}
