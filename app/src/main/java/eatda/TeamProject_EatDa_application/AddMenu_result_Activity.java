package eatda.TeamProject_EatDa_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddMenu_result_Activity extends AppCompatActivity {
    private ImageView menuImageview;
    private int imageResId;
    ImageButton gobackbtn;
    TextView recipeTitle_tv;
    TextView recipeOrder_tv;
    TextView recipeIngredient_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_result);

        menuImageview=findViewById(R.id.addedMyImageView);  //메뉴 이미지 보여주기
        gobackbtn=findViewById(R.id.gobackBtn);
        recipeTitle_tv=findViewById(R.id.menu_titleTextview);
        recipeIngredient_tv=findViewById(R.id.ingredientTextView);
        recipeOrder_tv=findViewById(R.id.orderTextView);

        String addMenuName ="";
        String addMenuIngredient="";
        String addMenuOrder;

        //Integer imageResId;

        Bundle extras = getIntent().getExtras();

        addMenuName = extras.getString("addMenuName");
        addMenuIngredient=extras.getString("addMenuIngredient");
        addMenuOrder=extras.getString("addMenuOrder");

        //imageResId = extras.getInt("imageResId");

        String strMenuTitle = addMenuName;
        String strMenuIngredient = addMenuIngredient;
        String strMenuOrder = addMenuOrder;
        //Integer integerImgResId = imageResId;
        recipeTitle_tv.setText(strMenuTitle);
        recipeIngredient_tv.setText(strMenuIngredient);
        recipeOrder_tv.setText(strMenuOrder);
        //imageView.setImageResource(integerImgResId);



        gobackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent = new Intent(AddMenu_result_Activity.this, MyMenu_MainRecycleView.class);
                startActivity(backintent);
            }
        });

    }

}


