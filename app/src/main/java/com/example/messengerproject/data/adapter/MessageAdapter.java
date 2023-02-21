package com.example.messengerproject.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messengerproject.R;
import com.example.messengerproject.data.item.ItemMessage;
import com.example.messengerproject.databinding.ViewItemMessageBinding;
import com.example.messengerproject.ui.interfaces.IMessageBase;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    List<ItemMessage> list;

    IMessageBase.IPresenter presenter;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_message, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemMessage itemMessage = list.get(position);
        holder.binding.imageAvatar.setImageResource(itemMessage.getIconId());
        holder.binding.textView.setText(itemMessage.getTextMessage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public MessageAdapter(List<ItemMessage> list, IMessageBase.IPresenter presenter) {
        this.list = list;
        this.presenter = presenter;
    }

    public MessageAdapter() {

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewItemMessageBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.binding = DataBindingUtil.bind(itemView);
        }
    }
}

