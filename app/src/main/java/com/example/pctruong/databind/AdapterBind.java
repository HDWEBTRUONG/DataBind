package com.example.pctruong.databind;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pctruong.databind.databinding.ItemBinding;

import java.util.List;

/**
 * Created by PCTruong on 13/06/2018.
 */

public class AdapterBind extends RecyclerView.Adapter<AdapterBind.ViewHolder> {
    List<User> list;
    public IOnClick iOnClick;
    public AdapterBind(List<User> list,IOnClick iOnClick) {
        this.list = list;
        this.iOnClick=iOnClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item, viewGroup, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
       viewHolder.setBinding(list.get(pos),pos);
       final User user=list.get(pos);
       viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               iOnClick.itemOnClick(user);
           }
       });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        public ObservableField<String> firt_name = new ObservableField<>();
        public ObservableField<String> last_name = new ObservableField<>();
        ItemBinding itemBinding;
        public   User user;
        public ViewHolder(@NonNull ItemBinding itemView)
        {
            super(itemView.getRoot());
            itemBinding=itemView;

        }
        public void setBinding(User user,int pos){
            if(itemBinding.getViewHolder()==null){
                itemBinding.setViewHolder(this);
            }
            this.user=user;
            firt_name.set(user.firt_name);
            last_name.set(user.last_name);

        }

    }
    public interface  IOnClick{
         void itemOnClick(User user);
    }
}
