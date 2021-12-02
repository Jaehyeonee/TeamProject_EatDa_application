package eatda.TeamProject_EatDa_application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Dictionary;

public class MyMenu_MainRecycleView extends AppCompatActivity {

    ImageButton hbtn_l;
    ImageButton hbtn_r;

    // List item
    private ArrayList<Dictionary_MyMenu> mItemList;
    // List view
    private MyMenuAdapter customAdapter_addMyMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_activity);

        //홈버튼
        hbtn_l = (ImageButton) findViewById(R.id.hbtn1);
        hbtn_r = (ImageButton) findViewById(R.id.hbtn2);

        hbtn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MyMenu_MainRecycleView.this, SelectCategory.class);
                startActivity(intent2);
            }
        });

        // List 설정
        bindList();

        // 삽입 설정
        bindInsert();
    }

    /**
     * List 설정
     */
    private void bindList() {
        mItemList = new ArrayList<>();
        mItemList.add(new Dictionary_MyMenu(R.drawable.mmimg1, "김치찌개"));
        mItemList.add(new Dictionary_MyMenu(R.drawable.mmimg2, "어향가지"));
        mItemList.add(new Dictionary_MyMenu(R.drawable.mmimg3, "고추장\n삽겹살"));
        mItemList.add(new Dictionary_MyMenu(R.drawable.mmimg4, "스팸마요"));
        mItemList.add(new Dictionary_MyMenu(R.drawable.mmimg5, "나베"));
        mItemList.add(new Dictionary_MyMenu(R.drawable.mmimg6, "떡볶이"));

        //CustomAdapter_AddMyMenu customAdapter_addMyMenu= new CustomAdapter_AddMyMenu(this, mItemList);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Dictionary_MyMenu dict = mItemList.get(position);

                Intent intent = new Intent(getBaseContext(), MenuResult_Activity.class);
                intent.putExtra("imageResId", dict.getImageResId());
                intent.putExtra("strTitle", dict.getTitle());

                startActivity(intent);

            }

        }));


        customAdapter_addMyMenu = new MyMenuAdapter(this,mItemList);
        recyclerView.setAdapter(customAdapter_addMyMenu);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // List item click event 처리

    }
    public interface ClickListener{
        void onClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private GestureDetector gestureDetector;
        private MyMenu_MainRecycleView.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MyMenu_MainRecycleView.ClickListener clickListener2)
        {
            this.clickListener = clickListener2;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }



        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if(child!=null && clickListener!=null&&gestureDetector.onTouchEvent(e)){
                clickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    /**
     * 삽입 설정
     */
    private void bindInsert() {
        findViewById(R.id.addMenubtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Item 추가
                mItemList.add(new Dictionary_MyMenu(R.drawable.mmimg1, "김치찌개" + mItemList.size()));

                // List 반영
                customAdapter_addMyMenu.notifyDataSetChanged();
            }
        });
    }


}
