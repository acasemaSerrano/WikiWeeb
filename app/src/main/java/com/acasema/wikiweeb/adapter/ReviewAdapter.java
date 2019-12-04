package com.acasema.wikiweeb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.data.modelos.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
    private ArrayList<Review> list;
    private  OnManageReviewListener listener;

    public interface OnManageReviewListener{

        void onEditReview(Review review);
    }


    public ReviewAdapter(OnManageReviewListener litener) {
        //list= (ArrayList) DependencyRepository.getIntancie().getList();
        list =new  ArrayList<>();
        this.listener = litener;
    }
    public ReviewAdapter() {
        //list= (ArrayList) DependencyRepository.getIntancie().getList();
        list =new  ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitulo.setText(list.get(position).getTitulo());
        holder.tvPreview.setText(list.get(position).getPreview(100));
        holder.tvLetraPk.setText(list.get(position).getLetraPk());
        holder.bind(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnManageReviewListener(ReviewAdapter.OnManageReviewListener listenerAdapter) {
        listener = listenerAdapter;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitulo, tvPreview, tvLetraPk;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvPreview = itemView.findViewById(R.id.tvPreview);
            tvLetraPk = itemView.findViewById(R.id.tvLetraPk);

        }
        public  void bind (final Review review, final OnManageReviewListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onEditReview(review);
                }
            });
        }
    }

    public void clear() {
        list.clear();
    }

    public void load(List<Review> dependencyList) {
        list.addAll(dependencyList);
    }

    public void add(Review add){
        list.add(add);
    }
}
