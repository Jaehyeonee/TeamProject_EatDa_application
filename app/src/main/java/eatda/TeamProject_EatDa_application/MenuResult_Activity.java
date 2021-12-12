package eatda.TeamProject_EatDa_application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MenuResult_Activity extends AppCompatActivity {

<<<<<<< Updated upstream
    private ArrayList<Dictionary_MyMenu> mItemList;
=======

>>>>>>> Stashed changes
    ImageButton gobackbtn;
    ImageView recipeImage_iv;
    TextView recipeTitle_tv;
    TextView recipeOrder_tv;
    TextView recipeIngredient_tv;
<<<<<<< Updated upstream
=======
    ImageButton hbtn_l;
    ImageButton hbtn_r;
>>>>>>> Stashed changes

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_result);

        recipeImage_iv=findViewById(R.id.addedMyImageView);  //메뉴 이미지 보여주기
        gobackbtn=findViewById(R.id.gobackBtn);
        recipeTitle_tv=findViewById(R.id.menu_titleTextview);
        recipeIngredient_tv=findViewById(R.id.ingredientTextView);
        recipeOrder_tv=findViewById(R.id.orderTextView);
<<<<<<< Updated upstream

        String addMenuName ="";
        String addMenuIngredient="";
        String addMenuOrder;
        String addMenuImage;

=======
        hbtn_l=findViewById(R.id.hbtn1);
        hbtn_r=findViewById(R.id.hbtn2);

        String addMenuName ="";
        String addMenuIngredient="";
        String addMenuOrder;
        String addMenuImage;

>>>>>>> Stashed changes
        //Integer imageResId;

        Bundle extras = getIntent().getExtras();

        addMenuName = extras.getString("addMenuName");
        addMenuIngredient=extras.getString("addMenuIngredient");
        addMenuOrder=extras.getString("addMenuOrder");
        addMenuImage=extras.getString("addMenuImage");

        //imageResId = extras.getInt("imageResId");

        String strMenuTitle = addMenuName;
        String strMenuIngredient = addMenuIngredient;
        String strMenuOrder = addMenuOrder;
        String strImageUri = addMenuImage;
        //Integer integerImgResId = imageResId;
        recipeTitle_tv.setText(strMenuTitle);
        recipeIngredient_tv.setText(strMenuIngredient);
        recipeOrder_tv.setText(strMenuOrder);
        recipeImage_iv.setImageURI(Uri.parse(strImageUri));


        gobackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent = new Intent(MenuResult_Activity.this, UploadActivity.class);
                startActivity(backintent);
<<<<<<< Updated upstream
=======
            }
        });

        hbtn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuResult_Activity.this, SelectCategory.class);
                startActivity(intent);
            }
        });
        hbtn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuResult_Activity.this, UploadActivity.class);
                startActivity(intent);
>>>>>>> Stashed changes
            }
        });

    }

}

