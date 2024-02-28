package com.example.messengerproject.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messengerproject.R;
import com.example.messengerproject.data.item.ItemSelectUser;
import com.example.messengerproject.data.model.User;
import com.example.messengerproject.databinding.ViewItemSelectUserBinding;
import com.example.messengerproject.ui.presenter.SelectUsersPresenter;

import java.util.List;

public class SelectUserAdapter extends RecyclerView.Adapter<SelectUserAdapter.ViewHolder> {

    private List<ItemSelectUser> list;

    private SelectUsersPresenter presenter;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_select_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemSelectUser item = list.get(position);
        holder.binding.iconAvatar.setImageResource(R.drawable.ic_user_1);
        holder.binding.textviewUsername.setText(item.getUsername());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public SelectUserAdapter(List<ItemSelectUser> list, SelectUsersPresenter presenter) {
        this.list = list;
        this.presenter = presenter;
    }

    public SelectUserAdapter() {
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewItemSelectUserBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
