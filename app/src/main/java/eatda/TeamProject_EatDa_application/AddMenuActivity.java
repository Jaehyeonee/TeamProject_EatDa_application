package eatda.TeamProject_EatDa_application;

import static java.util.Objects.requireNonNull;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;

public class AddMenuActivity extends AppCompatActivity implements  View.OnClickListener{

    private static final int FROM_CAMERA = 0;
    private static final int FROM_ALBUM = 1;
    private static final int CROP_FROM_iMAGE = 2;

    //private static final int REQUEST_CODE = 0;
    private ImageView photo;
    private int id_view;
    private String absoultePath;
    private Uri mImageCaptureUri;
    private int flag =0 ;

    ImageButton gobackbtn;

    // ?????????????????? ?????????????????? ?????? - ??????
    EditText menuName;
    EditText menuIngredient;
    EditText menuOrder;
    Button submitRecipebtn;
    Dialog custom_dialog;
    Button confirmbtn;  //????????? ????????? ?????????????????? ??????
    Button gopeedbtn;   //??? ????????? ???????????? ??????
    ImageButton hbtn_l;
    ImageButton hbtn_r;


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    private ArrayList<AddMenuData> addMenuDataList = new ArrayList<>();
    private ArrayList<String>recipeNameList= new ArrayList<>();
    //private RecyclerView recyclerView;
    //private RecyclerView.Adapter adapter;
    //private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_menu);
        //?????? ?????? ??????
        gobackbtn=findViewById(R.id.gobackBtn);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        photo = (ImageView)this.findViewById(R.id.addImageView);
        Button addImagebtn = (Button) this.findViewById(R.id.addButton);
        addImagebtn.setOnClickListener(this);


        hbtn_l = (ImageButton) findViewById(R.id.hbtn1);
        hbtn_r = (ImageButton) findViewById(R.id.hbtn2);

