package com.lambdaschool.build_week3_simpsons_says;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {
    private ArrayList<Quote> quoteArrayList;

    public SearchListAdapter(ArrayList<Quote> quoteArrayList) {
        this.quoteArrayList = quoteArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_element_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.imageViewQuote.setImageResource(R.drawable.placeholder);
        viewHolder.textViewQuote.setText(quoteArrayList.get(position).toString());
        viewHolder.viewParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return quoteArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewQuote;
        TextView textViewQuote;
        View viewParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewQuote=itemView.findViewById(R.id.image_view_element_portrait);
            textViewQuote = itemView.findViewById(R.id.text_view_element_quote);
            viewParent=itemView.findViewById(R.id.card_view_parent);

        }
    }
}
