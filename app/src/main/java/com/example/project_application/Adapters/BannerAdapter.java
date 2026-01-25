package com.example.project_application.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application.Model.BannerImage;
import com.example.project_application.R;

import java.util.List;

//адаптер для баннеров на главном экране в разделе "Акции и новости"
public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {

    private Context context;

    private List<BannerImage> list;

    public BannerAdapter(Context context, List<BannerImage> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BannerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ui_banners, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapter.ViewHolder holder, int position) {
        BannerImage image = list.get(position);
        holder.banner.setImageResource(image.getIdImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView banner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.imageView);
        }
    }
}
