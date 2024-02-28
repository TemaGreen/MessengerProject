package com.example.messengerproject.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messengerproject.R;
import com.example.messengerproject.data.item.ItemAddUser;
import com.example.messengerproject.databinding.ViewItemAddParticipantBinding;
import com.example.messengerproject.ui.presenter.CreateNewDialogPresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateNewDialogAdapter extends RecyclerView.Adapter<CreateNewDialogAdapter.ViewHolder> {

    List<ItemAddUser> list;

    CreateNewDialogPresenter presenter;

    private Map<Integer, Integer> mapIcon;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_add_participant, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemAddUser item = list.get(position);
        holder.binding.iconAvatar.setImageResource(mapIcon.get(item.getIcon()));
        holder.binding.textviewUsername.setText(item.getName());
        holder.binding.radioButton.setChecked(item.isSelected());
        holder.binding.radioButton.setOnClickListener(v -> {
            presenter.clickItem(position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void initMap() {
        mapIcon = new HashMap<>();
        mapIcon.put(1, R.drawable.ic_user_1);
        mapIcon.put(2, R.drawable.ic_user_2);
        mapIcon.put(3, R.drawable.ic_user_3);
        mapIcon.put(4, R.drawable.ic_user_4);
        mapIcon.put(5, R.drawable.ic_user_5);
        mapIcon.put(6, R.drawable.ic_user_6);
        mapIcon.put(7, R.drawable.ic_user_7);
        mapIcon.put(8, R.drawable.ic_user_8);
        mapIcon.put(9, R.drawable.ic_user_9);
        mapIcon.put(10, R.drawable.ic_user_10);
    }

    public CreateNewDialogAdapter(List<ItemAddUser> list, CreateNewDialogPresenter presenter) {
        this.list = list;
        this.presenter = presenter;
        if (mapIcon == null) initMap();
    }

    public CreateNewDialogAdapter() {
        if (mapIcon == null) initMap();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewItemAddParticipantBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
