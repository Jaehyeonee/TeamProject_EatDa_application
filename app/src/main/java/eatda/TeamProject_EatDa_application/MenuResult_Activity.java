package eatda.TeamProject_EatDa_application;

import android.content.Intent;
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

    private ImageView menuImageview;
    private int imageResId;
    private ArrayList<Dictionary_MyMenu> mItemList;
    ImageButton gobackbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_result);

        menuImageview=findViewById(R.id.addedMyImageView);  //메뉴 이미지 보여주기
        gobackbtn=findViewById(R.id.gobackBtn);

        String strTitle ="";
        Integer imageResId;

        Bundle extras = getIntent().getExtras();

        strTitle = extras.getString("strTitle");
        imageResId = extras.getInt("imageResId");

        TextView textView = (TextView)findViewById(R.id.menu_titleTextview) ;
        ImageView imageView =(ImageView)findViewById(R.id.addedMyImageView) ;
        String strMenuTitle = strTitle;
        Integer integerImgResId = imageResId;
        textView.setText(strMenuTitle);
        imageView.setImageResource(integerImgResId);



        gobackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent = new Intent(MenuResult_Activity.this, UploadActivity.class);
                startActivity(backintent);
            }
        });

    }

}

