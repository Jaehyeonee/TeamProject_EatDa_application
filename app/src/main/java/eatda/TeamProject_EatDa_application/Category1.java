package eatda.TeamProject_EatDa_application;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Category1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category1);

        final GridView gv1 = (GridView) findViewById(R.id.gv1);
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gv1.setAdapter(gridAdapter);
    }
}
