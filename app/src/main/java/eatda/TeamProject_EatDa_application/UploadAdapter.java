package eatda.TeamProject_EatDa_application;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
//재현
public class UploadAdapter extends RecyclerView.Adapter<UploadAdapter.ViewHolder> {
    private RecyclerView recyclerView;
    private List<AddMenuData> addMenuDataList = new ArrayList<>();
    private List<String>uidList = new ArrayList<>();
    private FirebaseDatabase firebaseDatabase;
    private Context context;

    public interface OnItemClickListener{
        void onItemClick(int a_position);
    }
    private OnItemClickListener itemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(int a_position) {
            notifyItemChanged(mCheckedPosition, null);
            mCheckedPosition = a_position;
            notifyItemChanged(a_position, null);
        }
    };
    private  int mCheckedPosition = -1;



    public UploadAdapter(List<AddMenuData> addMenuDataList, List<String> uidList){

        this.addMenuDataList = addMenuDataList;
        this.uidList=uidList;
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int a_position) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.menuitem_list,viewGroup,false);
        return new ViewHolder(view, itemClickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final AddMenuData item = addMenuDataList.get(position);

        holder.textView.setText(item.getMenuName());
        holder.imageView.setImageURI(Uri.parse(item.getAddMenuImage()));
        context = holder.itemView.getContext();

    }

    @Override
    public int getItemCount() {
        return addMenuDataList.size();

    }
    public AddMenuData getSelected(){
        if(mCheckedPosition > -1){
            return  addMenuDataList.get(mCheckedPosition);
        }
        return null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView, final UploadAdapter.OnItemClickListener itemClickListener) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int position = getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION){
                        itemClickListener.onItemClick(position);
                    }
                }
            });
            textView = itemView.findViewById(R.id.menu_item_title);
            imageView = itemView.findViewById(R.id.menu_item_img);


        }


    }

}
