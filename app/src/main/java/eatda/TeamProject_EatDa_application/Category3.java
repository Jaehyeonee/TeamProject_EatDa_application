package eatda.TeamProject_EatDa_application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

<<<<<<< Updated upstream
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Category3 extends AppCompatActivity {
    Dialog custom_dialog2;
    Button showrecipebtn;
    Button gobackbtn;

    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
=======
public class Category3 extends AppCompatActivity {
>>>>>>> Stashed changes
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category3);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        final GridView gv3 = (GridView) findViewById(R.id.gv);
        Category3.MyGridAdapter gridAdapter = new Category3.MyGridAdapter(this);
        gv3.setAdapter(gridAdapter);


        //홈버튼
        ImageButton hbtn_l = (ImageButton) findViewById(R.id.hbtn1);
        ImageButton hbtn_r = (ImageButton) findViewById(R.id.hbtn2);

        hbtn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category3.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        hbtn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category3.this, UploadActivity.class);
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
        Integer[] imageID = {R.drawable.c3img1,R.drawable.c3img2,R.drawable.c3img3};

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,0);

            imageView.setImageResource(imageID[position]);

<<<<<<< Updated upstream
            custom_dialog2 = new Dialog(Category3.this);
            custom_dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
            custom_dialog2.setContentView(R.layout.custom_dialog2);

            Intent intent = new Intent(Category3.this, ShowCatRecipe3.class);


=======
>>>>>>> Stashed changes
            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = (View)View.inflate(Category3.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Category3.this);
                    ImageView ivPoster = (ImageView)dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(imageID[pos]);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageView;
        }
<<<<<<< Updated upstream
        public void showDialog1(){
            custom_dialog2.show();
            showrecipebtn = custom_dialog2.findViewById(R.id.btnshowrecipe);
            gobackbtn = custom_dialog2.findViewById(R.id.btngoback);

            custom_dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));



            showrecipebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Category3.this, ShowCatRecipe2.class );
                    startActivity(intent);
                }
            });
            gobackbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    custom_dialog2.dismiss();
                }
            });
        }
=======
>>>>>>> Stashed changes


    }
}
