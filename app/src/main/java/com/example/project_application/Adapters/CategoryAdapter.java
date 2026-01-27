package com.example.project_application.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application.ModelUi.CategoryButton;
import com.example.project_application.R;

import java.util.List;

//адаптер для кнопочек категорий
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context context;
    private List<CategoryButton> list;

    public CategoryAdapter(Context context, List<CategoryButton> list) {
        this.context = context;
        this.list = list;
    }

    //создание вью и обертка в холдер
    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ui_category,parent, false);
        return new ViewHolder(view);
    }

    //действия для следующих вью
    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        CategoryButton text = list.get(position);
        holder.category.setText(text.getText());
    }

    //кол-во вью
    @Override
    public int getItemCount() {
        return list.size();
    }

    //инициализация
    public class ViewHolder extends RecyclerView.ViewHolder {
        final Button category;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.Button);
        }
    }
}
