package eatda.TeamProject_EatDa_application;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowCatRecipe extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_result);

<<<<<<< Updated upstream
        String index = getIntent().getStringExtra("index");
        //int int_index = Integer.parseInt(index);

        Integer[] imageID = {R.drawable.c2img1, R.drawable.c2img2, R.drawable.c2img3, R.drawable.c2img4,
                R.drawable.c2img5, R.drawable.c2img6, R.drawable.c2img7, R.drawable.c2img8, R.drawable.c2img9};
        ImageView showrecipe = (ImageView) findViewById(R.id.addedMyImageView);
        //showrecipe.setImageResource(imageID[int_index]);
=======
        //Integer index = getIntent().getIntExtra("index");
>>>>>>> Stashed changes
    }
}
