package com.example.messengerproject.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messengerproject.R;
import com.example.messengerproject.component.UserManager;
import com.example.messengerproject.data.item.ItemDialog;
import com.example.messengerproject.databinding.ViewItemDialogBinding;
import com.example.messengerproject.ui.interfaces.IDialogsBase;
import com.example.messengerproject.ui.presenter.DialogsPresenter;

import java.util.List;

import javax.inject.Inject;

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.ViewHolder> {

    List<ItemDialog> list;

    IDialogsBase.IPresenter presenter;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_dialog, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemDialog itemDialog = list.get(position);
        holder.binding.nameDialog.setText(itemDialog.getNameDialog());
        holder.binding.lastMessageDialog.setText(itemDialog.getAuthorDialog());
        holder.binding.bodyItemDialog.setOnClickListener(v -> {
            presenter.clickSelectDialog(position);
        });
        holder.binding.btnInfo.setOnClickListener(v -> {
            presenter.clickInfoDialog(position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public DialogAdapter(List<ItemDialog> list, IDialogsBase.IPresenter presenter) {
        this.list = list;
        this.presenter = presenter;
    }

    public DialogAdapter() {
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewItemDialogBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.binding = DataBindingUtil.bind(itemView);
        }
    }
}






