        hbtn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AddMenuActivity.this, SelectCategory.class);
                startActivity(intent2);
            }
        });

        hbtn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AddMenuActivity.this, UploadActivity.class);
                startActivity(intent2);
            }
        });



        //??????
        //?????? ?????? ?????? ??????
        gobackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent = new Intent(AddMenuActivity.this, UploadActivity.class);
                startActivity(backintent);
            }
        });
        //??????????????? ?????????
        custom_dialog = new Dialog(AddMenuActivity.this);
        custom_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        custom_dialog.setContentView(R.layout.custom_dialog);

        submitRecipebtn=findViewById(R.id.submit_recipe);
        menuName=findViewById(R.id.menuName);
        menuIngredient=findViewById(R.id.editText1);
        menuOrder=findViewById(R.id.editText2);

        submitRecipebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog1();
                AddMenuData(menuName.getText().toString(), menuIngredient.getText().toString(), menuOrder.getText().toString(), mImageCaptureUri.toString());
                Toast toast = Toast.makeText(AddMenuActivity.this, menuName.getText().toString()+ "????????????\n?????????????????????.", Toast.LENGTH_LONG);
                toast.show();


            }
        });

    }
    //??????????????? ?????????
    public void showDialog1(){
        custom_dialog.show();
        confirmbtn = custom_dialog.findViewById(R.id.btnConfirm);
        gopeedbtn = custom_dialog.findViewById(R.id.btnGopeed);

        custom_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        //????????? ????????????
        gopeedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMenuActivity.this, UploadActivity.class);
                startActivity(intent);

            }
        });
    }

    //?????? ?????????????????? Realtime database??? ????????? ??????
    public void AddMenuData(String name, String ingredient, String order, String imageUri){

        AddMenuData addMenuData = new AddMenuData(name, ingredient, order, imageUri);
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child(mImageCaptureUri.getLastPathSegment());


        storageReference.putFile(mImageCaptureUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

               // AddMenuData addMenuData = new AddMenuData(name, ingredient, order, imageUri);
                //databaseReference.child("Resister My Recipe").push().setValue(addMenuData);
                databaseReference.child("Resister My Recipe").child("data").push().setValue(addMenuData);


                //confirmbtn = custom_dialog.findViewById(R.id.btnConfirm);
                confirmbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getBaseContext(), AddMenu_result_Activity.class);
                        intent.putExtra("addMenuName", addMenuData.getMenuName());
                        intent.putExtra("addMenuIngredient", addMenuData.getIngredient());
                        intent.putExtra("addMenuOrder", addMenuData.getOrder());
                        intent.putExtra("addMenuImage",addMenuData.getAddMenuImage() );
                        startActivity(intent);

                    }
                });


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.getMessage();
            }
        });

    }





    //?????? ?????? ??????
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            int length = permissions.length;
            for (int i = 0; i < length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
                    Log.d("AddMenuActivity", "???????????? : " + permissions[i]);
            }
        }
    }

    /**

     * ??????????????? ?????? ??????

     **/

    public void doTakePhotoAction() // ????????? ?????? ??? ????????? ????????????

    {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // ????????? ????????? ????????? ????????? ??????
        String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));

        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);

        startActivityForResult(intent, FROM_CAMERA);

    }
    /**

     * ???????????? ????????? ????????????

     */
    public void doTakeAlbumAction() // ???????????? ????????? ????????????

    {
        // ?????? ??????
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
                mImageCaptureUri = data.getData();
                Log.d("SmartWheel",mImageCaptureUri.getPath().toString());


            }

            case FROM_CAMERA:
            {
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mImageCaptureUri, "image/*");
                // CROP??? ???????????? 200*200 ????????? ??????
                intent.putExtra("outputX", 200); // CROP??? ???????????? x??? ??????
                intent.putExtra("outputY", 200); // CROP??? ???????????? y??? ??????
                intent.putExtra("aspectX", 1); // CROP ????????? X??? ??????
                intent.putExtra("aspectY", 1); // CROP ????????? Y??? ??????
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, CROP_FROM_iMAGE); // CROP_FROM_CAMERA case??? ??????
                break;
            }
            case CROP_FROM_iMAGE:
            {
                if (resultCode!=RESULT_OK){
                    return;
                }
                final Bundle extras = data.getExtras();
                //crop??? ???????????? ???????????? ?????? ?????? ??????
                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+
                        "/SmartWheel/"+System.currentTimeMillis()+".jpg";
                if(extras != null){
                    Bitmap bitmap = extras.getParcelable("data");
                    photo.setImageBitmap(bitmap);
                    //crop??? ???????????? ????????? ??????
                    storeCropImage(bitmap, filePath);
                    absoultePath = filePath;
                    break;
                }
                File f = new File(mImageCaptureUri.getPath());
                if (f.exists()){
                    f.delete();
                }
            }
        }

    }
    @Override
    public void onClick(View view) {
        id_view = view.getId();
        if (view.getId()==R.id.addButton){
            DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    doTakePhotoAction();
                }
            };
            DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    doTakeAlbumAction();
                }
            };
            DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            };
            new AlertDialog.Builder(this)
                    .setTitle("???????????? ????????? ??????")
                    .setPositiveButton("????????????",cameraListener)
                    .setNeutralButton("?????? ??????",albumListener)
                    .setNegativeButton("??????",cancelListener)
                    .show();

        }

    }
    //bitmap ???????????? ??????
    private void storeCropImage(Bitmap bitmap, String filePath){
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/SmartWheel";
        File directory_SmartWheel = new File(dirPath);


        if (!directory_SmartWheel.exists()) // SmartWheel ??????????????? ????????? ????????? (?????? ???????????? ????????? ????????? ?????????.)

            directory_SmartWheel.mkdir();


        File copyFile = new File(filePath);

        BufferedOutputStream out = null;


        try {


            copyFile.createNewFile();

            out = new BufferedOutputStream(new FileOutputStream(copyFile));

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);


            // sendBroadcast??? ?????? Crop??? ????????? ????????? ???????????? ????????????.

            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,

                    Uri.fromFile(copyFile)));
            out.flush();
            out.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }



}

