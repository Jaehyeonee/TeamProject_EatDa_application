package eatda.TeamProject_EatDa_application;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyMenuAdapter extends RecyclerView.Adapter<MyMenuAdapter_ViewHolder> {

    public interface OnItemClickEventListener {
        void onItemClick(int a_position);
    }

    private ArrayList<Dictionary_MyMenu> mItemList;

    private OnItemClickEventListener mItemClickListener = new OnItemClickEventListener() {
        @Override
        public void onItemClick(int a_position) {
            notifyItemChanged(mCheckedPosition, null);
            mCheckedPosition = a_position;
            notifyItemChanged(a_position, null);
        }
    };

    private int mCheckedPosition = -1;

    public MyMenuAdapter(MyMenu_MainRecycleView recycleView, ArrayList<Dictionary_MyMenu> a_list) {
        mItemList = a_list;
    }

    @Override
    public MyMenuAdapter_ViewHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int a_position) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.menuitem_list, a_viewGroup, false);
        return new MyMenuAdapter_ViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMenuAdapter_ViewHolder a_viewHolder, int a_position) {
        final Dictionary_MyMenu item= mItemList.get(a_position);


        a_viewHolder.menu_item_img.setImageResource(item.getImageResId());
        a_viewHolder.menu_item_title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public Dictionary_MyMenu getSelected() {
        if (mCheckedPosition > -1) {
            return mItemList.get(mCheckedPosition);
        }
        return null;
    }





    /*
    private ArrayList<Dictionary_MyMenu> mmList;

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        //protected TextView menu_item_id;
        protected TextView menu_item_title;
        protected ImageView menu_item_img;

        public CustomViewHolder(View view){
            super(view);
            //this.menu_item_id=(TextView)view.findViewById(R.id.menu_item_id);
            this.menu_item_title=(TextView)view.findViewById(R.id.menu_item_title);
            this.menu_item_img=(ImageView) view.findViewById(R.id.menu_item_img);
        }

    }

    public CustomAdapter_AddMyMenu(ArrayList<Dictionary_MyMenu> list){
        this.mmList=list;
    }




    @NonNull
    @Override
    public CustomAdapter_AddMyMenu.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.menuitem_list, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter_AddMyMenu.CustomViewHolder viewholder, int position) {

        final Dictionary_MyMenu item = mmList.get(position);


        viewholder.menu_item_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        viewholder.menu_item_img.setImageResource(item.getMenu_item_img()); //item클릭시 메뉴 설명으로 넘어가는 position생성 필요

        //viewholder.menu_item_title.setText(mmList.get(position).getMenu_item_title());
        //viewholder.menu_item_img.setImageResource(mmList.get(position).getMenu_item_img());


    }

    @Override
    public int getItemCount() {
        return (null != mmList ? mmList.size(): 0);
    }*/
}
