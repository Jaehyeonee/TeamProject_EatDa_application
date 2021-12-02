package eatda.TeamProject_EatDa_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddMenuActivity extends AppCompatActivity {

    private static final int FROM_CAMERA = 0;
    private static final int FROM_ALBUM = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_menu);

        //tedPermission();

        //ImageView addImage = (ImageView) this.findViewById(R.id.addImageView);
        //ImageButton addButton = (ImageButton) this.findViewById(R.id.addButton);

        //addButton.setOnClickListener(this);
    }



    //카메라에서 사진 촬영
    public void doTakePhotoAction(){

    }
    //앨범에서 이미지 가져오기
    public void  doTakeAlbumAction(){
        //앨범 호출
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, FROM_ALBUM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != RESULT_OK)
            return;
        switch (requestCode){
            case FROM_ALBUM:{

            }
            case FROM_CAMERA:{
                Intent intent = new Intent("com.android.camera.action.CROP");
                //intent.setDataAndType(, "image/*");
            }
        }


    }
    public void onClick(View v){

    }

}
