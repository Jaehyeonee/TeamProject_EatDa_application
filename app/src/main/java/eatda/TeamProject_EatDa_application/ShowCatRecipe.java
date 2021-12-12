package eatda.TeamProject_EatDa_application;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowCatRecipe extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_result);

        String index = getIntent().getStringExtra("index");
        int int_index = Integer.parseInt(index);

        Integer[] imageID = {R.drawable.mmimg1, R.drawable.mmimg2,
                R.drawable.mmimg3, R.drawable.mmimg4, R.drawable.mmimg5, R.drawable.mmimg6,
                R.drawable.mmimg7, R.drawable.mmimg8, R.drawable.mmimg9};

        ImageView showrecipe = (ImageView) findViewById(R.id.addedMyImageView);
        showrecipe.setImageResource(imageID[int_index]);
    }
}
