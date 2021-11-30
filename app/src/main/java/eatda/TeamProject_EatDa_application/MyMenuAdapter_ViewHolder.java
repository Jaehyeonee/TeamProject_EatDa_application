package eatda.TeamProject_EatDa_application;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyMenuAdapter_ViewHolder extends RecyclerView.ViewHolder {

    TextView menu_item_title;
    ImageView menu_item_img;

    public MyMenuAdapter_ViewHolder(View a_itemView, final MyMenuAdapter.OnItemClickEventListener a_itemClickListener) {
        super(a_itemView);

        // Click event
        a_itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a_view) {
                final int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    a_itemClickListener.onItemClick(position);
                }
            }
        });

        menu_item_title = a_itemView.findViewById(R.id.menu_item_title);
        menu_item_img = a_itemView.findViewById(R.id.menu_item_img);
    }
}