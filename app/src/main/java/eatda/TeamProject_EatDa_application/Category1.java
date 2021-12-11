package eatda.TeamProject_EatDa_application;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Category1 extends AppCompatActivity {

    Dialog custom_dialog2;
    Button showrecipebtn;
    Button gobackbtn;
    //ImageView foodphoto;

    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category1);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        final GridView gv1 = (GridView) findViewById(R.id.gv);
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gv1.setAdapter(gridAdapter);

        //닉네임 설정하기
        TextView mynickname = (TextView)findViewById(R.id.myNickname);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("id");
        databaseReference.child("MyNickname").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        MyNickname myNickname = snapshot.getValue(MyNickname.class);
                        mynickname.setText(myNickname.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );




        //홈버튼
        ImageButton hbtn_l = (ImageButton) findViewById(R.id.hbtn1);
        ImageButton hbtn_r = (ImageButton) findViewById(R.id.hbtn2);

        hbtn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category1.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        hbtn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category1.this, UploadActivity.class);
                startActivity(intent);
            }
        });

    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return imageID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
        Integer[] imageID = {R.drawable.mmimg1, R.drawable.mmimg2,
                R.drawable.mmimg3, R.drawable.mmimg4, R.drawable.mmimg5, R.drawable.mmimg6,
                R.drawable.mmimg7, R.drawable.mmimg8, R.drawable.mmimg9};

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,0);

            imageView.setImageResource(imageID[position]);

            final int pos = position;

            custom_dialog2 = new Dialog(Category1.this);
            custom_dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
            custom_dialog2.setContentView(R.layout.custom_dialog2);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog1();
                }
            });
            return imageView;
        }
        public void showDialog1(){
            custom_dialog2.show();
            showrecipebtn = custom_dialog2.findViewById(R.id.btnshowrecipe);
            gobackbtn = custom_dialog2.findViewById(R.id.btngoback);

            custom_dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            //foodphoto = custom_dialog2.findViewById(R.id.foodphoto);
            //foodphoto.setImageResource(getView());

            showrecipebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent intent = new Intent(Category1.this, );
                    //startActivity(intent);
                }
            });
            gobackbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    custom_dialog2.dismiss();
                }
            });
        }


    }

}
