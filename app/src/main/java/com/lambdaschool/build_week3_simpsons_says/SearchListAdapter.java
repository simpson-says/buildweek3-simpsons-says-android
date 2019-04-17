package com.lambdaschool.build_week3_simpsons_says;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {
    private ArrayList<Quote> quoteArrayList;
    private DetailsFragment.OnFragmentInteractionListener interactionListener;

    public SearchListAdapter(ArrayList<Quote> quoteArrayList, DetailsFragment.OnFragmentInteractionListener interactionListener) {
        this.quoteArrayList = quoteArrayList;
        this.interactionListener = interactionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_element_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final Quote quote = quoteArrayList.get(position);
        viewHolder.imageViewQuote.setImageResource(R.drawable.placeholder);
        viewHolder.textViewQuote.setText(quote.toString());
        viewHolder.viewParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interactionListener != null)
                    interactionListener.onFragmentInteraction(quote);
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
            imageViewQuote = itemView.findViewById(R.id.image_view_element_portrait);
            textViewQuote = itemView.findViewById(R.id.text_view_element_quote);
            viewParent = itemView.findViewById(R.id.card_view_parent);

        }
    }
}
