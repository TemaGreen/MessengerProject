package com.example.messengerproject.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messengerproject.R;
import com.example.messengerproject.component.UserManager;
import com.example.messengerproject.data.item.ItemMessage;
import com.example.messengerproject.databinding.ViewItemMessageBinding;
import com.example.messengerproject.databinding.ViewItemMessageRecipientBinding;
import com.example.messengerproject.ui.interfaces.IMessageBase;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ItemMessage> list;

    IMessageBase.IPresenter presenter;

    private SimpleDateFormat format;

    private int user;

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getId_author() == user){
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 1){
            return new ViewHolderUser(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_item_message, parent, false));
        } else {
            return new ViewHolderRecepient(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_item_message_recipient, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemMessage itemMessage = list.get(position);
        if(holder.getItemViewType() == 1) {
            ViewHolderUser h = (ViewHolderUser) holder;
            h.binding.textMessage.setText(itemMessage.getTextMessage());
            h.binding.timeMessage.setText(format.format(itemMessage.getTime()));
            h.binding.imageAvatar.setImageResource(itemMessage.getIcon());
            h.binding.textViewName.setText(itemMessage.getName());
            
        } else {
            ViewHolderRecepient h = (ViewHolderRecepient) holder;
            h.binding.textMessage.setText(itemMessage.getTextMessage());
            h.binding.timeMessage.setText(format.format(itemMessage.getTime()));
            h.binding.imageAvatar.setImageResource(itemMessage.getIcon());
            h.binding.textViewName.setText(itemMessage.getName());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public MessageAdapter(List<ItemMessage> list, IMessageBase.IPresenter presenter, SimpleDateFormat format, int user) {
        this.list = list;
        this.presenter = presenter;
        this.format = format;
        this.user = user;
    }

    public MessageAdapter() {
    }

    class ViewHolderUser extends RecyclerView.ViewHolder {

        ViewItemMessageBinding binding;

        public ViewHolderUser(@NonNull View itemView) {
            super(itemView);
            this.binding = DataBindingUtil.bind(itemView);
        }
    }

    class ViewHolderRecepient extends RecyclerView.ViewHolder {

        ViewItemMessageRecipientBinding binding;

        public ViewHolderRecepient(@NonNull View itemView) {
            super(itemView);
            this.binding = DataBindingUtil.bind(itemView);
        }
    }
}

