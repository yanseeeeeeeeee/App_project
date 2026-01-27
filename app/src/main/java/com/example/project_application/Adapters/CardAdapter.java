package com.example.project_application.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application.ModelUi.CardView;
import com.example.project_application.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private Context context;
    private List<CardView> list;

    public CardAdapter(Context context, List<CardView> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ui_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        CardView card = list.get(position);
        holder.title.setText(card.getTitle()); //берем текст для заголовка
        holder.type.setText(card.getCategory()); //текст для категории
        holder.price.setText(card.getPrice());

        if (!card.isAdded()) {
            holder.add.setText("Добавить");
            holder.add.setBackgroundResource(R.drawable.blue_all_button);
            holder.add.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else {
            holder.add.setText("Убрать");
            holder.add.setBackgroundResource(R.drawable.white_blue_button);
            holder.add.setTextColor(ContextCompat.getColor(context, R.color.Accent));
        }

        holder.add.setOnClickListener(v ->
                card.setAdded(!card.isAdded()));
                holder.itemView.post(() -> notifyItemChanged(position));
    }

    public void updateList(List<CardView> newList) {
        list.clear();
        list.addAll(newList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, type, price;
        Button add;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            type=itemView.findViewById(R.id.type);
            price=itemView.findViewById(R.id.price);
            add = itemView.findViewById(R.id.add_button);

        }
    }
}
