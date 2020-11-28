package com.arraigntech.testdemo.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.arraigntech.testdemo.R;
import com.arraigntech.testdemo.databinding.ItemListLayoutBinding;
import com.arraigntech.testdemo.ui.data.ResultPojo;
import com.arraigntech.testdemo.ui.fragment.ImagePreviewDialog;
import com.arraigntech.testdemo.utility.Utils;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.Holder> {

    private List<ResultPojo.Items> lists;

    public void setResults(List<ResultPojo.Items> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list_layout, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.getBind();
    }

    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ItemListLayoutBinding binding;

        public Holder(@NonNull ItemListLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        private void getBind() {
            binding.setItemIV(lists.get(getAdapterPosition()).volumeInfo);
            itemView.setOnClickListener(v -> {
                Utils.hideSoftKeyboard((AppCompatActivity)itemView.getContext());
                FragmentActivity fragmentActivity = (FragmentActivity) itemView.getContext();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add(R.id.container, new ImagePreviewDialog(lists,getAdapterPosition())).addToBackStack(null).commit();
            });
        }

    }
}
