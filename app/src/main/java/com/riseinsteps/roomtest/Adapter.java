package com.riseinsteps.roomtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private List<Data> dataList;

    public Adapter(Context context, List<Data> modelList) {
        this.context = context;
        this.dataList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(dataList.get(position).getId(), dataList.get(position).getEmail(), dataList.get(position).getFirst_name(),
                dataList.get(position).getLast_name(), dataList.get(position).getAvatar());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id, email, firstName, lastName;
        private ImageView avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.ID);
            email = itemView.findViewById(R.id.email);
            firstName = itemView.findViewById(R.id.first_name);
            lastName = itemView.findViewById(R.id.last_name);
            avatar = itemView.findViewById(R.id.avatar);
        }

        private void setData(final Integer id, final String email, final String firstName, String lastName, final String imageUrl) {
            this.id.setText("ID: " + id.toString());
            this.email.setText("Email: " + email);
            this.firstName.setText("First Name: " + firstName);
            this.lastName.setText("Last name: " + lastName);
            Glide.with(itemView).load(imageUrl).into(avatar);
        }
    }
}
