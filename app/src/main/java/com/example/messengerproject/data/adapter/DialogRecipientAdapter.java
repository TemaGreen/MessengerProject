package com.example.messengerproject.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messengerproject.R;
import com.example.messengerproject.component.UserManager;
import com.example.messengerproject.data.item.ItemDialogRecepient;
import com.example.messengerproject.databinding.ViewDialogRecipientBinding;
import com.example.messengerproject.ui.presenter.EditDialogPresenter;

import java.util.List;

import javax.inject.Inject;

public class DialogRecipientAdapter extends RecyclerView.Adapter<DialogRecipientAdapter.ViewHolder> {

    EditDialogPresenter presenter;

    List<ItemDialogRecepient> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_dialog_recipient, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemDialogRecepient item = list.get(position);
        holder.binding.textviewUsername.setText(item.getUsername());
    }

    public DialogRecipientAdapter(List<ItemDialogRecepient> list, EditDialogPresenter presenter) {
        this.list = list;
        this.presenter = presenter;
    }

    public DialogRecipientAdapter() {
    }

    public void setList(List<ItemDialogRecepient> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewDialogRecipientBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
