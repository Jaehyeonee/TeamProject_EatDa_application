package eatda.TeamProject_EatDa_application;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

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
                //View dialogView = (View) View.inflate()
            }
        });

        return imageView;
    }
}
