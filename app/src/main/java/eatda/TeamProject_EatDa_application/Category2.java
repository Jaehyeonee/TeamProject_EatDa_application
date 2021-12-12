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

public class Category2 extends AppCompatActivity {

    Dialog custom_dialog2;
    Button showrecipebtn;
    Button gobackbtn;

    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

=======
public class Category2 extends AppCompatActivity {
>>>>>>> Stashed changes
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category2);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        final GridView gv2 = (GridView) findViewById(R.id.gv);
        Category2.MyGridAdapter gridAdapter = new Category2.MyGridAdapter(this);
        gv2.setAdapter(gridAdapter);


        //홈버튼
        ImageButton hbtn_l = (ImageButton) findViewById(R.id.hbtn1);
        ImageButton hbtn_r = (ImageButton) findViewById(R.id.hbtn2);

        hbtn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category2.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        hbtn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category2.this, UploadActivity.class);
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
        Integer[] imageID = {R.drawable.c2img1, R.drawable.c2img2, R.drawable.c2img3, R.drawable.c2img4,
                R.drawable.c2img5, R.drawable.c2img6, R.drawable.c2img7, R.drawable.c2img8, R.drawable.c2img9};

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,0);

            imageView.setImageResource(imageID[position]);

            final int pos = position;
<<<<<<< Updated upstream

            custom_dialog2 = new Dialog(Category2.this);
            custom_dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
            custom_dialog2.setContentView(R.layout.custom_dialog2);

            Intent intent = new Intent(Category2.this, ShowCatRecipe2.class);

=======
>>>>>>> Stashed changes
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = (View)View.inflate(Category2.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Category2.this);
                    ImageView ivPoster = (ImageView)dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(imageID[pos]);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageView;
        }


    }
}
