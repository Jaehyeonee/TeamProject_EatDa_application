package eatda.TeamProject_EatDa_application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Category1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category1);

        final GridView gv1 = (GridView) findViewById(R.id.gv1);
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gv1.setAdapter(gridAdapter);


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
                Intent intent = new Intent(Category1.this, MyMenu_MainRecycleView.class);
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
                R.drawable.mmimg3, R.drawable.mmimg4, R.drawable.mmimg5};

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,10,10);

            imageView.setImageResource(imageID[position]);

            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = (View)View.inflate(Category1.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Category1.this);
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
