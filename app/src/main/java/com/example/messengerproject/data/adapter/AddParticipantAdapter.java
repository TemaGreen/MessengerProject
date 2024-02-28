package com.example.messengerproject.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messengerproject.R;
import com.example.messengerproject.data.item.ItemAddParticipant;
import com.example.messengerproject.data.model.User;
import com.example.messengerproject.ui.presenter.AddNewParticipantPresenter;
import com.example.messengerproject.databinding.ViewItemAddParticipantBinding;

import java.util.List;
import java.util.stream.Collectors;

public class AddParticipantAdapter extends RecyclerView.Adapter<AddParticipantAdapter.ViewHolder> {

    List<ItemAddParticipant> list;

    AddNewParticipantPresenter presenter;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_add_participant, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemAddParticipant item = list.get(position);
        holder.binding.iconAvatar.setImageResource(R.drawable.ic_user_1);
        holder.binding.textviewUsername.setText(item.getName());
        holder.binding.radioButton.setChecked(item.isFlag());
        holder.binding.radioButton.setOnClickListener(v -> {
            presenter.onClickItem(item);
        });
        holder.binding.selectAddUserDialogContainer.setOnClickListener(v -> {
            presenter.onClickItem(item);
        });
    }

    public AddParticipantAdapter(List<ItemAddParticipant> list, AddNewParticipantPresenter presenter) {
        this.list = list;
        this.presenter = presenter;
    }

    public AddParticipantAdapter() {
    }

    public List<User> getListSelectedItems(){
        return list.stream().filter(item -> item.isFlag()).map(item -> new User(item)).collect(Collectors.toList());
    }

    public void setList(List<ItemAddParticipant> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewItemAddParticipantBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
