package eatda.TeamProject_EatDa_application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UploadActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<AddMenuData> addMenuDataList = new ArrayList<>();
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference =firebaseDatabase.getReference();
    private ImageButton addMenubtn;
    private List<MyNickname>nicknameList=new ArrayList<>();
    private List<String> uidList = new ArrayList<>();
    ImageButton hbtn_l;
    ImageButton hbtn_r;
    TextView nick_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_activity);
        recyclerView = findViewById(R.id.recycler_view);
        addMenubtn = findViewById(R.id.addMenubtn);
        nick_tv=findViewById(R.id.nickname_view);


        //Intent intent = getIntent();
        //String result = getIntent().getStringExtra("id");
        //nick_tv.setText(result);

        firebaseDatabase.getReference("My NickName").child("id").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               MyNickname myNickname = snapshot.getValue(MyNickname.class);
               String nick = myNickname.getId();
               nick_tv.setText(nick);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        hbtn_l = (ImageButton) findViewById(R.id.hbtn1);
        hbtn_r = (ImageButton) findViewById(R.id.hbtn2);




        hbtn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(UploadActivity.this, SelectCategory.class);
                startActivity(intent2);
            }
        });

        addMenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(UploadActivity.this, AddMenuActivity.class);
                startActivity(intent2);
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                AddMenuData addMenuData = addMenuDataList.get(position);

                Intent intent = new Intent(UploadActivity.this, MenuResult_Activity.class);
                intent.putExtra("addMenuName", addMenuData.getMenuName());
                intent.putExtra("addMenuIngredient", addMenuData.getIngredient());
                intent.putExtra("addMenuOrder", addMenuData.getOrder());
                intent.putExtra("addMenuImage",addMenuData.getAddMenuImage() );
                startActivity(intent);


            }
        }));




        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final UploadAdapter uploadAdapter = new UploadAdapter(addMenuDataList, uidList);
        recyclerView.setAdapter(uploadAdapter);
        //databaseReference = firebaseDatabase.getReference("Resister My Recipe");

        // 리사이클러 뷰 item 클릭


        firebaseDatabase.getReference("Resister My Recipe").child("data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                addMenuDataList.clear();
                uidList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    AddMenuData addMenuData = ds.getValue(AddMenuData.class);
                    String uidKey = ds.getKey();
                    addMenuDataList.add(addMenuData);
                    uidList.add(uidKey);

                }
                uploadAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public interface ClickListener{
        void onClick(View view, int position);
    }
    public static class RecyclerTouchListener implements  RecyclerView.OnItemTouchListener{
        private GestureDetector gestureDetector;
        private UploadActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final UploadActivity.ClickListener clickListener2 ){
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

}
