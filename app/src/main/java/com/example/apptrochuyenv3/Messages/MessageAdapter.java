package com.example.apptrochuyenv3.Messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptrochuyenv3.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private final List<MessageList> messageLists;
    private final Context context;

    public MessageAdapter(List<MessageList> messageLists, Context context) {
        this.messageLists = messageLists;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_adapter_layout, parent, false));
    }
    @Override
public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
    }
    @Override
    public int getItemCount() {
        return messageLists.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView profilePic;
        private TextView name, lastMessage, unseenMessage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profilePic = itemView.findViewById(R.id.profilePic);
            name = itemView.findViewById(R.id.name);
            lastMessage = itemView.findViewById(R.id.lastMessages);
            unseenMessage = itemView.findViewById(R.id.unseenMessages);
        }
    }

}
