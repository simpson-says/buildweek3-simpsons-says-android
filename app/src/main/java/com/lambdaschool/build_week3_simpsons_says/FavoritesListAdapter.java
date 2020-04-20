package com.lambdaschool.build_week3_simpsons_says;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FavoritesListAdapter extends RecyclerView.Adapter<FavoritesListAdapter.ViewHolder> {
    private ArrayList<Quote> quoteArrayList;
    private DetailsFragment.OnFragmentInteractionListener interactionListener;
    private int lastPositionAnimated = -1;

    public FavoritesListAdapter(ArrayList<Quote> quoteArrayList, DetailsFragment.OnFragmentInteractionListener interactionListener) {
        this.quoteArrayList = quoteArrayList;
        this.interactionListener = interactionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_element_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        final Quote quote = quoteArrayList.get(position);
        viewHolder.imageViewQuote.setImageResource(quote.getImage());
        viewHolder.textViewQuote.setText(quote.toString());
        viewHolder.viewParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interactionListener != null)
                    interactionListener.onFragmentInteraction(quote);
            }
        });
        viewHolder.viewParent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DataAccessObject dao = new DataAccessObject();
                boolean removedFromFavorites = dao.setUserFavorites(quote.getId());

                if (removedFromFavorites) {
                    String messageToText = "Quote #" + String.valueOf(quote.getId()) + " has been de-favorited!";
                    Toast.makeText(v.getContext(), messageToText, (Toast.LENGTH_LONG)).show();
                    notifyItemRemoved(viewHolder.getAdapterPosition());
                    return true;
                }
                return false;
            }
        });

        if (position > lastPositionAnimated) {
            Animation animation = AnimationUtils.loadAnimation(viewHolder.viewParent.getContext(), android.R.anim.slide_in_left);
            viewHolder.viewParent.startAnimation(animation);
            lastPositionAnimated = position;
        }
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
