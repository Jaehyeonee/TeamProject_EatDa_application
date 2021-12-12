package eatda.TeamProject_EatDa_application;

import android.os.Bundle;
<<<<<<< Updated upstream
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
=======
>>>>>>> Stashed changes

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowCatRecipe2 extends AppCompatActivity {
    Integer[] imageID = {R.drawable.c2img1, R.drawable.c2img2, R.drawable.c2img3, R.drawable.c2img4,
            R.drawable.c2img5, R.drawable.c2img6, R.drawable.c2img7, R.drawable.c2img8, R.drawable.c2img9};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< Updated upstream
        setContentView(R.layout.showrecipe);

        String index = getIntent().getStringExtra("index");

        //Integer int_index = Integer.valueOf(index).intValue();
        ImageView showrecipe = (ImageView) findViewById(R.id.addedMyImageView);
        //showrecipe.setImageResource(imageID[Integer.parseInt(index)]);
=======
        setContentView(R.layout.menu_result);
>>>>>>> Stashed changes
    }
}
